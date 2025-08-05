package ra.edu.btvn02.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ra.edu.btvn02.entity.Movie;
import ra.edu.btvn02.repo.MovieDao;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/MovieListServlet")
public class MovieListServlet extends HttpServlet {
    private static final MovieDao movieDao = new MovieDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Movie> movies = movieDao.getMovies();
        req.setAttribute("movies", movies);
        req.getRequestDispatcher("views/listMovie.jsp").forward(req,resp);
    }
}
