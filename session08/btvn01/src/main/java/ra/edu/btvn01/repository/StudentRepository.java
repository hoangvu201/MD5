package ra.edu.btvn01.repository;

import org.springframework.stereotype.Repository;
import ra.edu.btvn01.db.DBUtil;
import ra.edu.btvn01.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    public List<Student> findAll() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Student> list = new ArrayList<>();
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement("select * from student");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setDob(rs.getDate("dob"));
                list.add(student);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }
        return list;
    }

    public Student findById(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Student student = null;
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement("select * from student where id = ?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setDob(rs.getDate("dob"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }
        return student;
    }

    public boolean addStudent(Student student) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement("insert into student (name, email, dob) values(?,?,?)");
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getEmail());
            pstmt.setDate(3, new java.sql.Date(student.getDob().getTime()));
            int rs = pstmt.executeUpdate();
            if (rs > 0) {
                return true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }
        return false;
    }

    public boolean updateStudent(Student student) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement("update student set name = ?, email = ?, dob = ? where id = ?");
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getEmail());
            pstmt.setDate(3, new java.sql.Date(student.getDob().getTime()));
            pstmt.setInt(4, student.getId());
            int rs = pstmt.executeUpdate();
            if (rs > 0) {
                return true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }
        return false;
    }

    public boolean deleteStudent(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getConnection();
            pstmt = conn.prepareStatement("delete from student where id = ?");
            pstmt.setInt(1, id);
            int rs = pstmt.executeUpdate();
            if (rs > 0) {
                return true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn);
        }
        return false;
    }
}
