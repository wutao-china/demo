package io.magicbank.invoke.romoteservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScoreController {
    @RequestMapping(value = "/score/getScore")
    public String getScore(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "userId=1 score=100";
    }
}
