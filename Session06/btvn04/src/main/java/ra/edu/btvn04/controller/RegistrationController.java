package ra.edu.btvn04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ra.edu.btvn04.model.User;

@Controller
public class RegistrationController {
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/register")
    public String register(
            @RequestParam("username") String username,
            @RequestParam("email") String email,
            @RequestParam("phoneNumber") String phoneNumber,
            Model model) {
            boolean hasError = false;

            if (username == null || username.isEmpty()) {
                model.addAttribute("usernameError", "Tên không được để trống");
                hasError = true;
            }
            if (email == null ||!email.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                model.addAttribute("emailError","Email không đúng định dạng");
                hasError = true;
            }
            if (phoneNumber == null || !phoneNumber.matches("^(0|\\+84)[35789]\\d{8}$")) {
                model.addAttribute("phoneError", "Số điện thoại không hợp lệ");
                hasError = true;
            }
            if (hasError) {
                model.addAttribute("username", username);
                model.addAttribute("email", email);
                model.addAttribute("phoneNumber", phoneNumber);
                return "registration";
            } else {
                User user = new User(username, email, phoneNumber);
                model.addAttribute("user", user);
                return "result";
            }
    }
}
