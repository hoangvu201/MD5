package ra.edu.btvn03.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ra.edu.btvn03.entity.User;

import java.io.IOException;

@WebServlet(urlPatterns = "/Register")
public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        User user = new User(username, password, email);

        req.setAttribute("message","Đăng ký thành công");
        req.setAttribute("user", user);
        req.getRequestDispatcher("notice.jsp").forward(req, resp);
    }
}
