package io.magicbank.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {
    @GetMapping("helloRest")
    public String helloWorld(@RequestParam(required = false) String message){
        return "hello rest" + message;
    }
}
