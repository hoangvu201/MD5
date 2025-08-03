package ra.edu.btvn04.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ra.edu.btvn04.model.Student;

import java.io.IOException;

@WebServlet("/edit")
public class StudentEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Student student = StudentListServlet.getById(id);
        req.setAttribute("student", student);
        req.getRequestDispatcher("/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String address = req.getParameter("address");

        Student updated = new Student(id, name, age, address);
        StudentListServlet.update(updated);
        resp.sendRedirect("students");
    }
}
