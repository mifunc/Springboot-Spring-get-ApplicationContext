package com.rumenz;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContext1 {

    @Autowired
    ApplicationContext ac;

    public void getBean(){
        RumenzService rumenzService = (RumenzService) ac.getBean("RumenzService");
        rumenzService.say();
    }


}
