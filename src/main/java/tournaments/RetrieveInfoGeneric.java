package tournaments;

import singleton.DBconn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RetrieveInfoGeneric {

    private RetrieveInfoGeneric() {
        throw new IllegalStateException("Utility class");
    }

    public static List<String> getInfo(String query) throws SQLException {
        Connection conn = DBconn.getDBConnection();
        String sql = query;
        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        ResultSetMetaData rsmd = rs.getMetaData();
        int count = rsmd.getColumnCount();

        ArrayList<String> info = new ArrayList<>(count);
        while (rs.next()) {
            int i = 1;
            while (i <= count) {
                info.add(rs.getString(i));
                i++;
            }
        }

        DBconn.closeConnection();

        return info;
    }
}
