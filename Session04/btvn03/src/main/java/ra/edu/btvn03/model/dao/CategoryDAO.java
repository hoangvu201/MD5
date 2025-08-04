package ra.edu.btvn03.model.dao;

import ra.edu.btvn03.model.entity.Category;
import ra.edu.btvn03.model.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    private final static String JDBC_URL = "jdbc:mysql://localhost:3306/md5_session04";
    private final static String USER = "root";
    private final static String PASS = "12345678";

    public List<Category> getAllActiveCategories() {
        List<Category> list = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM category")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Category c = new Category(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getBoolean("status")
                );
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean addCategory(Category c) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
            ps = conn.prepareStatement("INSERT INTO category(name,description,status) VALUES (?,?,?)");
            ps.setString(1, c.getCateName());
            ps.setString(2, c.getDescription());
            ps.setBoolean(3, c.getStatus());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean updateCategory(Category c) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
            ps = conn.prepareStatement("UPDATE category SET name = ?, description = ?, status = ? WHERE id = ?");
            ps.setString(1, c.getCateName());
            ps.setString(2, c.getDescription());
            ps.setBoolean(3, c.getStatus());
            ps.setInt(4, c.getId());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Category findById(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
            ps = conn.prepareStatement("SELECT * FROM category WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String description = rs.getString("description");
                boolean status = rs.getBoolean("status");
                return new Category(id, name, description, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public boolean deleteCategory(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
            ps = conn.prepareStatement("DELETE FROM category WHERE id = ?");
            ps.setInt(1, id);
            int rs = ps.executeUpdate();
            if (rs > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean findProductByCategoryId(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
            ps = conn.prepareStatement("SELECT COUNT(*) FROM products WHERE category_id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateStatus(int categoryId, boolean status) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
            ps = conn.prepareStatement("UPDATE category SET status = ? WHERE id = ?");
            ps.setBoolean(1, status);
            ps.setInt(2, categoryId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public List<Product> findAllProducts() {
        List<Product> list = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASS);
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM products")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product c = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("category_id"),
                        rs.getInt("count")
                );
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }

}
