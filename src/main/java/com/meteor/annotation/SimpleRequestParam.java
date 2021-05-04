package com.meteor.annotation;

import java.lang.annotation.*;

/**
 * @author Admin
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SimpleRequestParam {

    String value() default "";

}
