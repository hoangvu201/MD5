package ra.edu.btvn06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ra.edu.btvn06.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = {"/","/products"})
public class ProductController {
    private List<Product> productList = new ArrayList<>();

    public ProductController() {
        productList.add(new Product("P001", "Áo Thun Nam", 150000, "Áo thun cotton thoáng mát", "/images/ao_thun_nam.jpg"));
        productList.add(new Product("P002", "Quần Jeans Nữ", 300000, "Quần jeans thời trang nữ", "/images/quan_jeans_nu.jpg"));
        productList.add(new Product("P003", "Giày Thể Thao", 500000, "Giày thể thao nam nữ", "/images/giay_the_thao.jpg"));
        productList.add(new Product("P004", "Túi Xách", 450000, "Túi xách da cao cấp", "/images/tui_xach.jpg"));
    }

    @GetMapping
    public String showProducts(@RequestParam(name = "search", required = false) String search, Model model) {
        List<Product> results;
        if (search == null || search.trim().isEmpty()) {
            results = productList;
        } else {
            String keyword = search.trim().toLowerCase();
            results = productList.stream()
                    .filter(p -> p.getName().toLowerCase().contains(keyword))
                    .collect(Collectors.toList());
        }

        model.addAttribute("products", results);
        model.addAttribute("search", search);
        if (results.isEmpty()) {
            model.addAttribute("message", "Không tìm thấy sản phẩm phù hợp");
        }
        return "product_list";
    }
}
