package ra.edu.btvn01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.edu.btvn01.model.User;

@Controller
@RequestMapping({"/","user"})
public class UserController {
    @GetMapping
    public String initUsers(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "userForm";
    }

    @PostMapping("/submitForm")
    public String submitForm(@ModelAttribute User user, Model model){
        model.addAttribute("user",user);
        return "result";
    }

}
