package io.magicbank.springboot.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Profile("Java8")
@Service
public class Java8CalculateServiceImpl implements CalculateService{

    @Override
    public Integer sum(Integer... values) {
        System.out.println("Java8");
        int sum = Stream.of(values).reduce(0, Integer::sum);
        return sum;
    }
}
