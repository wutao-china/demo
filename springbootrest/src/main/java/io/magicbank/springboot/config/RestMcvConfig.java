package io.magicbank.springboot.config;

import io.magicbank.springboot.http.converter.property.PropertiesMessageConverter;
import io.magicbank.springboot.http.support.property.PropertiesHandlerMethodArgumentResolver;
import io.magicbank.springboot.method.support.PropertiesHandlerMethodReturnValueHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class RestMcvConfig implements WebMvcConfigurer {
    @Autowired
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

    @PostConstruct
    public void init(){
        List<HandlerMethodArgumentResolver> resolvers = requestMappingHandlerAdapter.getArgumentResolvers();
        List<HandlerMethodArgumentResolver> newResolvers = new ArrayList<>(resolvers.size() + 1);
        newResolvers.add(new PropertiesHandlerMethodArgumentResolver());
        newResolvers.addAll(resolvers);
        requestMappingHandlerAdapter.setArgumentResolvers(newResolvers);

        List<HandlerMethodReturnValueHandler> returnValueHandlers = requestMappingHandlerAdapter.getReturnValueHandlers();
        ArrayList<HandlerMethodReturnValueHandler> newReturnValueHandlers = new ArrayList<>(returnValueHandlers.size()+1);
        newReturnValueHandlers.add(new PropertiesHandlerMethodReturnValueHandler());
        newReturnValueHandlers.addAll(returnValueHandlers);
        requestMappingHandlerAdapter.setReturnValueHandlers(newReturnValueHandlers);

    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

        //converters.add(new PropertiesMessageConverter());
        converters.set(0, new PropertiesMessageConverter());
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        /* 添加自定义的，优先级低于内部创建的
        if(CollectionUtils.isEmpty(resolvers)){
            resolvers.add(new PropertiesHandlerMethodArgumentResolver());
        } else {
            resolvers.set(0, new PropertiesHandlerMethodArgumentResolver());
        }*/
    }
}
