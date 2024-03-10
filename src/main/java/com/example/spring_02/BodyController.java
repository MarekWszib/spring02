package com.example.spring_02;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

class User {
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

@RestController
public class BodyController {

    @PutMapping(value = "/body/lowercase", consumes = "text/plain") // domyślnie konsumował application/json
    public String get(@RequestBody String string){
        return string.toLowerCase();
    }

    @PostMapping(value = "/body/users")
    @ResponseStatus(HttpStatus.CREATED)
    public String get(@RequestBody User user){
        return user.toString() + " saved!";
    }

    @PutMapping(value = "/body/users")
    public User getUser(@RequestBody User user){
        user.setAge(44);
        return user;
    }


}
