package io.magicbank.invoke.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

@RestController
public class UserCenterAsynController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/asyn/userCenter/getUser")
    public String getUser(){
        Callable userCallable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                ResponseEntity<String> userStr = restTemplate.postForEntity("http://localhost:8080/user/getUser", null, String.class);
                return userStr.getBody();
            }
        };
        FutureTask<String> futureTask1 = new FutureTask<String>(userCallable);
        new Thread(futureTask1).start();

        Callable scoreCallable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                ResponseEntity<String> scoreStr = restTemplate.postForEntity("http://localhost:8080/score/getScore", null, String.class);
                return scoreStr.getBody();
            }
        };
        FutureTask<String> futureTask2 = new FutureTask<String>(scoreCallable);
        new Thread(futureTask2).start();

        try {
            return futureTask1.get() + futureTask2.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return null;
    }
}
