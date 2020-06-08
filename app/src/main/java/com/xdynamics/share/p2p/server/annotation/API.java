package com.xdynamics.share.p2p.server.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @ProjectName: ShareWebDemo
 * @Package: com.xdynamics.share.p2p.server.annotation
 * @ClassName: Get
 * @Description:
 * @Author: oz
 * @CreateDate: 2020/6/4 15:36
 * @UpdateUser:
 * @UpdateDate: 2020/6/4 15:36
 * @UpdateRemark:
 * @Version: 1.0
 */
@Documented
@Target(METHOD)
@Retention(RUNTIME)
public @interface API {

    String value() default "";

}