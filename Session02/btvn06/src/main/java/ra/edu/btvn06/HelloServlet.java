package ra.edu.btvn06;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private final String USERNAME = "admin";
    private final int PASSWORD = 123456;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        int  password = Integer.parseInt(req.getParameter("password"));

        if(!username.equals(USERNAME) || password != PASSWORD){
            req.setAttribute("messageH3", "Đăng nhập thất bại");
            req.setAttribute("messageP","username hoặc mật khẩu sai");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        } else {
            req.setAttribute("messageH3", "Đăng nhập thành công");
            req.setAttribute("messageP","xin chào admin !");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }
}