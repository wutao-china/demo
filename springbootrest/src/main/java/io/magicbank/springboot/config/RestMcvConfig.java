package io.magicbank.springboot.config;

import io.magicbank.springboot.http.support.property.PropertiesMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class RestMcvConfig implements WebMvcConfigurer {
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

        //converters.add(new PropertiesMessageConverter());
        converters.set(0, new PropertiesMessageConverter());
    }
}
