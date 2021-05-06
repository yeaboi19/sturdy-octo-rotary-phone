package User;

import FileIO.FileIO;

import java.util.Scanner;

public class UserReg {
    public int reg(String userName,String email,String pass){
        //input...
        User newUser = new User();
        newUser.setUName(userName);
        newUser.setEmail(email);
        newUser.setPass(pass);

        newUser.setAdmin(newUser.equals(newUser.Admin()));// is admin or not
        FileIO fileIO = new FileIO();
        fileIO.setUsers(newUser);
        if(!fileIO.isRegisteredUser(newUser,fileIO.getUserList())){
            if(userName==null || email==null || pass==null){
                System.out.println("this user is already registered");
                return 0;
            }else{
                System.out.println("successfully registered user");
                return 1;
            }
        }else{
            System.out.println("successfully registered user");
            return 1;
        }
    }
}
