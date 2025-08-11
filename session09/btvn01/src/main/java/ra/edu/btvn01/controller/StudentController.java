package ra.edu.btvn01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.edu.btvn01.model.Student;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = {"/","/studentList"})
public class StudentController {

    @GetMapping
    public String studentList(Model model){
        List<Student> studentList=new ArrayList<>();
        studentList.add(new Student(1,"Nguyễn Văn A",18,"12A3","nva@gmail.com","Hà Nội","0123456789"));
        studentList.add(new Student(2,"Nguyễn Văn B",18,"12A1","nvb@gmail.com","Hà Nam","0123456788"));
        studentList.add(new Student(3,"Nguyễn Văn C",18,"12A2","nvc@gmail.com","Hà Tây","0123456787"));
        studentList.add(new Student(4,"Nguyễn Văn D",18,"12A1","nvd@gmail.com","Mê Linh","0123456786"));
        studentList.add(new Student(5,"Nguyễn Văn E",18,"12A3","nve@gmail.com","Băc Ninh","0123456785"));

        model.addAttribute("studentList",studentList);
        return "studentList";
    }
}
