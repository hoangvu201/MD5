package ra.edu.btvn06.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import ra.edu.btvn06.model.UserLogin;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "123456789";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            HttpSession session = req.getSession();
            UserLogin user = new UserLogin();
            user.setLogin(true);
            session.setAttribute("userLogin", user);
            resp.sendRedirect("students");
        } else {
            req.setAttribute("error", "Đăng nhập thất bại!");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
