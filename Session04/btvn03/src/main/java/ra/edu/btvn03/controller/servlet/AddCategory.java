package ra.edu.btvn03.controller.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ra.edu.btvn03.model.dao.CategoryDAO;
import ra.edu.btvn03.model.entity.Category;

import java.io.IOException;

@WebServlet(urlPatterns = "/addCategory")
public class AddCategory extends HttpServlet {
    private final CategoryDAO categoryDAO = new CategoryDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("view/addCategory.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("cateName");
        String description = req.getParameter("description");

        Category category = new Category(name,description,true);
        boolean result = categoryDAO.addCategory(category);
        if(result){
            req.setAttribute("message","Thêm mới thành công");
            resp.sendRedirect("categories");
        }else {
            req.setAttribute("message","Thêm mới thất bại");
            req.getRequestDispatcher("view/addCategory.jsp").forward(req,resp);
        }
    }
}
