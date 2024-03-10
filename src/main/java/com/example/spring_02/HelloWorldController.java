package com.example.spring_02;

import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api/v1")
public class HelloWorldController {

    @GetMapping("/helloworld")
    public String helloWorld() {
        return "HelloWorld";
    }

    @PostMapping("/helloworld")
    public String helloWorldPost() {
        return "HelloWorld - POST";
    }

    @DeleteMapping("/helloworld")
    public String helloWorldDelete() {
        return "HelloWorld - DELETE";
    }



}