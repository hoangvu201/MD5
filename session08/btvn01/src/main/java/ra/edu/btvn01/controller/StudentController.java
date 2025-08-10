package ra.edu.btvn01.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ra.edu.btvn01.model.Student;
import ra.edu.btvn01.service.StudentService;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public String showStudent(Model model) {
        List<Student> list = studentService.getAll();
        model.addAttribute("list", list);
        return "list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "add";
    }

    @PostMapping("/add")
    public String addStudent(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add";
        }
        studentService.saveStudent(student);
        return "list";
    }

    @GetMapping("/update")
    public String showUpdateForm(@RequestParam("id") int id, Model model) {
        Student student = studentService.getById(id);
        if (student == null) {
            return "update";
        }
        model.addAttribute("student", student);
        return "update";
    }

    @PostMapping("/update")
    public String updateStudent(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "update";
        }
        studentService.updateStudent(student);
        return "list";
    }

    @PostMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("id") int id) {
        studentService.deleteStudent(id);
        return "list";
    }

}
