package com.rumenz;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContext3  implements ApplicationContextAware {


    private ApplicationContext ac;


    public void getBean(){
        RumenzService rumenzService = (RumenzService) ac.getBean("RumenzService");
        rumenzService.say();
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
           this.ac=applicationContext;
    }
}
