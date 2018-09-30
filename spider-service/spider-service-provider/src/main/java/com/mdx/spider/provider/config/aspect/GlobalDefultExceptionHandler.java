package com.mdx.spider.provider.config.aspect;

import com.mdx.common.ObjectResp;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;
import redis.clients.jedis.exceptions.JedisConnectionException;

import javax.servlet.http.HttpServletRequest;
import java.net.ConnectException;


@ControllerAdvice
public class GlobalDefultExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public <T> ObjectResp<?> defaultExceptionHadler(HttpServletRequest request, Exception e) {

        if (e instanceof MethodArgumentNotValidException) {
            return new ObjectResp(1000, e.getMessage());
        }
        if (e instanceof JedisConnectionException) {
            return new ObjectResp(1000, "拒绝连接,请检查缓存服务器是否正常！");
        }
        if (e instanceof ConnectException) {
            return new ObjectResp(1000, "拒绝连接,请检查缓存数据库是否正常！");
        }
        if (e instanceof NoHandlerFoundException){
            return new ObjectResp(404, "自定义异常404，api不存在！");
        }
        return new ObjectResp(500, "系统异常！" + e.getMessage());

    }
}
