package applicationControllers;

import bean.beanCurrTourn;
import dao.getTournamentsInfoDAOImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationControllerTournInfo {

    List<String> curr = new ArrayList<>();
    private getTournamentsInfoDAOImpl getCurrTurnInfo;
    public ApplicationControllerTournInfo(String username, String tname) throws SQLException {
        addSub(username, tname);
    }
    public ApplicationControllerTournInfo(beanCurrTourn bCT) throws SQLException {
        addDatas(bCT);
    }

    private void addDatas(beanCurrTourn bCT) throws SQLException {
        getCurrTurnInfo = new getTournamentsInfoDAOImpl();
        getCurrTurnInfo.getSpecific(curr, bCT.getSno());
        bCT.settName(curr.get(0));
        bCT.setnPartecipants(curr.get(1));
        bCT.setnSubscribed(curr.get(2));
        bCT.setDates(curr.get(3));
    }

    private void addSub(String username, String tname) throws SQLException {
        getCurrTurnInfo = new getTournamentsInfoDAOImpl();
        getCurrTurnInfo.addSub(username, tname);
    }
}
