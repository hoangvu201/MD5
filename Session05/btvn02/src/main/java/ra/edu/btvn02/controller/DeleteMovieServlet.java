package ra.edu.btvn02.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ra.edu.btvn02.entity.Movie;
import ra.edu.btvn02.repo.MovieDao;

import java.io.IOException;
@WebServlet(urlPatterns = "/DeleteMovieServlet")
public class DeleteMovieServlet extends HttpServlet {
    private  static final MovieDao movieDao = new MovieDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Movie movie = movieDao.getMovieById(id);
        if(movie!=null){
            movieDao.deleteMovie(movie);
            req.setAttribute("message","Xoá thành công");
            resp.sendRedirect(req.getContextPath() + "/MovieListServlet");
        } else {
            req.setAttribute("message","Xoá thất bại");
        }
    }
}