package com.example.spring_02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathController {

    @GetMapping("/path/{name}")
    public String upperCase(@PathVariable String name) {
        return name.toUpperCase();
    }

    @GetMapping("/path/dodaj/{a}/{b}")
    public Integer dodaj(@PathVariable int a, @PathVariable int b) {
        return a + b;
    }

}
