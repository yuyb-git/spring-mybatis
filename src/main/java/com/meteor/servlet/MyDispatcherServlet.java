package com.meteor.servlet;

import com.meteor.annotation.*;
import com.meteor.session.SqlSession;
import com.meteor.session.SqlSessionFactory;
import com.meteor.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

/**
 * @ClassName MyDispatcherServlet
 * @Description: TODO
 * @Author Admin
 * @Date 2021/5/3
 * @Version V1.0
 **/
public class MyDispatcherServlet extends HttpServlet{

    private List<String> classNameList = new ArrayList<>();
    private Map<String, Object> ioc = new HashMap<>();
    private Map<String, Method> handlerMap = new HashMap<>();
    private Map<String, Object> controllerMap = new HashMap<>();
    private Map<String, Object> serviceMap = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doDisPatcher(req, resp);
    }

    private void doDisPatcher(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if(handlerMap.isEmpty()){
            return;
        }
        String uri = req.getRequestURI();
        String contextPath = req.getContextPath();
        uri = uri.replace(contextPath, "");
        if(!handlerMap.containsKey(uri)){
            resp.getWriter().print("404 not found");
        }
        Method method = handlerMap.get(uri);
        Class<?>[] parameterTypes = method.getParameterTypes();
        Map<String, String[]> parameterMap = req.getParameterMap();

        Object[] paramValues = new Object[parameterTypes.length];
        for(int i = 0; i < parameterTypes.length; i ++){
            String requestParam = parameterTypes[i].getSimpleName();
            if (requestParam.equals("HttpServletRequest")){
                //参数类型已明确，这边强转类型
                paramValues[i]=req;
                continue;
            }
            if (requestParam.equals("HttpServletResponse")){
                paramValues[i]=resp;
                continue;
            }
            for(Map.Entry<String, String[]> param : parameterMap.entrySet()){
                String value =Arrays.toString(param.getValue()).replaceAll("[\\[\\]]", "").replaceAll(",\\s", ",");
                paramValues[i] = value;
            }
        }

        try {
            method.invoke(controllerMap.get(uri), paramValues);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build("db.properties");
        doScan("com.meteor");
        doIoc(factory);
        doAutoWired();
        initHandlerMapping();
    }

    private void initHandlerMapping() {
        if(ioc.isEmpty()){
            throw new RuntimeException("没有初始化容器类");
        }
        for(Map.Entry<String, Object> entry : ioc.entrySet()){
            Class<?> clazz= entry.getValue().getClass();
            if(clazz.isAnnotationPresent(SimpleController.class) && clazz.isAnnotationPresent(SimpleRequestMapping.class)){
                SimpleController controller = clazz.getAnnotation(SimpleController.class);
                SimpleRequestMapping requestMapping = clazz.getAnnotation(SimpleRequestMapping.class);
                String path = requestMapping.value();
                Method[] methods = clazz.getDeclaredMethods();
                for(Method method : methods){
                    if(method.isAnnotationPresent(SimpleRequestMapping.class)){
                        SimpleRequestMapping methodMapping = method.getAnnotation(SimpleRequestMapping.class);
                        String methodPath = methodMapping.value();
                        methodPath = path + methodPath;
                        handlerMap.put(methodPath, method);
                        controllerMap.put(methodPath, entry.getValue());
                        System.out.println("methodPath:"+methodPath);
                    }
                }
            }
        }
    }

    private void doAutoWired() {
        if(ioc.isEmpty()){
            throw new RuntimeException("没有初始化容器类");
        }
        for(Map.Entry<String, Object> entry : ioc.entrySet()){
            Object bean = entry.getValue();
            Class<?> clazz= bean.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for(Field field : fields){
                if(field.isAnnotationPresent(SimpleAutowired.class)){
                    //SysUserService sysUserService
                    SimpleAutowired autowired = field.getAnnotation(SimpleAutowired.class);
                    //sysUserService
                    String beanName = autowired.value();
                    field.setAccessible(true);
                    try {
                        field.set(bean, ioc.get(beanName));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void doIoc(SqlSessionFactory factory) {
        if(classNameList.isEmpty()){
            throw new RuntimeException("没有初始化容器类");
        }
        SqlSession sqlSession = factory.openSession();
        for(String className : classNameList){
            try {
                Class clazz = Class.forName(className);
                if(clazz.isAnnotationPresent(SimpleController.class)){
                    //controller注解
                    SimpleController controller = (SimpleController) clazz.getAnnotation(SimpleController.class);
                    ioc.put(controller.value(), clazz.newInstance());
                }else if(clazz.isAnnotationPresent(SimpleService.class)){
                    //service注解
                    SimpleService service = (SimpleService) clazz.getAnnotation(SimpleService.class);
                    Object instance = clazz.newInstance();
                    ioc.put(service.value(), instance);

                    Class<?>[] interfaces = clazz.getInterfaces();
                    for(Class<?> i : interfaces){
                        ioc.put(i.getName(), instance);
                    }
                }else if(clazz.isAnnotationPresent(SimpleRepository.class)){
                    //dao注解
                    SimpleRepository repository = (SimpleRepository) clazz.getAnnotation(SimpleRepository.class);
                    ioc.put(repository.value(), sqlSession.getMapper(clazz));
                }
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private void doScan(String scanPackage) {
        URL resource = this.getClass().getClassLoader().getResource("/" + scanPackage.replaceAll("\\.", "/"));
        File scanFile = new File(resource.getFile());
        for(File file : Objects.requireNonNull(scanFile.listFiles())){
            if(file.isDirectory()){
                doScan(scanPackage + "." + file.getName());
            }else{
                if(!file.getName().endsWith(".xml")){
                    String className = scanPackage + "." + file.getName().replace(".class", "");
                    classNameList.add(className);
                    System.out.println("className:" + className);
                }
            }
        }
    }
}
