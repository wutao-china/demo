package io.magicbank.springboot.web.servlet.async;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        asyncSupported = true,
        name = "asyncServlet",
        urlPatterns = "/asyncServlet"
)
public class AsyncServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.isAsyncSupported()) {
            AsyncContext asyncContext = req.startAsync();
            asyncContext.addListener(new AsyncListener() {
                @Override
                public void onComplete(AsyncEvent event) throws IOException {
                    println("执行完成");
                }

                @Override
                public void onTimeout(AsyncEvent event) throws IOException {
                    println("执行超时");
                }

                @Override
                public void onError(AsyncEvent event) throws IOException {
                    println("执行错误");
                }

                @Override
                public void onStartAsync(AsyncEvent event) throws IOException {
                    println("启动异步");
                }
            });
            ServletResponse response = asyncContext.getResponse();
            response.setContentType("text/plain;charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.println("hello world");
            writer.flush();
        }


    }

    public void println(Object object){
        String name = Thread.currentThread().getName();
        System.out.println("当前线程={"+name+"]"+object);

    }
}
