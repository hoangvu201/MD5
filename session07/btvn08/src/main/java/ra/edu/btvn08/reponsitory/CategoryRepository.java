package ra.edu.btvn08.reponsitory;

import org.springframework.stereotype.Repository;
import ra.edu.btvn08.db.DBUtil;
import ra.edu.btvn08.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository {
    public List<Category> getCategories() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Category> categories = null;
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM category");
            rs = pstmt.executeQuery();
            categories = new ArrayList<>();
            while (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt("id"));
                c.setCategoryName(rs.getString("category_name"));
                c.setDescription(rs.getString("description"));
                c.setStatus(rs.getBoolean("status"));
                categories.add(c);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }
        return categories;
    }

    public boolean addCategory(Category c) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement("INSERT INTO category(categoryName, description, status) VALUES (?, ?, ?)");
            pstmt.setString(1, c.getCategoryName());
            pstmt.setString(2, c.getDescription());
            pstmt.setBoolean(3, c.isStatus());
            int rs = pstmt.executeUpdate();
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

    public boolean updateCategory(Category c) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement("UPDATE category SET categoryName = ?, description = ?, status = ? WHERE id = ?");
            pstmt.setString(1, c.getCategoryName());
            pstmt.setString(2, c.getDescription());
            pstmt.setBoolean(3, c.isStatus());
            pstmt.setInt(4, c.getId());
            int rs = pstmt.executeUpdate();
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

    public Category getCategory(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Category c = null;
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM category WHERE id = ?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                c = new Category();
                c.setId(rs.getInt("id"));
                c.setCategoryName(rs.getString("category_name"));
                c.setDescription(rs.getString("description"));
                c.setStatus(rs.getBoolean("status"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }
        return c;
    }

    public boolean deleteCategory(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement("DELETE FROM category WHERE id = ?");
            pstmt.setInt(1, id);
            int rs = pstmt.executeUpdate();
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
}
