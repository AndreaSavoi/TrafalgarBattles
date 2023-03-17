package singleton;

public class CurrentUser {

    private static CurrentUser instance;
    private static String username;

    private CurrentUser(String username) {
        this.username = username;
    }

    public static CurrentUser getInstace(String userName) {
        if(instance == null) {
            instance = new CurrentUser(userName);
        }
        return instance;
    }

    public static String getUser() { return username; }

    @Override
    public String toString() {
        return "UserSession{" +
                "userName='" + username + '\''+
                '}';
    }
}
