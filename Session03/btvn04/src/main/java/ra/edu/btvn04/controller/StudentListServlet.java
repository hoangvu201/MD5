package ra.edu.btvn04.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import ra.edu.btvn04.model.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/students")
public class StudentListServlet extends HttpServlet {
    private static final List<Student> studentList = new ArrayList<>();

    @Override
    public void init() {
        if (studentList.isEmpty()) {
            studentList.add(new Student(1, "Nguyen Van A", 20, "Hanoi"));
            studentList.add(new Student(2, "Tran Thi B", 22, "Da Nang"));
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("studentList", studentList);
        req.getRequestDispatcher("/list.jsp").forward(req, resp);
    }

    public static Student getById(int id) {
        return studentList.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    public static void update(Student student) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == student.getId()) {
                studentList.set(i, student);
                break;
            }
        }
    }

    public static void delete(int id) {
        studentList.removeIf(s -> s.getId() == id);
    }
}
