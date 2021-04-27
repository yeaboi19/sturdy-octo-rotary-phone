package User;

import java.io.*;
import java.util.Objects;

public class User implements Serializable {
    private String uName;
    private String pass;
    private String Email;
    private boolean isAdmin=false;

    long serialVersionUID =123456789;

    public String getUName() {
        return uName;
    }

    public void setUName(String uname) {
        uName = uname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!Objects.equals(uName, user.uName)) return false;
        if (!Objects.equals(pass, user.pass)) return false;
        return Objects.equals(Email, user.Email);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "uName='" + uName + '\'' +
                ", pass='" + pass + '\'' +
                ", Email='" + Email + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
    // returns empty User   Is used for Logged in as
    public User empty(){
        User user = new User();
        user.uName=null;
        user.pass=null;
        user.Email=null;
        user.isAdmin=false;
        return user;
    }
    // used to differentiate normal user from Admin
    public User Admin(){
        User Admin = new User();
        Admin.setUName("Admin");
        Admin.setEmail("Admin@Admin.com");
        Admin.setPass("Admin");
        Admin.isAdmin=true;
        return Admin;
    }
}
