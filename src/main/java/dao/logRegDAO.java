package dao;

import java.sql.SQLException;

public interface logRegDAO {
    public boolean getLogInfo(String username, String password) throws SQLException;

    public boolean Register(String email, String username, String password) throws SQLException;
}
