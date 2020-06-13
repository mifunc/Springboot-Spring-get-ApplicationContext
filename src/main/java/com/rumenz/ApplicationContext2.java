package com.rumenz;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContext2 {


    private ApplicationContext ac;

    public ApplicationContext2(ApplicationContext ac) {
        this.ac = ac;
    }

    public void getBean(){
        RumenzService rumenzService = (RumenzService) ac.getBean("RumenzService");
        rumenzService.say();
    }


}
