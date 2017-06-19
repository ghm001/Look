package com.look.utils.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created by gaohongming on 2017/4/20.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Component
public @interface MyBatisScan {
    String value() default "";
}
