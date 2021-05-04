package com.meteor.annotation;

import java.lang.annotation.*;

/**
 * @author Admin
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SimpleService {

    String value() default "";

}
