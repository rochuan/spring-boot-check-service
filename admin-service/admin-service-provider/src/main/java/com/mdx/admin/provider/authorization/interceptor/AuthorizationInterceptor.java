package com.mdx.admin.provider.authorization.interceptor;

import com.alibaba.fastjson.JSON;

import com.mdx.admin.provider.authorization.annotation.Auth;
import com.mdx.admin.provider.authorization.manager.AccessTokenManager;
import com.mdx.admin.api.error.ErrorCode;
import com.mdx.common.ObjectResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;

@Component
public class AuthorizationInterceptor  extends HandlerInterceptorAdapter {

    @Autowired
    private AccessTokenManager accessTokenManager;

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        //如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //从header中得到token
        String accessToken = request.getHeader("Auth");
        //验证token
        String accessTokenValue = accessTokenManager.getAccessToken(accessToken);
        if (accessTokenValue != null) {
            //如果token验证成功，将token对应的用户id存在request中，便于之后注入
            Long adminId = Long.parseLong(accessTokenValue);
            request.setAttribute("adminId", adminId);
            return true;
        }
        //如果验证token失败，并且方法注明了Authorization，返回401错误
        if (method.getAnnotation(Auth.class) != null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json; charset=utf-8");

            PrintWriter out = response.getWriter();
            ObjectResp resp = new ObjectResp(ErrorCode.NO_LOGIN);
            Object object = JSON.toJSON(resp);
            out.print(object.toString());
            out.flush();
            out.close();

            return false;
        }
        return true;
    }

}
