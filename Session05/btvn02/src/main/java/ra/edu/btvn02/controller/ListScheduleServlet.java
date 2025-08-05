package ra.edu.btvn02.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ra.edu.btvn02.entity.Schedule;
import ra.edu.btvn02.repo.ScheduleDAO;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/ListScheduleServlet")
public class ListScheduleServlet extends HttpServlet {
    private static final ScheduleDAO scheduleDAO = new ScheduleDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Schedule>  scheduleList = scheduleDAO.getAllSchedule();
        req.setAttribute("scheduleList", scheduleList);
        req.getRequestDispatcher("views/listSchedule.jsp").forward(req,resp);
    }
}
