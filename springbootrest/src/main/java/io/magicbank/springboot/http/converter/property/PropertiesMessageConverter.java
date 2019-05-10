package io.magicbank.springboot.http.converter.property;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Properties;

public class PropertiesMessageConverter extends AbstractGenericHttpMessageConverter<Properties> {
    public PropertiesMessageConverter() {
        super(new MediaType("text", "properties"));
    }

    @Override
    protected Properties readInternal(Class<? extends Properties> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        // 从头里面获取媒体类型
        HttpHeaders headers = inputMessage.getHeaders();
        MediaType contentType = headers.getContentType();
        Charset charset = contentType.getCharset();
        charset = charset == null ? Charset.forName("UTF-8"):charset;

        InputStream inputStream = inputMessage.getBody();
        InputStreamReader reader = new InputStreamReader(inputStream, charset);
        Properties properties = new Properties();
        properties.load(reader);
        return properties;
    }

    @Override
    protected void writeInternal(Properties properties, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        // 从头里面获取媒体类型
        HttpHeaders headers = outputMessage.getHeaders();
        MediaType contentType = headers.getContentType();
        Charset charset = contentType.getCharset();
        charset = charset == null ? Charset.forName("UTF-8"):charset;

        OutputStream outputStream = outputMessage.getBody();
        OutputStreamWriter writer = new OutputStreamWriter(outputStream, charset);
        properties.store(writer,"");
    }


    @Override
    public Properties read(Type type, Class<?> contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return readInternal(null, inputMessage);
    }
}
