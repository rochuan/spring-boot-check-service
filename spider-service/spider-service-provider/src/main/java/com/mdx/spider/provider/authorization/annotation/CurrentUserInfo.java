package com.mdx.spider.provider.authorization.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在Controller的方法参数中使用此注解，该方法在映射时会注入当前登录的User对象
 *
 * @author jeff.luo
 * @date 2018/8/12.
 * @see
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)

public @interface CurrentUserInfo {
}
