package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static input.InputUtils.intInput;
import static input.InputUtils.stringInput;
import static input.InputUtils.yesNoInput;

public class Main {
    public static void main(String[] args) {
        String saying = stringInput("Please enter your favorite quote or saying: ");
        int times = intInput("How many times would you like that to repeat? ");
        System.out.println("Here's your quote: " + saying.repeat(times));

        int dimesAndDollars = intInput("How many banana bunches are you buying? ");
        boolean moneyMoney = expenses(dimesAndDollars);
        if (moneyMoney){
            System.out.println("You will be paying too much for bananas!");
        } else if (!moneyMoney){
            System.out.println("You are paying a good amount for bananas! :)");
        }

        String phrasing = stringInput("Enter some text: ");
        int counter = intInput("How many times do you want that to repeat? ");
        String repeated = repeatThePhrase(phrasing, counter);
        System.out.println(repeated);

        List<String> fruitList = fruitCount(); //New
        if (fruitList.isEmpty()){
            System.out.println("The list is empty.");
        } else {
            System.out.print(fruitList);
        }

        HashMap<String, String> favoriteMediaList = favoriteMedia(); //New
        if (favoriteMediaList.isEmpty()){
            System.out.println("The HashMap is empty.");
        } else {
            System.out.println(favoriteMediaList);
        }
    }
    public static boolean expenses(int amountOfBananas) {
        return amountOfBananas > 3;
    }

    public static String repeatThePhrase(String phrasing, int counter){
        StringBuilder concatment = new StringBuilder(phrasing);
        for (int arrayLoop = 0 ; arrayLoop < counter ; arrayLoop++){
            concatment.append(phrasing);
        }
        return concatment.toString();
    }

    public static List<String> fruitCount() { //New

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

    public static HashMap<String, String> favoriteMedia() { //New

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
}