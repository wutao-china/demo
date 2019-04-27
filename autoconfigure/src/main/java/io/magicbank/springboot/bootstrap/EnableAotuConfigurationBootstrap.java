package io.magicbank.springboot.bootstrap;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@EnableAutoConfiguration
public class EnableAotuConfigurationBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableAotuConfigurationBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // 获取标注的bean
        String helloWorld = context.getBean("helloWorld", String.class);
        System.out.println("输出bean="+helloWorld);

        context.close();
    }
}
