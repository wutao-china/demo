package io.magicbank.springboot.configuration;

import io.magicbank.springboot.annotation.EnableHelloWorld;
import io.magicbank.springboot.condition.ConditionalOnSystemProperties;
import org.springframework.context.annotation.Configuration;

/**
 * hello world 自动装配
 */
@Configuration//模式注解
@EnableHelloWorld// 激活模块装配
@ConditionalOnSystemProperties(name="user.name",value = "wutao")// 条件装配
public class HelloWorldAutoConfiguration {
}
