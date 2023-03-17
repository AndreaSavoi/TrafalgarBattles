package dao;

import queries.queries;
import singleton.CurrentUser;
import singleton.DBconn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class logRegDAOImpl implements logRegDAO{

    private Connection conn;

    private PreparedStatement stmt;

    private ResultSet rs;

    private void connVerify() throws SQLException {
        if(conn == null) {
            DBconn.getDBConnection();
        }
    }

    public logRegDAOImpl() throws SQLException {
        conn = DBconn.getDBConnection();
    }

    @Override
    public boolean getLogInfo(String username, String password) throws SQLException {
        connVerify();

        stmt = conn.prepareStatement(queries.getQueryLogin());
        stmt.setString(1, username);
        stmt.setString(2, password);
        rs = stmt.executeQuery();
        if(rs.next()){
            CurrentUser.getInstace(username);
            return true;
        }
        return false;
    }

    @Override
    public boolean Register(String email, String username, String password) throws SQLException {
        connVerify();

        try {
            stmt = conn.prepareStatement(queries.getRegisterUser());
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, email);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }
}
