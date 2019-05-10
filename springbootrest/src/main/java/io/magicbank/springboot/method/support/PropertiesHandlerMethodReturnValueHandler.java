package io.magicbank.springboot.method.support;

import io.magicbank.springboot.http.converter.property.PropertiesMessageConverter;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

public class PropertiesHandlerMethodReturnValueHandler implements HandlerMethodReturnValueHandler {
    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        return Properties.class.equals(returnType.getMethod().getReturnType());
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
        // 解析http协议，拿到请求媒体类型
        ServletWebRequest servletWebRequest = (ServletWebRequest) webRequest;
        HttpServletRequest request = servletWebRequest.getRequest();
        String header = request.getHeader("Content-Type");
        MediaType mediaType = MediaType.parseMediaType(header);

        HttpServletResponse response = servletWebRequest.getResponse();
        HttpOutputMessage message = new ServletServerHttpResponse(response);

        // 拿到相应内容
        Properties properties = (Properties) returnValue;

        // 转化器转化相应内容后输出
        PropertiesMessageConverter converter = new PropertiesMessageConverter();
        converter.write(properties,mediaType,message);
    }
}
