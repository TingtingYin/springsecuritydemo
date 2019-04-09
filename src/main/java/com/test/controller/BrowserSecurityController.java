package com.test.controller;

import com.test.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class BrowserSecurityController {

    private RequestCache requestCache = new HttpSessionRequestCache();
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    private SecurityProperties securityProperties;

    @RequestMapping("authentication/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public String requireAuthentication(HttpServletRequest request, HttpServletResponse response)throws IOException {SavedRequest savedRequest = requestCache.getRequest(request,response);
        if (savedRequest != null){
            String targetUrl = savedRequest.getRedirectUrl();
            System.out.println("引发跳转的请求：" + targetUrl);
            if(targetUrl.endsWith(".html")){
                //redirectStrategy.sendRedirect(request,response,securityProperties.getBrowser().getLoginPage());
                response.sendRedirect(securityProperties.getBrowser().getLoginPage());
            }
        }
        return "访问的服务需要身份认证，请引导用户到登录页";
    }

    @RequestMapping("me1")
    public Authentication me1(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

    @RequestMapping("me2")
    public Authentication me2(Authentication authentication){
        return authentication;
    }
}
