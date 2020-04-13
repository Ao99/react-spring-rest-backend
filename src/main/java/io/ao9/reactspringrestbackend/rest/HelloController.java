package io.ao9.reactspringrestbackend.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloController {

    @GetMapping(value="/")
    public String sayHello() {
        return new String("Hello World!");
    }
    
}