package com.rumenz;


import org.springframework.stereotype.Service;

@Service("RumenzService")
public class RumenzService {

    public void say() {
        System.out.println("RumenzService.say");
    }
}
