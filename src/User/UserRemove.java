package User;

import FileIO.FileIO;

import java.util.Scanner;

public class UserRemove {
    public int remove(String userName,String email,String pass){
        User user = new User();
        user.setUName(userName);
        user.setEmail(email);
        user.setPass(pass);

        FileIO fileIO = new FileIO();
        return fileIO.removeUser(user);
    }
}
