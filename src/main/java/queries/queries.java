package queries;

public class queries {
    private queries(){}

    static final String queryLogin= "SELECT * FROM trafalgarbattles.login WHERE username = ? and password = ?";

    public static String getQueryLogin(){return queryLogin;}

    static final String queryAllTournaments = "SELECT * FROM trafalgarbattles.tournaments;";

    public static String getQueryAllTournaments() {
        return queryAllTournaments;
    }

    static final String registerUser = "INSERT INTO trafalgarbattles.login (username, password, email) VALUES (?, ?, ?);";

    public static String getRegisterUser() { return registerUser; }

    static final String queryCurrTourn = "SELECT * FROM trafalgarbattles.tournaments WHERE sno = ?;";

    public static String getQueryCurrTourn() { return queryCurrTourn; }

    static final String queryAddSub = "INSERT INTO trafalgarbattles.subscription (names, tname) VALUES (?, ?);";

    public static String getQueryAddSub() { return queryAddSub; }
}
