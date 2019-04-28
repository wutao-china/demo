package io.magicbank.springboot.servlet.support;

import io.magicbank.springboot.config.DispatcherServletConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DefaultAnnotationConfigDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {   //web.xml

        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {    //dispatcherServlet

        return new Class[]{DispatcherServletConfig.class};
    }

    @Override
    protected String[] getServletMappings() {   // 拦截路径
        return new String[]{"/"};
    }
}
