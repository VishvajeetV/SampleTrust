package com.sample.demo.domain.user.util;

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Documented;


@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HasPermission {
    /**
     *  role = "SUPER_ADMIN".
     *
     * @return String
     */
    String role() default "";

    /**
     *  anyOf = "list_user,add_user".
     *
     * @return String
     */
    String anyOf() default "";


    /**
     *  allOf = "list_user,add_user".
     *
     * @return String
     */
    String allOf() default "";
}