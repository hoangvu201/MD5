package ra.edu.btvn05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.edu.btvn05.model.User;
import ra.edu.btvn05.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String listProducts(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("userList",users);
        return "userList";
    }
}
