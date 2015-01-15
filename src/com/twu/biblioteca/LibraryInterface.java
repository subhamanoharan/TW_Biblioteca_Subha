package com.twu.biblioteca;

import com.twu.biblioteca.library.Customer;
import com.twu.biblioteca.library.Library;
import com.twu.biblioteca.option.MainMenuManager;
import com.twu.biblioteca.option.Option;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class LibraryInterface {

    Library biblioteca;
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    LibraryInterface(Library biblioteca)
    {
        this.biblioteca = biblioteca;
        biblioteca.setUpLibrary();
    }

    public  void printWelcome(Customer customer) {
        System.out.println("Welcome to Biblioteca " + customer.name + "!!");
    }

    Customer validateUser() throws IOException {
         System.out.println("Login");
         System.out.println("Enter library number:");
         String libraryNumber = bufferedReader.readLine();
         System.out.println("Enter password:");
         String password = bufferedReader.readLine();
         return biblioteca.validateLogin(libraryNumber,password);
     }

    public int getUserChoiceOfMenuOption() throws IOException {
        System.out.println(MainMenuManager.getOptionsPossible());
        return (Integer.parseInt(bufferedReader.readLine()));
    }

    public void displayResultOfAction(String string)
    {
        System.out.println(string);

    }


}