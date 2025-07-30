package com.example.btvn02;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    private int id = 1;
    private String name = "Huấn";
    private String email = "huanrose@gmail.com";
    private int age = 18;
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("id", id);
        request.setAttribute("name", name);
        request.setAttribute("email", email);
        request.setAttribute("age", age);

        request.getRequestDispatcher("/index.jsp").forward(request,response);

    }

    public void destroy() {
    }
}