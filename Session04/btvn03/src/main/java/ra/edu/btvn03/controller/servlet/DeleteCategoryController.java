package ra.edu.btvn03.controller.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ra.edu.btvn03.model.dao.CategoryDAO;
import ra.edu.btvn03.model.entity.Category;

import java.io.IOException;

@WebServlet(urlPatterns = "/deleteCategoryController")
public class DeleteCategoryController extends HttpServlet {
    private final CategoryDAO categoryDAO = new CategoryDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Category category = categoryDAO.findById(id);
        if (category != null) {
            if (!categoryDAO.findProductByCategoryId(category.getId())) {
                categoryDAO.deleteCategory(id);
                req.setAttribute("message", "Category deleted successfully");
            } else {
                req.setAttribute("message", "Category deleted fail");
                categoryDAO.updateStatus(id,false);
            }
        } else {
            req.setAttribute("message", "Category not found");
        }
        resp.sendRedirect("categories");
    }
}
