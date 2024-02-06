package login;

import java.util.Objects;

public class User {
    private String username;
    private String password = "anaaremere"; // null
    private boolean isActive=true; //false

    static int nr;

    public User(String username) {
        this.username = username;
        nr++;
    }

    public User(String username, String password) {
        this.username = username;
        validatePwd(password);
        System.out.println("constr");
        nr++;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        System.out.println("dgdfgh");
        validatePwd(password);
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


    private void validatePwd(String password) {
        if(password!=null && password.length()>=6)
            this.password = password;
        else
            System.out.println("DEBUG: vezi ca parola nu e buna, retry pls ");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isActive == user.isActive && Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, isActive);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}


