package ra.edu.btvn02.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ra.edu.btvn02.entity.Movie;
import ra.edu.btvn02.entity.Schedule;
import ra.edu.btvn02.repo.MovieDao;
import ra.edu.btvn02.repo.ScheduleDAO;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebServlet(urlPatterns = "/AddScheduleServlet")
public class AddScheduleServlet extends HttpServlet {
    private static final ScheduleDAO scheduleDAO = new ScheduleDAO();
    private static final MovieDao movieDAO = new MovieDao();
    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/addSchedule.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int movieId = Integer.parseInt(req.getParameter("movieId"));
        String showTimeStr = req.getParameter("showTime");
        String screenRoomId = req.getParameter("screenRoomId");
        int availableSeats = Integer.parseInt(req.getParameter("availableSeats"));
        String format =  req.getParameter("format");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        LocalDateTime showTime = LocalDateTime.parse(showTimeStr,dtf);

        Movie movie = movieDAO.getMovieById(movieId);
        if(movie != null){
            Schedule schedule = new Schedule();
            schedule.setMovieId(movieId);
            schedule.setMovieTitle(movie.getTitle());
            schedule.setShowTime(showTime);
        }

    }
}
