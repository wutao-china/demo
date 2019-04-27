package io.magicbank.springboot.bootstrap;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "io.magicbank.springboot.repository")
public class RepositoryBoostrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(RepositoryBoostrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // 获取标注的bean
        Object secendLevelRepository = context.getBean("mySecendRepossitory");
        System.out.println("输出bean="+secendLevelRepository.toString());

        context.close();
    }
}
