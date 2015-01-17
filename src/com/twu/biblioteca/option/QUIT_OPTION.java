package com.twu.biblioteca.option;

import com.twu.biblioteca.UserInterface;
import com.twu.biblioteca.library.Library;

import java.io.IOException;

public class QUIT_OPTION extends OptionManager {
    public QUIT_OPTION(String name) {
        super(name);
    }

    @Override
    public void doActionRequested(Library biblioteca, UserInterface libraryInterface) throws IOException {
        resetCustomer();
        setQuitStatus();
        libraryInterface.printExitMessage();
    }
}
