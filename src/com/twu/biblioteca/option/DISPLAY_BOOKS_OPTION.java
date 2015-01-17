package com.twu.biblioteca.option;

import com.twu.biblioteca.UserInterface;
import com.twu.biblioteca.library.Library;

import java.io.IOException;
import java.util.ArrayList;

public class DISPLAY_BOOKS_OPTION extends OptionManager {
    public DISPLAY_BOOKS_OPTION(String name) {
        super(name);
    }

    @Override
    public void doActionRequested(Library biblioteca, UserInterface libraryInterface) throws IOException {
        libraryInterface.printListOfBooks(biblioteca.getListOfBooks());
    }
}
