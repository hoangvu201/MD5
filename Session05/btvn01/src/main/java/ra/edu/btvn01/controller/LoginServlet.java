package ra.edu.btvn01.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ra.edu.btvn01.dao.CustomerDao;
import ra.edu.btvn01.enity.Customer;
import ra.edu.btvn01.service.UserSession;

import java.io.IOException;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final CustomerDao customerDao = new CustomerDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Customer customer = customerDao.login(username, password);
        if(customer != null){
            UserSession.customer = customer;
            if (customer.getRole().name().equals("ADMIN")) {
                resp.sendRedirect("admin.jsp");
            } else  {
                resp.sendRedirect("home.jsp");
            }
        }else {
            req.setAttribute("error", "Invalid username or password");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }
}
