package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconn {

    static Connection conn = null;

    private DBconn() {}

    public static Connection getDBConnection() {
        try{
            if(conn == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost/trafalgarbattles", "root", "Andr3a0m1x7302");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void closeConnection() throws SQLException {
        conn.close();
        conn = null;
    }
}
