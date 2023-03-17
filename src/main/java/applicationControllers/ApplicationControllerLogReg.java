package applicationControllers;

import bean.beanLog;
import bean.beanReg;
import dao.logRegDAOImpl;

import java.sql.SQLException;

public class ApplicationControllerLogReg {

    private String email = null;
    private final String username;

    private final String password;

    public ApplicationControllerLogReg(beanLog bL) {
        if(bL == null) {
            throw new IllegalArgumentException("Bean cannot be null");
        }

        username = bL.getUsername();
        password = bL.getPassword();

        if(bL instanceof beanReg bR) {
            email = bR.getEmail();
            register();
        } else {
            verify();
        }
    }

    public void verify() {
        try {
            logRegDAOImpl logDao = new logRegDAOImpl();
            logDao.getLogInfo(username, password);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void register() {
        try{
            logRegDAOImpl regDAO = new logRegDAOImpl();
            regDAO.Register(email, username, password);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
