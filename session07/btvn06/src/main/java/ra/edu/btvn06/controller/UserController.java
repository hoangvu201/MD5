package ra.edu.btvn06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.edu.btvn06.model.User;
import ra.edu.btvn06.validator.UserValidator;

@Controller
@RequestMapping(value = {"/","/register"})
public class UserController {
    @Autowired
    private UserValidator userValidator ;

    @GetMapping
    public String registerForm(Model model){
        model.addAttribute("user", new User());
        return "registerForm";
    }

    @PostMapping
    public String register(@ModelAttribute("user") User user, BindingResult bindingResult) {
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "registerForm";
        }
        return "success";
    }
}