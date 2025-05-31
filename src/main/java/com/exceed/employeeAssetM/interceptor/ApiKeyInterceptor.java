package com.exceed.employeeAssetM.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class ApiKeyInterceptor implements HandlerInterceptor {

    private static final String API_KEY_HEADER = "X-API-KEY";
    private static final String EXPECTED_API_KEY = "12345678";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String apiKey = request.getHeader(API_KEY_HEADER);

        if (EXPECTED_API_KEY.equals(apiKey)) {
            return true; // API key is valid
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
            response.getWriter().write("Invalid or missing API key");
            return false; // Block the request
        }
    }
}