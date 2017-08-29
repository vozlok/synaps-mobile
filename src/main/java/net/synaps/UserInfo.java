package net.synaps;

public class UserInfo {
    public String firstName;
    public String lastName;
    public String email;
    public String password;

    public UserInfo(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
