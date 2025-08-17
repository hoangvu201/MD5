package ra.edu.btvn02.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import ra.edu.btvn02.model.Student;

import java.io.IOException;

@WebServlet("/form")
public class StudentController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");

        Student student = new Student(name,age,address);
        request.setAttribute("student",student);

        request.getRequestDispatcher("notice.jsp").forward(request, response);
    }
}
