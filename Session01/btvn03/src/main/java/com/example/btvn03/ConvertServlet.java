package com.example.btvn03;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/convert")
public class ConvertServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        float usd = Float.parseFloat(req.getParameter("usd"));
        float rate = Float.parseFloat(req.getParameter("rate"));

        float total = usd * rate;

        req.setAttribute("usd", usd);
        req.setAttribute("rate", rate);
        req.setAttribute("total", total);

        req.getRequestDispatcher("total.jsp").forward(req, resp);

    }


    public void destroy() {
    }
}