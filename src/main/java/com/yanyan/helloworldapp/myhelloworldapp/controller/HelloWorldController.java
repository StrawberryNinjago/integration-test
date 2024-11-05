package com.yanyan.helloworldapp.myhelloworldapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class
HelloWorldController implements SwaggerHelloWorldController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World! checkout my wagger-ui at <a href=\"http://localhost:8080/swagger-ui.html\">http://localhost:8080/swagger-ui.html</a>";
    }
}
