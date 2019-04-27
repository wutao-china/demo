package io.magicbank.springboot.bootstrap;

import io.magicbank.springboot.service.CalculateService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
@SpringBootApplication(scanBasePackages = "io.magicbank.springboot.service")
public class CalculateServiceBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(CalculateServiceBootstrap.class)
                .web(WebApplicationType.NONE)
                .profiles("Java8")
                .run(args);
        CalculateService bean = context.getBean(CalculateService.class);
        Integer sum = bean.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("计算结果"+sum);

        context.close();
    }
}
