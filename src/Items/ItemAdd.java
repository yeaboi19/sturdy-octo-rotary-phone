package Items;

import FileIO.FileIO;

import java.util.Scanner;

public class ItemAdd {
    public int add(String name,double price){
        Item addItem = new Item();
        addItem.setName(name);
        addItem.setPrice(price);


        FileIO fileIO = new FileIO();
        fileIO.setItems(addItem);
        if(!fileIO.isAddedItem(addItem,fileIO.getItemList())){
            System.out.println("this Item is already Added");
            return 0;
        }else{
            System.out.println("successfully added Item");
            return 1;
        }
    }
}
