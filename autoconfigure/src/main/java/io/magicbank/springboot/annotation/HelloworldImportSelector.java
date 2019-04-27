package io.magicbank.springboot.annotation;

import io.magicbank.springboot.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class HelloworldImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        System.out.println("编程式模块装配，选择那些需要装配的类，比注解灵活");
        return new String[]{HelloWorldConfiguration.class.getName()};
    }
}
