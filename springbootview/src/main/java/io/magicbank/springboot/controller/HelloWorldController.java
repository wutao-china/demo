package io.magicbank.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
    @RequestMapping(value = "helloWorld")
    public String helloWorld(){
        return "helloWorld";
    }

    @ModelAttribute
    public String message(){
        return "hello World !";
    }
}
