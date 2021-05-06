package Items;

import FileIO.FileIO;

public class ItemRemove {
    public int remove(String name, Double price) {
        Item removeItem = new Item();
        removeItem.setName(name);
        removeItem.setPrice(price);

        FileIO fileIO = new FileIO();
        return fileIO.removeItem(removeItem);
    }
}
