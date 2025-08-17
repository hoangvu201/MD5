package ra.edu.btvn02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ra.edu.btvn02.model.Product;
import ra.edu.btvn02.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "product-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        return "addProduct";
    }

    @PostMapping("/add")
    public String addProduct(@RequestParam("id") int id,
                             @RequestParam("name") String name,
                             @RequestParam("price") double price,
                             @RequestParam("desc") String desc,
                             @RequestParam("image") String image,
                             Model model) {
        Product product = new Product(id, name, price, desc, image);
        productService.addProduct(product);
        model.addAttribute("products", productService.getAllProducts());
        return "product-list";
    }
}
