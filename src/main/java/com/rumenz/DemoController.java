package com.rumenz;


import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;


@RestController
@CrossOrigin //类上加
public class DemoController {


    @Autowired
    ApplicationContext3  ac; //ApplicationContext1 ApplicationContext2 ApplicationContext3;

    @Autowired
    HttpServletRequest req;

    @GetMapping("/")
    public String index() {

        //ac.getBean();
        //在Controller中获取ApplicationContext
        ServletContext servletContext = req.getSession().getServletContext();
        WebApplicationContext context = (WebApplicationContext) servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
        RumenzService rumenzService= (RumenzService) context.getBean("RumenzService");
        rumenzService.say();

        return "{\"code\":200,\"msg\":\"ok\",\"data\":[\"JSON.IM\",\"json格式化\"]}";
    }
}
