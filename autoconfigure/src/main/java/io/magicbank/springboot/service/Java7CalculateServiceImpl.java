package io.magicbank.springboot.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("Java7")
@Service
public class Java7CalculateServiceImpl implements CalculateService{
    @Override
    public Integer sum(Integer... values) {
        System.out.println("Java7");
        int sum = 0;
        for (Integer v: values
             ) {
            sum = sum + v;
        }
        return sum;
    }
}
