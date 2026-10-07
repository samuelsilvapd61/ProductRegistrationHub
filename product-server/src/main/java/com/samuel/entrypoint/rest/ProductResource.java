package com.samuel.entrypoint.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductResource {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}

