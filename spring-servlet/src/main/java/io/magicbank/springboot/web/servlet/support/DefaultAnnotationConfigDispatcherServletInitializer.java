package io.magicbank.springboot.web.servlet.support;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@EnableWebMvc
@ComponentScan(basePackages = "io.magicbank.springboot")
public class DefaultAnnotationConfigDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {   //根容器

        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {    //dispatcherServlet springmvc容器

        return new Class[]{this.getClass()};
    }

    @Override
    protected String[] getServletMappings() {   // 拦截路径
        return new String[]{"/"};
    }
}
