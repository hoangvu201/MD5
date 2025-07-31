package ra.edu.btvn02;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/SaveUser")
public class SaveUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("name", name);
        servletContext.setAttribute("email", email);

        request.getRequestDispatcher("showUser.jsp").forward(request, response);
    }
}
