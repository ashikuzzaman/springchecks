package com.github.ashikuzzaman.javaapichecks.spring;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class AshikHelloWorldExample {

    @RequestMapping("/")
    String home() {
        return "Hello World from Ashik using Spring and Maven with JDK 1.7.0_45!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AshikHelloWorldExample.class, args);
    }

}
