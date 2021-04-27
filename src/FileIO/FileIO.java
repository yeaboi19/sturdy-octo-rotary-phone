package FileIO;

import Items.Item;
import User.User;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class FileIO {

    FilePath filePath = new FilePath();

    public ArrayList<User> getUserList() {
        // getting all the users from the file
        ArrayList<User> UserList = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath.loginPath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            UserList = (ArrayList<User>) objectInputStream.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return UserList;
    }

    public boolean isRegisteredUser(User newUser, ArrayList<User> userList) {
        boolean isRegistered = false;
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).equals(newUser)) {
                isRegistered = true;
            }
        }
        return isRegistered;
    }

    public void setUsers(User newUser) {
        boolean isRegistered;
        FileIO fileIO = new FileIO();
        ArrayList<User> userList = new ArrayList<>(fileIO.getUserList());
        isRegistered = isRegisteredUser(newUser, userList);
        userList.add(newUser);
        if (!isRegistered) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(filePath.loginPath);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(userList);
                objectOutputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void removeUser(User user) {
        ArrayList<User> userList = getUserList();
        boolean isInList = false;
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).equals(user)) {
                System.out.println("i have removed " + userList.get(i).getUName());
                userList.remove(i);
                isInList = true;
                break;
            }
        }
        if (!isInList) {
            System.out.println("Username, Email or password is incorrect\nPlease try again...");
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath.loginPath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(userList);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //------------------------------------------------------------------------------ITEM START------------------------------
    public ArrayList<Item> getItemList() {
        ArrayList<Item> ItemList = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath.itemPath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ItemList = (ArrayList<Item>) objectInputStream.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return ItemList;
    }

    public boolean isAddedItem(Item newItem, ArrayList<Item> ItemList) {
        boolean isAdded = false;
        for (int i = 0; i < ItemList.size(); i++) {
            if (ItemList.get(i).equals(newItem)) {
                isAdded = true;
            }
        }
        return isAdded;
    }

    public void setItems(Item newItem) {
        FileIO fileIO = new FileIO();
        ArrayList<Item> ItemList = new ArrayList<>();
        boolean isAdded;
        if (!new File(new FilePath().itemPath).exists()) {
            isAdded = false;
        } else {
            ItemList = fileIO.getItemList();
            isAdded = isAddedItem(newItem, ItemList);
        }
        ItemList.add(newItem);
        if (!isAdded) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(filePath.itemPath);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(ItemList);
                objectOutputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void removeItem(Item item) {
        ArrayList<Item> itemList = getItemList();
        boolean isInList = false;
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).equals(item)) {
                System.out.println("I have removed " + itemList.get(i).getName());
                itemList.remove(i);
                isInList = true;
                break;
            }
        }
        if (!isInList) {
            System.out.println("Name or price is incorrect\nPlease try again...");
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath.itemPath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(itemList);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int exportList(ArrayList<Item> userItemList) {
        int fullPrice = 0;
        String userItemListInString="";
        for (int i = 0; i < userItemList.size(); i++) {
            fullPrice += userItemList.get(i).getPrice();
            userItemListInString+="Item's name - "+userItemList.get(i).getName()+" || Item's price - "+userItemList.get(i).getPrice()+"\n";
        }
        userItemListInString+="\nFull price - "+fullPrice;
        byte[] a=userItemListInString.getBytes();
        try {
            System.out.println("sucsessfuly wrote list to device");
//            FileOutputStream fileOutputStream = new FileOutputStream(filePath.userChoicePath);
//            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
//            for(int i=0;i<userItemList.size();i++){
//
//                fileOutputStream.write(userItemList.get(i).toString().getBytes());
//                fileOutputStream.
//            }
//            bufferedOutputStream.close();
//            fileOutputStream.close();
            FileWriter fileWriter =new FileWriter(filePath.userChoicePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(int i=0;i<userItemList.size();i++){
                bufferedWriter.write(userItemList.get(i).toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
            return 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
/*
ArrayList<Item> ItemList = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath.itemPath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ItemList=(ArrayList<Item>) objectInputStream.readObject();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return ItemList;




 */
