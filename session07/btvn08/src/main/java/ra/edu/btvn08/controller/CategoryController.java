package ra.edu.btvn08.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.edu.btvn08.model.Category;
import ra.edu.btvn08.service.CategoryService;

import java.util.List;

@Controller
@RequestMapping(value = {"/","/category"})
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping
    public String listCategory(Model model){
        List<Category> categories = categoryService.categories();
        model.addAttribute("categories", categories);
        return "listCategory";
    }
}
