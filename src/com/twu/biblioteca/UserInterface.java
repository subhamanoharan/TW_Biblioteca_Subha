package com.twu.biblioteca;

import com.twu.biblioteca.controller.MainMenu;
import com.twu.biblioteca.library.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UserInterface {

    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public void printWelcome() {
        System.out.println("Welcome to Biblioteca!!");
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

    public void requestLogin() {
        System.out.println("You need to be logged in for this controller!!");
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

    public void printContactInfo(Customer customer)
    {
        String result = "CONTACT INFORMATION\n";
        result += "\nNAME: " + customer.getName();
        result += "\nEMAIL: " + customer.getEmail();
        result += "\nPHONE NUMBER: " + customer.getPhoneNumber() + "\n";
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

    public void printBooks(List<Item> books) {
        String result = "ITEMS AVAILABLE\n";
        result += String.format("%-70s%-70s%-70s\n", "Name", "Author", "YearOfPublishing");
        if (books.size() == 0)
            System.out.println("NO ITEMS AVAILABLE CURRENTLY");
        else {
            for (Item book1 : books) {
                Book book = (Book)book1;
                result += String.format("%-70s%-70s%-70s", book.getName(),book.getAuthor(),book.getYear());
                result += "\n";
            }
            System.out.println(result);
        }
    }

    public void printMovies(List<Item> items) {
        String result = "ITEMS AVAILABLE\n";
        result += String.format("%-70s%-70s%-70s%-70s\n", "Name", "Director","Movie Rating", "Year");
        if (items.size() == 0)
            System.out.println("NO ITEMS AVAILABLE CURRENTLY");
        else {
            for (Item item : items) {
                Movie movie=(Movie)item;
                  result += String.format("%-70s%-70s%-70s%-70s", movie.getTitle(), movie.getDirector(),movie.getMovieRating(), movie.getYear());
                result += "\n";
            }
            System.out.println(result);
        }
    }

    public int getUserChoiceOfMenuOption() throws IOException {
        return Integer.parseInt(bufferedReader.readLine());
    }

    public void printMenu(MainMenu optionsPossible) {
        ArrayList<String> options = optionsPossible.getOptions();
        for(int index = 0 ;index<options.size();index++)
            System.out.println((index + 1) + ")" + options.get(index));
    }
}