package ra.edu.btvn05.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ra.edu.btvn05.model.CartItem;
import ra.edu.btvn05.model.Product;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = {"/","/cart"})
public class CartController {
    private List<Product> products = new ArrayList<>(List.of(
            new Product(1, "Laptop", 10),
            new Product(2, "Chuột", 20),
            new Product(3, "Bàn phím", 15)
    ));

    @GetMapping("/home")
    public String showProducts(Model model) {
        model.addAttribute("products", products);
        return "home";
    }

    @GetMapping("/add")
    public String addToCart(@RequestParam("id") int id, HttpSession session) {
        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cart");
        if (cartItems == null) {
            cartItems = new ArrayList<>();
        }

        Product product = products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);

        if (product != null) {
            boolean found = false;
            for (CartItem cartItem : cartItems) {
                if (cartItem.getProduct().getId() == id){
                    cartItem.setQuantity(cartItem.getQuantity() + 1);
                    found = true;
                    break;
                }
            }
            if (!found) {
                cartItems.add(new CartItem(product, 1));
            }
        }
        session.setAttribute("cart", cartItems);

        return "redirect:/home";
    }

    @GetMapping("/view")
    public String viewCart(HttpSession session,Model model) {
        List<CartItem> cartItems = (List<CartItem>) session.getAttribute("cart");
        if (cartItems == null) {
            cartItems = new ArrayList<>();
        }
        model.addAttribute("cartItems", cartItems);
        return "view";
    }
}
