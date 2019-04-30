package io.magicbank.springboot.thymeleaf;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;

@ControllerAdvice(assignableTypes = HelloWorldController.class)
public class HelloWorldControllerAdvice {

    @ModelAttribute("Accept-Language")
    public String language(@RequestHeader("Accept-Language") String language){
        return language;
    }

    @ModelAttribute("message")
    public String messge(){
        return "12121";
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> OnException(Throwable throwable) {
        return ResponseEntity.ok(throwable.getMessage());
    }
}
