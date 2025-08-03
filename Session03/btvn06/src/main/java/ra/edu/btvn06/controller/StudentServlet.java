package ra.edu.btvn06.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import ra.edu.btvn06.model.Student;
import ra.edu.btvn06.model.UserLogin;
import ra.edu.btvn06.service.StudentService;

import java.io.IOException;
import java.util.List;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {
    private final StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserLogin user = (UserLogin) session.getAttribute("userLogin");

        if (user == null || !user.isLogin()) {
            resp.sendRedirect("login");
            return;
        }

        List<Student> students = studentService.findAll();
        req.setAttribute("students", students);
        req.getRequestDispatcher("list.jsp").forward(req, resp);
    }
}
