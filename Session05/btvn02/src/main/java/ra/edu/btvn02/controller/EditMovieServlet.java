package ra.edu.btvn02.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ra.edu.btvn02.entity.Movie;
import ra.edu.btvn02.repo.MovieDao;

import java.io.IOException;

@WebServlet(urlPatterns = "/EditMovieServlet")
public class EditMovieServlet extends HttpServlet {
    private static final MovieDao movieDao = new MovieDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Movie movie = movieDao.getMovieById(id);
        req.setAttribute("movie", movie);
        req.getRequestDispatcher("views/formUpdateMovie.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        String title = req.getParameter("title");
        String director = req.getParameter("director");
        String genre = req.getParameter("genre");
        String description = req.getParameter("description");
        int duration = Integer.parseInt(req.getParameter("duration"));
        String language = req.getParameter("language");

        Movie movie = new Movie(id, title, director, genre, description, duration, language); // Phải có ID

        boolean rs = movieDao.editMovie(movie);
        if (rs) {
            resp.sendRedirect(req.getContextPath() + "/MovieListServlet");
        } else {
            req.setAttribute("message", "Sửa thất bại");
            req.setAttribute("movie", movie);
            req.getRequestDispatcher("views/formUpdateMovie.jsp").forward(req, resp);
        }
    }

}
