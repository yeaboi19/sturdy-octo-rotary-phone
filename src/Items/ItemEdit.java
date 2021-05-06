package Items;

import FileIO.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ItemEdit {
    public int Edit(String name, double price, String nameChange, double priceChange) {

        Item editItem = new Item();
        editItem.setName(name);
        editItem.setPrice(price);


        FileIO fileIO = new FileIO();
        ArrayList<Item> itemList = fileIO.getItemList();
        boolean isCorrectItem = false;
        for (int i = 0; i < itemList.size(); i++) {
            if (itemList.get(i).equals(editItem)) {

                itemList.get(i).setName(nameChange);
                itemList.get(i).setPrice(priceChange);
                isCorrectItem = true;
                break;

            } else {
                System.out.println("incorrect command");//nice console times...
                break;
            }
        }
        if (!isCorrectItem) {
            System.out.println("Name or price is incorrect\nPlease try again...");
            return 0;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new FilePath().itemPath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(itemList);
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