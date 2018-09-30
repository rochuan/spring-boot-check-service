package com.mdx.spider.provider.authorization.annotation;


import java.lang.annotation.*;

/**
 * 在Controller的方法上使用此注解，该方法在映射时会检查用户是否登录，未登录返回401错误
 *
 * @author jeff.luo
 * @
 * @date 2018/8/12.
 */


@Target({ElementType.TYPE,ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Auth {
}
