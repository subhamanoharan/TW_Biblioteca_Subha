package com.twu.biblioteca;
import com.twu.biblioteca.library.Customer;
import com.twu.biblioteca.library.Librarian;
import com.twu.biblioteca.library.Library;
import com.twu.biblioteca.option.MainMenuManager;
import com.twu.biblioteca.option.Option;

import java.io.IOException;

public class BibliotecaApp {

    static Librarian librarian = new Librarian("librarian");
    static Library biblioteca = new Library("Biblioteca", librarian);
    static LibraryInterface libraryInterface = new LibraryInterface(biblioteca);
    static MainMenuManager mainMenuManager = new MainMenuManager();

    public static void main(String[] args) throws IOException {
        Customer user=libraryInterface.validateUser();
        runConsole(user);
    }

    public static void runConsole(Customer customer) throws IOException {
        boolean continueRun = true;
        if (customer != null) {
            libraryInterface.printWelcome(customer);
            while (continueRun) {
                continueRun=performUserChoice(customer);
            }
        } else
            System.out.println("Invalid user");
    }

    public static boolean performUserChoice(Customer customer) throws IOException {
        int choice = libraryInterface.getUserChoiceOfMenuOption();
        Option optionSelected = mainMenuManager.chooseOption(choice);
        return performAction(customer, optionSelected);
    }


    private  static boolean performAction(Customer customer, Option optionSelected) throws IOException {
        if (optionSelected!= null && optionSelected.name.equals("QUIT"))
        {
            libraryInterface.displayResultOfAction(optionSelected.doActionRequested(biblioteca, customer, libraryInterface.bufferedReader));
            return false;
        }
        else {
            if (optionSelected == null )
                libraryInterface.displayResultOfAction("Invalid menu option");
            else
                libraryInterface.displayResultOfAction(optionSelected.doActionRequested(biblioteca, customer, libraryInterface.bufferedReader));
            return true;
        }
    }

}
