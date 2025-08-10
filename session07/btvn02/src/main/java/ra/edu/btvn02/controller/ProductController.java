package ra.edu.btvn02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.edu.btvn02.model.Product;

@Controller
@RequestMapping({"/","/product"})
public class ProductController {
    @GetMapping
    public String showProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute Product product,Model model) {
        model.addAttribute("product", product);
        return "result";
    }
}
