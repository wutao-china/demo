package io.magicbank.springboot.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

public class OnSystemPropertiesConditional implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attributes = metadata.getAnnotationAttributes(ConditionalOnSystemProperties.class.getName());
        String name = String.valueOf(attributes.get("name"));
        String value = String.valueOf(attributes.get("value"));
        String property = System.getProperty(name);

        return value.equals(property);
    }
}
