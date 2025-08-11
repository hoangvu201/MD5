package ra.edu.btvn03.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.edu.btvn03.model.User;

@Controller
@RequestMapping(value = {"/","/home"})
public class UserController {
    @GetMapping
    public String getForm(Model model) {
        model.addAttribute("user", new User());
        return "home";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "home";
        }
        String defaultUsername = "user";
        String defaultPassword = "123456789";

        if (!user.getName().equals(defaultUsername)) {
            bindingResult.rejectValue("name", "error.user", "User Name is incorrect");
            return "home";
        }
        if (!user.getPassword().equals(defaultPassword)) {
            bindingResult.rejectValue("password", "error.user", "Password is incorrect");
            return "home";
        }
        return "success";

    }
}
