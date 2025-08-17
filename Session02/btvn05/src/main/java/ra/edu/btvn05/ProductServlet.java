package ra.edu.btvn05;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", 1500, "High performance laptop"));
        products.add(new Product(2, "Smartphone", 800, "Latest smartphone model"));

        req.setAttribute("products", products);
        req.getRequestDispatcher("/productList.jsp").forward(req, resp);
    }
}
