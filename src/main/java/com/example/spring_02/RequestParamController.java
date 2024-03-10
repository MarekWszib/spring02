package com.example.spring_02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RequestParamController {

    @GetMapping("/param/concat")
    public String concat(@RequestParam String left, @RequestParam(required = false, defaultValue = "") String right) {
        return left.concat(right);
    }

    @GetMapping("/param/dodaj")
    public Integer dodaj(@RequestParam List<Integer> liczby) {
        int wynik = 0;
        for (Integer liczba : liczby) {
            wynik += liczba;
        }
        return wynik;
    }

//    // NIE PRZESYŁAĆ OBIEKTÓW W PARAMETRZE!!!
//    @GetMapping("/param/test")
//    public String test(@RequestParam Test test) {
//        return test.toString();
//    }

    @GetMapping("/param/wieksza")
    public String wieksza(@RequestParam Integer left, @RequestParam Integer right) {
        if (left > right) {
            return "LEFT";
        } else if (right > left) {
            return "RIGHT";
        } else {
            return "EQUAL";
        }
    }

}
