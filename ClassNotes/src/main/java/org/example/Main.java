package org.example;

import static input.InputUtils.intInput;
import static input.InputUtils.stringInput;

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
    }
    public static boolean expenses(int amountOfBananas) {
        if (amountOfBananas > 3){
            return true;
        } else {
            return false;
        }
    }

    public static String repeatThePhrase(String phrasing, int counter){
        StringBuilder concatment = new StringBuilder(phrasing);
        for (int arrayLoop = 0 ; arrayLoop < counter ; arrayLoop++){
            concatment.append(phrasing);
        }
        return concatment.toString();
    }
}