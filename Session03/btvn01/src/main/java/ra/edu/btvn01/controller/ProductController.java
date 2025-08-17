package ra.edu.btvn01.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ra.edu.btvn01.model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/ProductController")
public class ProductController extends HttpServlet {
    private List<Product> productList = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        productList.add(new Product(1, "Laptop", 1000, "Laptop văn phòng"));
        productList.add(new Product(2, "Điện thoại", 500, "Smartphone cấu hình cao"));
        productList.add(new Product(3, "Tai nghe", 100, "Tai nghe Bluetooth"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("productList", productList);
        req.getRequestDispatcher("/productList.jsp").forward(req, resp);
    }
}
