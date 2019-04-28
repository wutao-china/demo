package io.magicbank.springboot.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Order(Ordered.LOWEST_PRECEDENCE+1)
public class HelloWorldApplicationContextInitializer<C extends ConfigurableApplicationContext> implements ApplicationContextInitializer<C>  {
    @Override
    public void initialize(C applicationContext) {
        System.out.println("执行HelloWorldApplicationContextInitializer#initialize（）");
    }
}
