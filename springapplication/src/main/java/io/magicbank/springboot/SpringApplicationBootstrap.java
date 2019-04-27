package io.magicbank.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;
import java.util.Set;

//@SpringBootApplication //里面有@SpringBootConfiguration最终是@Configuration元注解
public class SpringApplicationBootstrap {
    public static void main(String[] args) {
        {
            // 参数是配置类，不一定主类,例如ConfigurationClass也行
            //SpringApplication.run(SpringApplicationBootstrap.class, args);
        }

        {
            Set<String> sources = new HashSet<>();
            sources.add(Configurational.class.getName());

            SpringApplication springApplication = new SpringApplication();
            springApplication.setSources(sources);
            //springApplication.setWebApplicationType(WebApplicationType.NONE);// 配置为非web应用，默认web
            ConfigurableApplicationContext context = springApplication.run(args);

            Configurational configurationClass = context.getBean(Configurational.class);

            System.out.println(configurationClass.toString());
        }
    }


    @SpringBootApplication
    public static class Configurational {

    }
}
