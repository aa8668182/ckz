package com.ckz.core.annotation;

/**
 * @author: caikaizhen
 * @date: 2019/2/27 16:30
 * @Description:
 */

import java.lang.annotation.*;

/**
 * 系统日志注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLog {

    String value();

//    String description() default "";

//    BubbleLog type() default BubbleLog.AECCESS;

}