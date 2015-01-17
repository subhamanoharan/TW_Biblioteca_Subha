package com.twu.biblioteca;

import com.twu.biblioteca.library.Library;
import com.twu.biblioteca.option.MainMenuInterface;
import com.twu.biblioteca.option.OptionManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UserInterface {

    Library biblioteca;
    MainMenuInterface mainMenuInterface = new MainMenuInterface();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    UserInterface(Library biblioteca) {
        this.biblioteca = biblioteca;
        biblioteca.setUpLibrary();
    }

    public void printWelcome() {
        System.out.println("Welcome to Biblioteca!!");
    }

    public void printMenu() {
        ArrayList<String[]> menuOptions = mainMenuInterface.getOptionsPossible();
        for (String[] stringArray : menuOptions) {
            System.out.println(stringArray[0] + ")" + stringArray[1]);
        }
    }

    public String[] getUserCredentials() throws IOException {
        String[] userCredentials = new String[2];
        System.out.println("Login");
        System.out.println("Enter library number:");
        userCredentials[0] = bufferedReader.readLine();
        System.out.println("Enter password:");
        userCredentials[1] = bufferedReader.readLine();
        return userCredentials;
    }

    public String getTitle() throws IOException {
        System.out.println("Enter title of book/movie:");
        return bufferedReader.readLine();
    }

    public OptionManager getUserChoiceOfMenuOption() throws IOException {
        printMenu();
        int choice = (Integer.parseInt(bufferedReader.readLine()));
        return mainMenuInterface.chooseOption(choice);
    }

    public void requestLogin() {
        System.out.println("You need to be logged in for this option!!");
    }

    public void alreadyLoggedIn() {
        System.out.println("You are already logged in!!");
    }

    public void displayResultOfCheckOut(boolean statusOfCheckOut) {
        if (statusOfCheckOut == true)
            System.out.println("Successful Checkout!\nEnjoy the book/movie");
        else
            System.out.println("Unsuccessful Checkout\nItem isn't available!!");
    }


    public void displayResultOfReturn(boolean statusOfReturn) {
        if (statusOfReturn == true)
            System.out.println("Successful Return!\nThank you for returning the item");
        else
            System.out.println("Unsuccessful Return\nItem isn't valid for return!!");

    }

    public void printListOfBooks(ArrayList<String[]> values) {
        String result = "ITEMS AVAILABLE\n";
        result += String.format("%-70s%-70s%-70s\n", "Name", "Author", "YearOfPublishing");
        if (values.size() == 0)
            System.out.println("NO ITEMS AVAILABLE CURRENTLY");
        else {
            for (String[] itemValue : values) {
                for (String item : itemValue) {
                    result += String.format("%-70s ", item);
                }
                result += "\n";
            }
            System.out.println(result);
        }
    }

    public void printListOfMovies(ArrayList<String[]> values) {
        String result = "ITEMS AVAILABLE\n";
        result += String.format("%-70s%-70s%-70s%-70s\n", "Name", "Director", "Movie Rating", "Year");
        if (values.size() == 0)
            System.out.println("NO ITEMS AVAILABLE CURRENTLY");
        else {
            for (String[] itemValue : values) {
                for (String item : itemValue)
                    result += String.format("%-70s ", item);
                result += "\n";
            }
            System.out.println(result);
        }
    }

    public void printContactInfo(String[] contactInfo) {
        String result = "CONTACT INFORMATION\n";
        result += "\nNAME: " + contactInfo[0];
        result += "\nEMAIL: " + contactInfo[1];
        result += "\nPHONE NUMBER: " + contactInfo[2] + "\n";
        System.out.println(result);
    }

    public void printInvalidOption() {
        System.out.println("Invalid Menu Option");
    }

    public void printAuthenticationFailure() {
        System.out.println("Authentication Failure!!Please check your credentials!");
    }

    public void printSuccessfulLogin() {
        System.out.println("Successful Login!!");
    }

    public void printExitMessage() {
        System.out.println("Thank you for visiting us!!");
    }

    public void indicateUnavailability() {
        System.out.println("Item doesn't exist!!Check spelling!");
    }

    public void indicateAvailability() {
        System.out.println("Item is available");
    }

    public String getAdminPassword() throws IOException {
        System.out.println("Enter admin password:");
        return bufferedReader.readLine();
    }
}