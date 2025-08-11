package ra.edu.btvn02.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.edu.btvn02.model.User;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = {"/","/home"})
public class UserController {

    private final List<User> users = new ArrayList<>();

    @GetMapping
    public String getForm(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/add")
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        users.add(user);
        model.addAttribute("users", users);
        return "result";
    }

    @GetMapping("/result")
    public String result(Model model) {
        model.addAttribute("users", users);
        return "result";
    }
}
