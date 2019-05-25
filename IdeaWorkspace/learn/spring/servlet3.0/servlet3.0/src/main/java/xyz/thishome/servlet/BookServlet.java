package xyz.thishome.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/book", asyncSupported = true)
public class BookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("主线程开始" + Thread.currentThread().getName() +
                "==>" + System.currentTimeMillis());

        AsyncContext asyncContext = req.startAsync();

        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                System.out.println("副线程开始" + Thread.currentThread().getName() +
                        "==>" + System.currentTimeMillis());
                try {
                    sayHello();
                    AsyncContext context = req.getAsyncContext();
                    context.complete();
                    context.getResponse();
                    context.getResponse().getWriter().write("success");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("副线程结束" + Thread.currentThread().getName() +
                        "==>" + System.currentTimeMillis());
            }
        });

        System.out.println("主线程结束" + Thread.currentThread().getName() +
                "==>" + System.currentTimeMillis());
    }

    public void sayHello() throws Exception {

        Thread.sleep(3000);

    }

}
