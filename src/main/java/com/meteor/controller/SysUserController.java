package com.meteor.controller;

import com.meteor.annotation.SimpleAutowired;
import com.meteor.annotation.SimpleController;
import com.meteor.annotation.SimpleRequestMapping;
import com.meteor.annotation.SimpleRequestParam;
import com.meteor.service.SysUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName SysUserController
 * @Description: TODO
 * @Author Admin
 * @Date 2021/5/3
 * @Version V1.0
 **/
@SimpleController("sysUserController")
@SimpleRequestMapping("/user")
public class SysUserController {

    @SimpleAutowired("sysUserService")
    private SysUserService sysUserService;

    @SimpleRequestMapping("/getUser")
    public void getUser(HttpServletRequest request, HttpServletResponse response,
                        @SimpleRequestParam("userId") String userId){
        String userInfo = sysUserService.getUser(Long.parseLong(userId)).toString();
        response.setContentType("application/json;charset=UTF-8");
        try {
            response.getWriter().write(userInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
