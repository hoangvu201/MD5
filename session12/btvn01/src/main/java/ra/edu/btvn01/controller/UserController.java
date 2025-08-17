package ra.edu.btvn01.controller;

import com.cloudinary.Cloudinary;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.edu.btvn01.dto.UserRequest;
import ra.edu.btvn01.model.entity.User;
import com.cloudinary.utils.ObjectUtils;
import ra.edu.btvn01.service.UserService;


import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping(value = {"/","/auth"})
public class UserController {
    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private UserService userService;

    @GetMapping
    public String showRegister(Model model) {
        model.addAttribute("userRq", new UserRequest());
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(@Valid @ModelAttribute("userRq") UserRequest userRq,
                             BindingResult bindingResult,
                             Model model) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        if (userService.existsByEmail(userRq.getEmail())) {
            model.addAttribute("emailError", "Email này đã được đăng ký");
            return "register";
        }

        User user = new User();
        user.setEmail(userRq.getEmail());
        user.setPassword(userRq.getPassword());
        user.setFullName(userRq.getFullName());

        if (userRq.getAvatar() != null && !userRq.getAvatar().isEmpty()) {
            try {
                Map uploadResult = cloudinary.uploader().upload(
                        userRq.getAvatar().getBytes(),
                        ObjectUtils.emptyMap()
                );
                user.setAvatar( uploadResult.get("secure_url").toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        userService.register(user);
        return "redirect:/auth/login";
    }

    @GetMapping("/login")
    public String showLogin(Model model) {
        model.addAttribute("userRq", new UserRequest());
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@Valid @ModelAttribute("userRq") UserRequest userRq,
                          BindingResult bindingResult,
                          HttpSession session,
                          Model model) {
            if (bindingResult.hasErrors()) {
                return "login";
            }

            User user = userService.login(userRq.getEmail(), userRq.getPassword());
            if (user != null) {
                session.setAttribute("user", user);
                return "redirect:/post/home";
            }else {
                model.addAttribute("error", "Sai email hoặc mật khẩu");
                return "login";
            }
    }
}
