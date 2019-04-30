package io.magicbank.springboot.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
    @RequestMapping("")
    public String index(@RequestHeader("Accept-Language") String language, Model model) {
        System.out.println("Accept-Language="+language);
        System.out.println("messge="+model.toString());
        model.addAttribute("Accept-Language", language);
        //int i = 1 / 0;
        return "index";// jsp视图
    }

    @RequestMapping(value = "helloWorld")
    public String helloWorld(){
        return "helloWorld"; // thymeleaf视图
    }

    @ModelAttribute(name = "message")
    public String message(){
        return "hello World !";
    }
}
