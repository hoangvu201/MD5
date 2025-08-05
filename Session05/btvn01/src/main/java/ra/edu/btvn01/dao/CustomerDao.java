package ra.edu.btvn01.dao;

import ra.edu.btvn01.enity.Customer;
import ra.edu.btvn01.enity.Role;
import ra.edu.btvn01.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDao {
    public Customer login(String username, String password){
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Customer customer = null;
        try {
            conn = DBUtil.openConnection();
            ps = conn.prepareStatement("select * from customer where username = ? and password = ?");
            ps.setString(1,username);
            ps.setString(2,password);
            rs = ps.executeQuery();
            while (rs.next()){
               customer = new Customer();
               customer.setId(rs.getLong("id"));
               customer.setUsername(rs.getString("username"));
               customer.setPassword(rs.getString("password"));
               customer.setPhone(rs.getString("phone"));
               customer.setAddress(rs.getString("address"));
               customer.setGender(rs.getBoolean("gender"));
               customer.setEmail(rs.getString("email"));
               customer.setRole(Role.valueOf(rs.getString("role")));
            }
        }catch(Exception e){
            e.printStackTrace();
        } finally{
            DBUtil.closeConnection(conn);
        }
        return customer;
    }
}
