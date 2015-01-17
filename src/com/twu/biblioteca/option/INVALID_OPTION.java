package com.twu.biblioteca.option;

import com.twu.biblioteca.UserInterface;
import com.twu.biblioteca.library.Library;

import java.io.IOException;

public class INVALID_OPTION extends OptionManager {
    public INVALID_OPTION(String name) {
        super(name);
    }

    @Override
    public void doActionRequested(Library biblioteca, UserInterface libraryInterface) throws IOException {
        libraryInterface.printInvalidOption();
    }
}
