package io.magicbank.springboot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

@RestController
public class PropertiesController {
/*    @PostMapping(value = "/add/properties",consumes = "text/properties;charset=UTF-8")
    public String addProperties(@RequestBody Properties properties){
        System.out.println("properties = " + properties.toString());
        return "properties ok";
    }*/

    @PostMapping(value = "/add/properties",consumes = "text/properties;charset=UTF-8")
    public Properties addProperties(@RequestBody Properties properties){
        System.out.println("properties = " + properties.toString());
        return properties;
    }
}
