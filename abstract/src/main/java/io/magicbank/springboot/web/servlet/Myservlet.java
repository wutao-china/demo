package io.magicbank.springboot.web.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/my/servlet",asyncSupported=true)
public class Myservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AsyncContext asyncContext = req.startAsync();

        // 异步servlet
        asyncContext.start(()->{
            try {
                resp.getWriter().print("hello world");

                // 触发完成
                asyncContext.complete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        // 同步servlet
        //resp.getWriter().print("hello world");
    }
}
