package io.magicbank.springboot.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;

@Order
public class AfterHelloWorldApplicationContextInitializer<C extends ConfigurableApplicationContext> implements ApplicationContextInitializer<C>  {
    @Override
    public void initialize(C applicationContext) {
        System.out.println("执行AfterHelloWorldApplicationContextInitializer#initialize（）");
    }
}
