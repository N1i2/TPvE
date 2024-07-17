package org.example.laba_9;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.util.Date;
import java.util.Enumeration;

@WebServlet(name = "task_1", value = "/task_1")
public class task_1 extends HttpServlet {
    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            PrintWriter pw = response.getWriter();
            pw.println("<html><body>");
            pw.println("<p>");
            pw.println("Протокол: "+ request.getProtocol() + "<br/>");
            pw.println("IP-адреса клиента, от имени которого пришел запрос: " + request.getRemoteAddr() + "<br/>");
            pw.println("Имя клиента: " + request.getRemoteHost() + " " + request.getRemoteUser() + "<br/>");
            pw.println("Метод доступа: " + request.getMethod() + "<br/>");
            pw.println("URL: "+ request.getRequestURL() + "<br/>");
            pw.println("Заголовок: <br/>");
            Enumeration< String > e = request.getHeaderNames();
            while (e.hasMoreElements()) {
                String name = e.nextElement();
                String value = request.getHeader(name);
                pw.println(name + " = " + value + "<br/>");
            }
            pw.println(new Date());
            pw.println("</p>");
            pw.println("</body></html>");
    }

    public void destroy() {

    }
}