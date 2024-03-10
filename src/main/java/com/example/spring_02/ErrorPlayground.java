package com.example.spring_02;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/errors")
public class ErrorPlayground {

    @GetMapping("/1")
    public ResponseEntity<String> test1() {
//        return ResponseEntity.ok("adada");

//        return ResponseEntity.notFound()
//                .eTag() // informacja o tym kiedy zasb będzie aktualizowany
//                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("GGG");
    }

    @GetMapping("/2")
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public String test2() {
        return "Princess is in another castle";
    }

    // poniższe podejscie nie jest prawidłowe
//    @GetMapping("/3")
//    public String test3() {
//        try {
//            throw new RuntimeException();
//        } catch (RuntimeException e) {
//            return "Sth went wrong";
//        }
//    }

    @GetMapping("/3")
    public String test3() {
        throw new RuntimeException();
    }

//    @ResponseStatus(HttpStatus.CONFLICT)
//    @ExceptionHandler(RuntimeException.class)
//    public String handle (RuntimeException e){
//        return "Sth went wrong:(";
//    }

}
