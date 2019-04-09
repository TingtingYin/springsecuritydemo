package com.test.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class MyAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private SecurityProperties securityProperties;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

       if(LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())){
           System.out.println("登录成功");
           response.setContentType("application/json;charset=utf-8");
           response.getWriter().write(objectMapper.writeValueAsString(authentication));
       }else {
           super.onAuthenticationSuccess(request,response,authentication);
       }

    }
}
