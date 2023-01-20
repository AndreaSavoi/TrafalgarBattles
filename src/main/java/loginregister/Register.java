package loginregister;

import singleton.DBconn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Register {

    private static boolean ver;

    private Register() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean RegisterForm(String username, String password) throws SQLException {
        try{
            Connection conn = DBconn.getDBConnection();
            String sql = ("INSERT INTO trafalgarbattles.login (username, password) VALUES (?, ?);");
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            pst.executeUpdate();
            ver = true;
        }catch(Exception e){
            e.printStackTrace();
            ver = false;
        }
        DBconn.closeConnection();
        return ver;
    }

}
