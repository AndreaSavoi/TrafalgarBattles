package bean;

public class beanReg extends beanLog{

    private String email;

    public beanReg(String email, String username, String password) {
        super(username, password);
        this.email = email;
    }

    public String getEmail() { return email; }
}
