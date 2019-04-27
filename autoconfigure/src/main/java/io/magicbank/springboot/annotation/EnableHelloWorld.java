package io.magicbank.springboot.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Import(HelloWorldConfiguration.class)//注解实现
@Import(HelloworldImportSelector.class)//基于接口实现
public @interface EnableHelloWorld {
}
