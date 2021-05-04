package com.meteor.annotation;

import java.lang.annotation.*;

/**
 * @author Admin
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SimpleRepository {

    String value() default "";

}
