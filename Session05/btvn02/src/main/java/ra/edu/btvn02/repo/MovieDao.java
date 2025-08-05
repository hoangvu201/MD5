package ra.edu.btvn02.repo;

import ra.edu.btvn02.connection.DBUtil;
import ra.edu.btvn02.entity.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MovieDao {
    public List<Movie> getMovies() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Movie> list = null;
        try {
            conn = DBUtil.openConnection();
            pstmt = conn.prepareStatement("SELECT * FROM movies");
            rs = pstmt.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Movie movie = new Movie();
                movie.setId(rs.getInt("id"));
                movie.setTitle(rs.getString("title"));
                movie.setDirector(rs.getString("director"));
                movie.setGenre(rs.getString("genre"));
                movie.setDescription(rs.getString("description"));
                movie.setDuration(rs.getInt("duration"));
                movie.setLanguage(rs.getString("language"));
                list.add(movie);
            }
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return list;
    }

    public boolean addMovie(Movie movie) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.openConnection();
            pstmt = conn.prepareStatement("INSERT INTO movies (title,director,genre,description,duration,language) VALUES (?,?,?,?,?,?) ");
            pstmt.setString(1, movie.getTitle());
            pstmt.setString(2, movie.getDirector());
            pstmt.setString(3, movie.getGenre());
            pstmt.setString(4, movie.getDescription());
            pstmt.setInt(5, movie.getDuration());
            pstmt.setString(6, movie.getLanguage());
            int rs = pstmt.executeUpdate();
            if (rs > 0) {
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return false;
    }

    public Movie getMovieById(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Movie movie = null;
        try {
            conn = DBUtil.openConnection();
            pstmt = conn.prepareStatement("SELECT * FROM movies WHERE id = ?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                movie = new Movie();
                movie.setId(rs.getInt("id"));
                movie.setTitle(rs.getString("title"));
                movie.setDirector(rs.getString("director"));
                movie.setGenre(rs.getString("genre"));
                movie.setDescription(rs.getString("description"));
                movie.setDuration(rs.getInt("duration"));
                movie.setLanguage(rs.getString("language"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }
        return movie;
    }

    public boolean editMovie(Movie movie) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.openConnection();
            String sql = "UPDATE movies SET title = ?, director = ?, genre = ?, description = ?, duration = ?, language = ? WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, movie.getTitle());
            pstmt.setString(2, movie.getDirector());
            pstmt.setString(3, movie.getGenre());
            pstmt.setString(4, movie.getDescription());
            pstmt.setInt(5, movie.getDuration());
            pstmt.setString(6, movie.getLanguage());
            pstmt.setInt(7, movie.getId());

            int rowsUpdated = pstmt.executeUpdate();
            return rowsUpdated > 0;

        } catch (Exception e) {
            System.err.println("Error updating movie: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close(); // hoặc dùng DBUtil.closeConnection(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    public boolean deleteMovie(Movie movie) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.openConnection();
            pstmt = conn.prepareStatement("DELETE FROM movies WHERE id = ?");
            pstmt.setInt(1, movie.getId());
            int rs = pstmt.executeUpdate();
            if (rs > 0) {
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn);
        }
        return false;
    }


}
