package ra.edu.btvn05;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String confirmPassword = req.getParameter("confirmPassword");

        boolean hasError = false;

        req.setAttribute("username", username);
        req.setAttribute("email", email);

        if (username == null || username.trim().isEmpty()) {
            req.setAttribute("messageUsername", "Username must not be empty");
            hasError = true;
        }

        if (email == null || email.trim().isEmpty()) {
            req.setAttribute("messageEmail", "Email must not be empty");
            hasError = true;
        } else if (!Validation.validateEmail(email)) {
            req.setAttribute("messageEmail", "Invalid email format");
            hasError = true;
        }

        if (password == null || password.trim().isEmpty()) {
            req.setAttribute("messagePassword", "Password must not be empty");
            hasError = true;
        } else if (!Validation.validatePassword(password)) {
            req.setAttribute("messagePassword", "Password must be at least 8 characters long, include upper and lower case letters, digits and special characters");
            hasError = true;
        }

        if (confirmPassword == null || confirmPassword.trim().isEmpty()) {
            req.setAttribute("messageConfirmPassword", "Confirm password must not be empty");
            hasError = true;
        } else if (!confirmPassword.equals(password)) {
            req.setAttribute("messageConfirmPassword", "Passwords do not match");
            hasError = true;
        }

        if (hasError) {
            req.setAttribute("username", username);
            req.setAttribute("email", email);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {
            req.removeAttribute("username");
            req.removeAttribute("email");
            req.setAttribute("messageSuccess", "Registered Successfully");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }

    }
}
