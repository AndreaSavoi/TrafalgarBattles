package applicationControllers;

import bean.beanLog;
import bean.beanReg;
import dao.logRegDAOImpl;

import java.sql.SQLException;

public class ApplicationControllerLogReg {

    private String email = null;
    private final String username;

    private final String password;

    public ApplicationControllerLogReg(beanLog bL) throws Exception {
        if(bL == null) {
            throw new IllegalArgumentException("Bean cannot be null");
        }

        username = bL.getUsername();
        password = bL.getPassword();

        if(bL instanceof beanReg) {
            beanReg bR = (beanReg) bL;
            email = bR.getEmail();
            register();
        } else {
            verify();
        }
    }

    public void verify() throws Exception {
        logRegDAOImpl logDao = new logRegDAOImpl();
        if(logDao.getLogInfo(username, password)) {
            return;
        }
        throw new Exception("Not existing account");
    }

    public void register() throws Exception {
        logRegDAOImpl regDAO = new logRegDAOImpl();
        if(!regDAO.Register(email, username, password)) {
            throw new Exception("Account already exists");
        }
    }
}
