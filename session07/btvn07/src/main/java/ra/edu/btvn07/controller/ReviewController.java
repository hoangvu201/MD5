package ra.edu.btvn07.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.edu.btvn07.model.Review;

@Controller
@RequestMapping({"/","/review"})
public class ReviewController {
    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("review", new Review());
        return "reviewForm";
    }

    @PostMapping
    public String processForm(@Valid @ModelAttribute("review") Review review, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "reviewForm";
        }
        model.addAttribute("message", "Gửi đánh giá thành công");
        return "success";
    }
}
