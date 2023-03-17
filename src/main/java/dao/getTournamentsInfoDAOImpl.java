package dao;

import bean.beanCurrTourn;
import javafx.scene.image.Image;
import queries.queries;
import singleton.DBconn;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class getTournamentsInfoDAOImpl implements getTournamentsInfoDAO{
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    private void connVerify() throws SQLException {
        if(conn == null) {
            DBconn.getDBConnection();
        }
    }

    public getTournamentsInfoDAOImpl() throws SQLException {
        conn = DBconn.getDBConnection();
    }

    @Override
    public void getInfo(List<String> tName, List<String> nPartecipants, List<String> nSubscribed, List<String> dates, List<String> sno, List<InputStream> logos) throws SQLException {
        connVerify();

        stmt = conn.prepareStatement(queries.getQueryAllTournaments());
        rs = stmt.executeQuery();
        while(rs.next()){
            tName.add(rs.getString("tname"));
            nPartecipants.add(rs.getString("npartecipants"));
            nSubscribed.add(rs.getString("nsubscribed"));
            dates.add(rs.getString("dates"));
            sno.add(rs.getString("sno"));
            logos.add(rs.getBinaryStream("image"));
        }
    }

    public void getSpecific(List<String> curr, int sno) throws SQLException {
        connVerify();

        stmt = conn.prepareStatement(queries.getQueryCurrTourn());
        stmt.setInt(1, sno);
        rs = stmt.executeQuery();
        while(rs.next()) {
            curr.add(rs.getString("tname"));
            curr.add(rs.getString("npartecipants"));
            curr.add(rs.getString("nsubscribed"));
            curr.add(rs.getString("dates"));
        }
    }

    public void addSub(String username, String tname) throws SQLException {
        connVerify();

        stmt = conn.prepareStatement(queries.getQueryAddSub());
        stmt.setString(1, username);
        stmt.setString(2, tname);
        stmt.executeUpdate();
    }
}
