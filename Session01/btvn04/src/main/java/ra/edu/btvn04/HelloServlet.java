package ra.edu.btvn04;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String username = "NguyenVanA";
    private String password = "matkhauco8kytu";
    private String message;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pass = req.getParameter("password");

        if (username.equals(name) && password.equals(pass)) {
            message="Welcome to my world";
            req.setAttribute("message", message);
            req.getRequestDispatcher("welcome.jsp").forward(req, resp);
        } else  {
            message="Invalid username or password";
            req.setAttribute("message", message);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}