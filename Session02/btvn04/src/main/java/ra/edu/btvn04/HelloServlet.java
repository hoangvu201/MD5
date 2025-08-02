package ra.edu.btvn04;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String productName = req.getParameter("name");
        double productPrice = Double.parseDouble(req.getParameter("price"));
        String description = req.getParameter("description");
        int count = Integer.parseInt(req.getParameter("count"));
        boolean status = Boolean.parseBoolean(req.getParameter("status"));

        Product product = new Product(id,productName,productPrice,description,count,status);

        ServletContext context = getServletContext();
        List<Product> list = (List<Product>) context.getAttribute("list");

        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(product);
        context.setAttribute("list", list);

        req.setAttribute("list", list);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}