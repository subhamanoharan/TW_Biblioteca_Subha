package com.twu.biblioteca;
import com.twu.biblioteca.library.Library;

import java.io.IOException;

public class BibliotecaApp {

    public static void main(String[] args) throws IOException {
        BibliotecaController bibliotecaController = new BibliotecaController(new Library(), new UserInterface());
        runConsole(bibliotecaController);
    }

    public static void runConsole(BibliotecaController bibliotecaController) throws IOException {
        boolean continueRun = true;
        while (continueRun) {
            bibliotecaController.performUserRequest();
            continueRun = bibliotecaController.shouldContinue();
        }
    }

}
