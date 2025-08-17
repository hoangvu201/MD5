package ra.edu.btvn06;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/note")
public class NoteServlet extends HttpServlet {
    private ArrayList<String> noteList = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String note = req.getParameter("noteInput");

        if (note != null && !note.trim().isEmpty()) {
            noteList.add(note);
        }

        req.setAttribute("notes", noteList);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("notes", noteList);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
