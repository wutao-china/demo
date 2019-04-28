package io.magicbank.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * {@link HelloWorldController}
 */
@Controller
public class HelloWorldController {
    @RequestMapping("")
    public String index(@RequestHeader("Accept-Language") String language, Model model) {
        System.out.println("Accept-Language="+language);
        System.out.println("messge="+model.toString());
        model.addAttribute("Accept-Language", language);
        //int i = 1 / 0;
        return "index";
    }

    @ModelAttribute
    public String language(@RequestHeader("Accept-Language") String language){
        return language;
    }

    @ModelAttribute
    public String messge(){
        return "12121";
    }



}