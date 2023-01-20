package singleton;

public final class CurrentUser {

    private static CurrentUser instance;

    private final String userName;

    private CurrentUser(String username) {
        this.userName = username;
    }

    public static CurrentUser getInstace(String userName) {
        if(instance == null) {
            instance = new CurrentUser(userName);
        }
        return instance;
    }

    @Override
    public String toString() {
        return "UserSession{" +
                "userName='" + userName + '\''+
                '}';
    }
}
