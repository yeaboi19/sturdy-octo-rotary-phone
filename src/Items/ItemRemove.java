package Items;

import FileIO.FileIO;

import java.util.Scanner;

public class ItemRemove {
    public void remove(String name,Double price){
        Item removeItem = new Item();
        removeItem.setName(name);
        removeItem.setPrice(price);

        FileIO fileIO = new FileIO();
        fileIO.removeItem(removeItem);
    }
}
