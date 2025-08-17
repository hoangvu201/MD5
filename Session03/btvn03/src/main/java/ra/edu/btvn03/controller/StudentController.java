package ra.edu.btvn03.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import ra.edu.btvn03.model.Student;

import java.io.IOException;

@WebServlet(name = "StudentController", value = "/student")
public class StudentController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");
        String address = request.getParameter("address");

        // Kiểm tra tính hợp lệ
        String error = null;
        int age = 0;

        if (name == null || name.trim().isEmpty() ||
                address == null || address.trim().isEmpty() ||
                ageStr == null || ageStr.trim().isEmpty()) {
            error = "Vui lòng nhập đầy đủ thông tin!";
        } else {
            try {
                age = Integer.parseInt(ageStr);
                if (age <= 0) error = "Tuổi phải lớn hơn 0!";
            } catch (NumberFormatException e) {
                error = "Tuổi phải là số nguyên!";
            }
        }

        if (error != null) {
            request.setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } else {
            Student student = new Student(name, age, address);
            request.setAttribute("student", student);
            request.getRequestDispatcher("notice.jsp").forward(request, response);
        }
    }
}
