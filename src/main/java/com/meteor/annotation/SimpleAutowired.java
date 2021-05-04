package com.meteor.annotation;

import java.lang.annotation.*;

/**
 * @author Admin
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SimpleAutowired {

    String value() default "";

}
