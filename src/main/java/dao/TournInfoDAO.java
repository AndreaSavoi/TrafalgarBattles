package dao;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

public interface TournInfoDAO {
    void getInfo(List<String> tName, List<String> nPartecipants, List<String> nSubscribed, List<String> dates, List<String> sno, List<InputStream> logos) throws SQLException;

    void getSpecific(List<String> curr, int sno) throws SQLException;

    void addSub(String username, String tname) throws SQLException;
}
