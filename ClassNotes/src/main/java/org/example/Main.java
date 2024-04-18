package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.*;

import static input.InputUtils.intInput;
import static input.InputUtils.stringInput;
import static input.InputUtils.yesNoInput;

public class Main {

    private static final String selections = "" +
            "1. Repeat quote\n" +
            "2. Banana math\n" +
            "3. Text repeat\n" +
            "4. Fruit list\n" +
            "5. Media hashmap\n" +
            "6. Files and exceptions\n" +
            "7. OOP\n" +
            "8. GUI (no code yet)\n" +
            "9. Database (no code yet)\n" +
            "10. APIs (no code yet)\n" +
            "0. Quit";

    public static void main(String[] args) {

        int selection;

        while (true) {
            System.out.println(selections);
            selection = intInput("Enter your choice: ");

            if (selection == 1) {
                quoteRepeat();
            } else if (selection == 2) {
                bananaMath();
            } else if (selection == 3) {
                textRepeat();
            } else if (selection == 4) {
                fruitList();
            } else if (selection == 5) {
                mediaHashmap();
            } else if (selection == 6) {
                createAFile();
            } else if (selection == 7) {
                OOPNoteMaker();
            } else if (selection == 0) {
                break;
            } else {
                System.out.println("Invalid choice, please try again");
            }
        }
    }

    public static void quoteRepeat() {
        String saying = stringInput("Please enter your favorite quote or saying: ");
        int times = intInput("How many times would you like that to repeat? ");
        System.out.println("Here's your quote: " + saying.repeat(times));
    }

    public static  void bananaMath() {
        int dimesAndDollars = intInput("How many banana bunches are you buying? ");
        boolean moneyMoney = expenses(dimesAndDollars);
        if (moneyMoney) {
            System.out.println("You will be paying too much for bananas!");
        } else {
            System.out.println("You are paying a good amount for bananas! :)");
        }
    }
    public static boolean expenses(int amountOfBananas) {
        return amountOfBananas > 3;
    }

    public static void textRepeat() {
        String phrasing = stringInput("Enter some text: ");
        int counter = intInput("How many times do you want that to repeat? ");
        String repeated = repeatThePhrase(phrasing, counter);
        System.out.println(repeated);
    }
    public static String repeatThePhrase(String phrasing, int counter){
        return phrasing + phrasing.repeat(Math.max(0, counter));
    }

    public static void fruitList() {
        List<String> fruitList = fruitCount();
        if (fruitList.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.print(fruitList);
        }
    }
    public static List<String> fruitCount() {

        List<String> fruitList = new ArrayList<>();
        System.out.println("Let's build a list of fruits to buy!");

        while (yesNoInput("Add more? ")) {
            String whatFruit = stringInput("Enter a fruit: ");
            fruitList.add(whatFruit);
        }

        if(fruitList.isEmpty()){
            boolean confirm = yesNoInput("The list is empty.  Are you sure you want to continue?");
            if(!confirm){
                fruitCount();
            }
        }
        return fruitList;
    }

    public static void mediaHashmap(){
        HashMap<String, String> favoriteMediaList = favoriteMedia();
        if (favoriteMediaList.isEmpty()){
            System.out.println("The HashMap is empty.");
        } else {
            System.out.println(favoriteMediaList);
        }
    }
    public static HashMap<String, String> favoriteMedia() {

        HashMap<String, String> mediaList = new HashMap<>();
        System.out.println("Let's build a HashMap of your favorite media!\nPlease enter the name of the media and what form it is in when prompted!");

        while(yesNoInput("Add more?")) {
            String mediaName = stringInput("Name: ");
            String mediaForm = stringInput("Form: ");
            mediaList.put(mediaName, mediaForm);
        }

        if(mediaList.isEmpty()){
            boolean confirm = yesNoInput("The HashMap is empty.  Are you sure you want to continue?");
            if (!confirm){
                favoriteMedia();
            }
        }
        return mediaList;
    }

    public static void createAFile() {
        System.out.println("Let's make a file to write in!");
        String nameOfFile = stringInput("What is the file's name?");
        if (!nameOfFile.contains(".txt")){
            System.out.println("Please end the filename with '.txt'");
            createAFile();
        }

        try {
            FileWriter infoFile = new FileWriter(nameOfFile);
            BufferedWriter buffering = new BufferedWriter(infoFile);
            while(yesNoInput("Write a new line?")) {
                String lineWriter = stringInput("Enter text to put into the file: ");
                buffering.write(lineWriter + "\n");
            }
            infoFile.close();
            buffering.close();

            if(yesNoInput("Do you want to review what you wrote?")) {
                FileReader reading = new FileReader(nameOfFile);
                System.out.println(reading);
                reading.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void OOPNoteMaker(){
        ArrayList<OOP> noteList = new ArrayList<>();

        do {
            String name = stringInput("Enter the name of your item: ");
            String note = stringInput("Enter a note about it: ");

            noteList.add(newOOP(name, note));
        } while (yesNoInput("Add another item and note?"));

        if(yesNoInput("Do you wish to review your notes?")){
            for(OOP i : noteList) {
                System.out.println(i + "\n");
            }
        }
    }

    public static OOP newOOP(String itemName, String itemNote){

        OOP newItem = new OOP(itemName, itemNote);

        newItem.setName(itemName);
        newItem.setNote(itemNote);

        return newItem;
    }
}