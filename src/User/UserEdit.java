package User;

import FileIO.FileIO;
import FileIO.FilePath;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class UserEdit {
    public int Edit(String userName, String email, String pass, String userChange, String emailChange, String passChange) {
        User editUser = new User();
        editUser.setUName(userName);
        editUser.setEmail(email);
        editUser.setPass(pass);


        editUser.setAdmin(editUser.equals(editUser.Admin()));
        FileIO fileIO = new FileIO();
        ArrayList<User> userList = fileIO.getUserList();

        boolean isCorrectUser = false;
        for (int i = 0; i < userList.size(); i++) {
            if (editUser.equals(userList.get(i))) {

                if (userChange == null) {
                    userChange = userName;
                } else if (emailChange == null) {
                    emailChange = email;
                } else if (passChange == null) {
                    passChange = pass;
                }

                userList.get(i).setUName(userChange);
                userList.get(i).setEmail(emailChange);
                userList.get(i).setPass(passChange);
                isCorrectUser = true;
                break;
            }

        }
        if (!isCorrectUser) {
            System.out.println("Username, Email or password is incorrect\nPlease try again...");
            return -1;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new FilePath().loginPath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(userList);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 1;
    }
}