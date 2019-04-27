package io.magicbank.springboot.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnSystemPropertiesConditional.class)
public @interface ConditionalOnSystemProperties {
    /**
     * java系统属性名称
     * @return
     */
    String name();

    /**
     * 属性值
     * @return
     */
    String value();
}
