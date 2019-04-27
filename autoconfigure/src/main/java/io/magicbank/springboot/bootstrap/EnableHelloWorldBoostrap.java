package io.magicbank.springboot.bootstrap;

import io.magicbank.springboot.annotation.EnableHelloWorld;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@EnableHelloWorld
public class EnableHelloWorldBoostrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableHelloWorldBoostrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // 获取标注的bean
        String helloWorld = context.getBean("helloWorld", String.class);
        System.out.println("输出bean="+helloWorld);

        context.close();
    }
}
