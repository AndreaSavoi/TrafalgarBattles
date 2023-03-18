package applicationcontrollers;

public class CurrentUser {
    private static String username;

    public CurrentUser(String username) {
        CurrentUser.username = username;
    }


    public static String getUser() { return username; }

    @Override
    public String toString() {
        return "UserSession{" +
                "userName='" + username + '\''+
                '}';
    }
}
