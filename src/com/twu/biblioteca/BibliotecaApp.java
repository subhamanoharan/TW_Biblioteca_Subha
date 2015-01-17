package com.twu.biblioteca;
import com.twu.biblioteca.library.Librarian;
import com.twu.biblioteca.library.Library;
import com.twu.biblioteca.option.OptionManager;

import java.io.IOException;

public class BibliotecaApp {

    static Librarian librarian = new Librarian("librarian");
    static Library biblioteca = new Library("Biblioteca", librarian);
    static UserInterface userInterface = new UserInterface(biblioteca);

    public static void main(String[] args) throws IOException {
        runConsole();
    }

    public static void runConsole() throws IOException {
        boolean continueRun = true;
        userInterface.printWelcome();
        while (continueRun) {
            OptionManager optionSelected = userInterface.getUserChoiceOfMenuOption();
            optionSelected.doActionRequested(biblioteca, userInterface);
            continueRun =  optionSelected.shouldContinue();
        }
    }

}
