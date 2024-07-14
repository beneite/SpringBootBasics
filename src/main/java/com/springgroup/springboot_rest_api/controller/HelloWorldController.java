package com.springgroup.springboot_rest_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    // url: http://localhost:8080/getWelcomeMessage
    @GetMapping("/getWelcomeMessage")
    public String returnHelloWorld(){
        return "Hello World";
    }
}
