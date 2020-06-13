Springboot/Spring获取ApplicationContext

- 直接注入 / @Autowired
- 构造器注入
- 实现ApplicationContextAware接口
- 在Controller中获取ApplicationContext

## 直接注入 / @Autowired

```java
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

```

## 构造器注入

```java
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

```

## 实现ApplicationContextAware接口

```java
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

```

## 在Controller中获取ApplicationContext

```java
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
```

