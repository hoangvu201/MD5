package ra.edu.btvn10.repository;

import org.springframework.stereotype.Repository;
import ra.edu.btvn10.db.DBUtil;
import ra.edu.btvn10.model.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepository {
    public List<Movie> getMovies() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Movie> list = new ArrayList<>();
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM movie");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Movie movie = new Movie();
                movie.setId(rs.getInt("id"));
                movie.setTitle(rs.getString("title"));
                movie.setDirector(rs.getString("director"));
                movie.setReleaseDate(rs.getDate("release_date"));
                movie.setGenre(rs.getString("genre"));
                movie.setPoster(rs.getString("poster"));
                list.add(movie);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }
        return list;
    }

    public boolean addMovie(Movie movie) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement("INSERT INTO movie(title,director,releaseDate,genre,poster) VALUES(?,?,?,?,?)");
            pstmt.setString(1, movie.getTitle());
            pstmt.setString(2, movie.getDirector());
            pstmt.setDate(3, new java.sql.Date(movie.getReleaseDate().getTime()));
            pstmt.setString(4, movie.getGenre());
            pstmt.setString(5, movie.getPoster());
            int rs =  pstmt.executeUpdate();
            if (rs > 0) {
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }
        return false;
    }

    public boolean updateMovie(Movie movie) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement("UPDATE movie SET title = ?, director = ?, releaseDate = ?, genre = ? WHERE id = ?");
            pstmt.setString(1, movie.getTitle());
            pstmt.setString(2, movie.getDirector());
            pstmt.setDate(3, new java.sql.Date(movie.getReleaseDate().getTime()));
            pstmt.setString(4, movie.getGenre());
            pstmt.setInt(5, movie.getId());
            int rs =  pstmt.executeUpdate();
            if (rs > 0) {
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }
        return false;
    }

    public boolean deleteMovie(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement("DELETE FROM movie WHERE id = ?");
            pstmt.setInt(1, id);
            int rs =  pstmt.executeUpdate();
            if (rs > 0) {
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }
        return false;
    }

    public Movie getMovie(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Movie movie = null;
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM movie WHERE id = ?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                movie = new Movie();
                movie.setId(rs.getInt("id"));
                movie.setTitle(rs.getString("title"));
                movie.setDirector(rs.getString("director"));
                movie.setReleaseDate(rs.getDate("release_date"));
                movie.setGenre(rs.getString("genre"));
                movie.setPoster(rs.getString("poster"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }
        return movie;
    }
}
