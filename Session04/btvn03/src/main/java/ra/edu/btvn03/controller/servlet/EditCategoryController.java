package ra.edu.btvn03.controller.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ra.edu.btvn03.model.dao.CategoryDAO;
import ra.edu.btvn03.model.entity.Category;

import java.io.IOException;

@WebServlet(urlPatterns = "/editCategoryController")
public class EditCategoryController extends HttpServlet {
    private final CategoryDAO categoryDAO = new CategoryDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Category category = categoryDAO.findById(id);
        req.setAttribute("category", category);
        req.getRequestDispatcher("view/editCategory.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id =  Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        boolean status = "1".equals(req.getParameter("status"));

        Category category =new Category(id,name,description,status);
        boolean result = categoryDAO.updateCategory(category);
        if(result){
            req.setAttribute("message","Chỉnh sửa thành công");
            resp.sendRedirect("categories");
        }else {
            req.setAttribute("message","Chỉnh sửa thất bại thất bại");
            req.setAttribute("category",category);
            req.getRequestDispatcher("view/editCategory.jsp").forward(req,resp);
        }

    }
}
