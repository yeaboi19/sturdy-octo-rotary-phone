package Items;

import FileIO.FileIO;

import java.util.ArrayList;
import java.util.Scanner;

public class ItemSelect {

    public boolean isInteger(String a){
        boolean isInt=false;
        for(int i=0;i<a.length();i++){
            char charTest = a.charAt(i);
            int intTest=charTest;
            if(intTest>=48 && intTest<=57){
                isInt=true;
            }else{
                isInt=false;
                break;
            }
        }
        return isInt;
    }

    public int doubleToInt(double a) {
        int a1 = (int) a;
        double b = a * 10;
        int a2 = (int) b;
        if (a1 * 10 + 5 <= a2) {
            return a1 + 1;
        } else {
            return a1;
        }
    }

    public void select() {
        Scanner input = new Scanner(System.in);
        FileIO fileIO = new FileIO();
        ArrayList<Item> ItemList = fileIO.getItemList();
        int page = 1;
        int startIndex = (page - 1) * 10;
        int endIndex = page * 10;
        boolean isRunning = true;
        ArrayList<Item> userChoiceList = new ArrayList<>();
        System.out.println("""
                
                
                To select an Item just type its number shown at left
                
                Forward - goes to the next page
                back - goes to the previous page
                finish - stops program and outputs selected items to userChoiceList.txt
                
                """);
        System.out.println("Press any key to continue...");
        input.nextLine();
        while (isRunning) {
            System.out.println("<-------page " + page + " of " + (ItemList.size() / 10 + 1) + "------->");
            if ((ItemList.size() - startIndex + 1) < 10) {

                for (int i = startIndex; i < ItemList.size(); i++) {
                    System.out.println((i + 1) + "." + ItemList.get(i));
                }
            } else {
                for (int i = startIndex; i < endIndex; i++) {
                    System.out.println((i + 1) + "." + ItemList.get(i));
                }
            }
            System.out.println("<-------page " + page + " of " + (ItemList.size() / 10 + 1) + "------->");
            String userChoice = input.nextLine();
            if (userChoice.equalsIgnoreCase("BACK") || userChoice.equalsIgnoreCase("B")) {
                if (page - 1 >= 1) {
                    page--;
                    startIndex = (page - 1) * 10;
                    endIndex = page * 10;
                }

            } else if (userChoice.equalsIgnoreCase("FORWARD") || userChoice.equalsIgnoreCase("F")) {
                if (page + 1 <= ItemList.size() / 10 + 1) {
                    page++;
                    startIndex = (page - 1) * 10;
                    endIndex = page * 10;
                }
            } else if (userChoice.equalsIgnoreCase("FINISH") || userChoice.equalsIgnoreCase("FIN")) {
                isRunning = false;
            } else if(isInteger(userChoice) && Integer.parseInt(userChoice)<=ItemList.size() && Integer.parseInt(userChoice)!=0){
                int userInt=Integer.parseInt(userChoice);
                userChoiceList.add(ItemList.get(userInt-1));

                String userItemListInString="";
                for (int i = 0; i < userChoiceList.size(); i++) {
                    userItemListInString+="Item's name - "+userChoiceList.get(i).getName()+" || Item's price - "+userChoiceList.get(i).getPrice()+"\n";
                }
                System.out.println(userItemListInString);


            } else{
                System.out.println("""
                To select an Item just type its number shown at left
                
                Forward - goes to the next page
                back - goes to the previous page
                finish - stops program and outputs selected items to userChoiceList.txt
                
                """);
                System.out.println("incorrect command");
            }
        }
        fileIO.exportList(userChoiceList);
    }
}
