package io.magicbank.invoke.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class UserCenterController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/userCenter/getUser")
    public String getUser(){
        ResponseEntity<String> userStr = restTemplate.postForEntity("http://localhost:8080/user/getUser", null, String.class);
        String user = userStr.getBody();
        ResponseEntity<String> scoreStr = restTemplate.postForEntity("http://localhost:8080/score/getScore", null, String.class);
        String score = scoreStr.getBody();
        return user + score;
    }
}
