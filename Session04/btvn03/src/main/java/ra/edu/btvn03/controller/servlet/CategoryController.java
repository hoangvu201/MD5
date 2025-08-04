package ra.edu.btvn03.controller.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ra.edu.btvn03.model.dao.CategoryDAO;
import ra.edu.btvn03.model.entity.Category;
import ra.edu.btvn03.model.entity.Product;

import java.io.IOException;
import java.util.List;

@WebServlet("/categories")
public class CategoryController extends HttpServlet {
    private final CategoryDAO categoryDAO = new CategoryDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> list = categoryDAO.getAllActiveCategories();
        List<Product> lists = categoryDAO.findAllProducts();
        req.setAttribute("categoryList", list);
        req.setAttribute("productsList", lists);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/listCategory.jsp");
        dispatcher.forward(req, resp);

    }
}
