package dao;

import javafx.scene.image.Image;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

public interface getTournamentsInfoDAO {
    public void getInfo(List<String> tName, List<String> nPartecipants, List<String> nSubscribed, List<String> dates, List<String> sno, List<InputStream> logos) throws SQLException;

    public void getSpecific(List<String> curr, int sno) throws SQLException;

    public void addSub(String username, String tname) throws SQLException;
}
