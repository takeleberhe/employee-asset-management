package com.exceed.employeeAssetM.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

public class KeyInterceptor implements HandlerInterceptor{

     public static final String Header_API_Key="X-API-Key";
     public static final String Expected_API_Key="123";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String key=request.getHeader(Header_API_Key);
        if(Expected_API_Key.equals(key)){
            return true; // allow request
        }else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().write("invalid api key");
            return true; // block the request
        }

    }
}