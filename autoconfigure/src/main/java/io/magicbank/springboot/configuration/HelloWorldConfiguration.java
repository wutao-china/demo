package io.magicbank.springboot.configuration;

import org.springframework.context.annotation.Bean;

public class HelloWorldConfiguration {

    @Bean
    public String helloWorld() { // 方法名即 Bean 名称
        return "Hello,World,我HelloWorldConfiguration被装配成了bean了";
    }

}
