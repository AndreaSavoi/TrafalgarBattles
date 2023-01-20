package tournaments;

import java.sql.*;
import java.util.List;

public class RetrieveInfoSpecific{

    private RetrieveInfoSpecific() {
        throw new IllegalStateException("Utility class");
    }
    public static List<String> retrieveNames() throws SQLException {

        return RetrieveInfoGeneric.getInfo("SELECT tname FROM trafalgarbattles.tournaments");
    }

    public static List<String> retrieveDates() throws SQLException {

        return RetrieveInfoGeneric.getInfo("SELECT dates FROM trafalgarbattles.tournaments");

    }

    public static List<String> retrieveNPartecipants() throws SQLException {

        return RetrieveInfoGeneric.getInfo("SELECT npartecipants FROM trafalgarbattles.tournaments");
    }

    public static List<String> retrieveNSubscribed() throws SQLException {

        return RetrieveInfoGeneric.getInfo("SELECT nsubscribed FROM trafalgarbattles.tournaments");
    }



}
