package ra.edu.btvn01.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String DRIVER =  "com.mysql.jdbc.Driver";
    private static final String URL ="jdbc:mysql://localhost:3306/student_ss08";
    private static final String USERNAME ="root";
    private static final String PASSWORD ="12345678";

    public static Connection getConnection(){
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection conn){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
