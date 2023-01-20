package loginregister;

import com.mysql.cj.protocol.Resultset;
import singleton.DBconn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

    private static boolean ver = false;

    private Login() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean loginVerify(String username, String password) throws SQLException {

        try {
            Connection conn = DBconn.getDBConnection();
            String sql = "SELECT * FROM trafalgarbattles.login WHERE username = ? and password = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();
            ver = rs.next();
        } finally {
            DBconn.closeConnection();
        }

        return ver;
    }
}
