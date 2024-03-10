package com.example.spring_02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestHeaderController {

    @GetMapping("/heder")
    public String execute(@RequestHeader("MyAuth") String secret) {
        if ("topSecretPassword123!".equals(secret)) {
            return "WORKING ON IT!";
        } else {
            return "ACCESS DENIED";
        }
    }

}
