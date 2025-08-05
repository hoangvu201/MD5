package ra.edu.btvn02.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ra.edu.btvn02.entity.Movie;
import ra.edu.btvn02.repo.MovieDao;

import java.io.IOException;

@WebServlet(urlPatterns = "/AddMovieServlet")
public class AddMovieServlet extends HttpServlet {
    private final static MovieDao movieDao = new MovieDao();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/formAddMovie.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String director = request.getParameter("director");
        String genre = request.getParameter("genre");
        String description = request.getParameter("description");
        int duration = Integer.parseInt(request.getParameter("duration"));
        String language = request.getParameter("language");

        Movie movie = new Movie(title, director, genre, description, duration, language);

        boolean rs = movieDao.addMovie(movie);

        if (rs) {
            response.sendRedirect(request.getContextPath() + "/MovieListServlet");
        } else {
            request.setAttribute("message","Thêm mới thất bại");
            request.getRequestDispatcher("views/formAddMovie.jsp").forward(request, response);
        }
    }
}
