package User;

import User.*;
import FileIO.*;

import java.util.Scanner;

public class UserLogin {
    public User login(String userName,String email,String pass){
        User loginUser = new User();
        loginUser.setUName(userName);
        loginUser.setEmail(email);
        loginUser.setPass(pass);

        loginUser.setAdmin(loginUser.equals(loginUser.Admin()));
        FileIO fileIO = new FileIO();
        boolean isRegistered=fileIO.isRegisteredUser(loginUser, fileIO.getUserList());
        if(isRegistered){
            return loginUser;
        }
        System.out.println("Username, Email or password is incorrect\nPlease try again...");
        return loginUser.empty();
    }
}
