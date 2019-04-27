package io.magicbank.springboot.bootstrap;

import io.magicbank.springboot.condition.ConditionalOnSystemProperties;
import io.magicbank.springboot.service.CalculateService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;


public class ConditionalOnSystemPropertiesBootstrap {
    @Bean
    @ConditionalOnSystemProperties(name="user.name",value = "1wutao")
    public String helloWorld(){
        return "hello world";
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new SpringApplicationBuilder(ConditionalOnSystemPropertiesBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        String helloWorld = context.getBean("helloWorld", String.class);

        System.out.println(helloWorld);

        context.close();
    }
}
