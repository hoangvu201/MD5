package ra.edu.btvn02.repo;

import ra.edu.btvn02.connection.DBUtil;
import ra.edu.btvn02.entity.Schedule;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDAO {
    public List<Schedule> getAllSchedule() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Schedule> list = null;
        try {
            conn = DBUtil.openConnection();
            pstmt = conn.prepareStatement("SELECT * FROM schedule");
            rs = pstmt.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Schedule schedule = new Schedule();
                schedule.setId(rs.getInt("id"));
                schedule.setMovieTitle(rs.getString("movie_title"));
                schedule.setMovieId(rs.getInt("movie_id"));
                schedule.setShowTime(rs.getDate("show_time"));
                schedule.setScreenRoomId(rs.getInt("screen_room_id"));
                schedule.setAvailableSeats(rs.getInt("available_seats"));
                schedule.setFormat(rs.getString("format"));
                list.add(schedule);
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return list;
    }

    public boolean addSchedule(Schedule schedule) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.openConnection();
            pstmt = conn.prepareCall("INSERT INTO schedule(movie_title,movie_id,show_time,screen_room_id,avaliable_seats,format) VALUES(?,?,?,?,?,?)");
            pstmt.setString(1, schedule.getMovieTitle());
            pstmt.setInt(2, schedule.getMovieId());
            pstmt.setDate(3,Date.valueOf(schedule.getShowTime().toLocalDate()));
            pstmt.setInt(4,schedule.getScreenRoomId());
            pstmt.setInt(5,schedule.getAvailableSeats());
            pstmt.setString(6,schedule.getFormat());
            int rs = pstmt.executeUpdate();
            if (rs > 0) {
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return false;
    }

    public boolean editSchedule(Schedule schedule) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.openConnection();
            pstmt = conn.prepareCall("UPDATE schedule SET movie_title = ?, movie_id = ?, show_time = ?, screen_room_id = ?, available_seats = ?, format = ? WHERE id = ?");
            pstmt.setString(1, schedule.getMovieTitle());
            pstmt.setInt(2, schedule.getMovieId());
            pstmt.setDate(3,Date.valueOf(schedule.getShowTime().toLocalDate()));
            pstmt.setInt(4,schedule.getScreenRoomId());
            pstmt.setInt(5,schedule.getAvailableSeats());
            pstmt.setString(6,schedule.getFormat());
            pstmt.setInt(7,schedule.getId());
            int rs = pstmt.executeUpdate();
            if (rs > 0) {
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return false;
    }

    public boolean deleteSchedule(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.openConnection();
            pstmt = conn.prepareCall("DELETE FROM schedule WHERE id = ?");
            pstmt.setInt(1, id);
            int rs = pstmt.executeUpdate();
            if (rs > 0) {
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return false;
    }


}
