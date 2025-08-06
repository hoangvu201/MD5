package ra.edu.btvn06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ra.edu.btvn06.model.Employee;
import ra.edu.btvn06.repository.EmployeeRepository;
import ra.edu.btvn06.service.EmployeeService;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String showList(Model model){
        model.addAttribute("employees",employeeService.getAllEmployees());
        return "listEmployee";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        return "addEmployee";
    }

    @PostMapping
    public String addEmployee(
                              @RequestParam("name") String name,
                              @RequestParam("email") String email,
                              @RequestParam("position") String position,
                              Model model) {

        Employee employee = new Employee( name, email, position);
        employeeService.addEmployee(employee);

        model.addAttribute("employees", employeeService.getAllEmployees());
        return "redirect:/employees";
    }
}
