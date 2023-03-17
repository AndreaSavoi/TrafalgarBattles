package applicationControllers;

import bean.tournamentList;
import dao.getTournamentsInfoDAOImpl;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationControllerMainPage {
    private List<String> tName = new ArrayList<>();
    private List<String> nPartecipants = new ArrayList<>();
    private List<String> nSubscribed = new ArrayList<>();
    private List<String> dates = new ArrayList<>();
    private List<String> sno = new ArrayList<>();
    private List<InputStream> logos = new ArrayList<>();
    private getTournamentsInfoDAOImpl getTournamentsInfoDAO;

    public ApplicationControllerMainPage(tournamentList tL) throws SQLException {
        addDatas(tL);
    }

    private void addDatas(tournamentList tL) throws SQLException {

        getTournamentsInfoDAO = new getTournamentsInfoDAOImpl();
        getTournamentsInfoDAO.getInfo(tName, nPartecipants, nSubscribed, dates, sno, logos);

        int counter = sno.size();

        for (int i = 0;i < counter;i++) {
            tL.addName(tName.get(i));
            tL.addNP(nPartecipants.get(i));
            tL.addNS(nSubscribed.get(i));
            tL.addDates(dates.get(i));
            tL.addSNO(sno.get(i));
            tL.addLogo(logos.get(i));
        }
    }


}
