package com.mdx.admin.provider.config.aspect;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@Aspect
@Component
@Order(10)
public class WebLoggerAspect {

    private Logger logger = Logger.getLogger(getClass().getName());
    ThreadLocal<Long> gmtStart = new ThreadLocal<Long>();

    public WebLoggerAspect() {

    }

    //定义切面点
    @Pointcut("execution(public * com.mdx.admin.provider.controller.*.*(..))")
    public void pointCutService() {

    }

    @Before(value = "pointCutService()")
    public void doBeforeTask(JoinPoint joinPoint) throws Throwable {
        gmtStart.set(System.currentTimeMillis());
        //接收servlet请求获取参数
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();

        // 记录下请求内容
        logger.info("URL : " + request.getRequestURL().toString());
        logger.info("URI : " + request.getRequestURI());
        logger.info("HTTP_METHOD : " + request.getMethod());
        logger.info("IP : " + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + JSON.toJSON(joinPoint.getArgs()));

    }

    @After(value = "pointCutService()")
    public void doAfterTask() {

    }

    @AfterReturning(returning = "responseObj", pointcut = "pointCutService()")
    public void doAfterReturningTask(Object responseObj) {
        // 处理完请求，返回内容
        logger.info("response : " + JSON.toJSON(responseObj));
        logger.info("SPEND TIME : " + (System.currentTimeMillis() - gmtStart.get()));
    }

    @AfterThrowing("pointCutService()")
    public void doAfterThrowingTask() {

        logger.info("抛出异常了！");
    }
}
