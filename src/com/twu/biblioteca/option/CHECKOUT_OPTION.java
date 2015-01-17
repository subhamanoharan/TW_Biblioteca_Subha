package com.twu.biblioteca.option;

import com.twu.biblioteca.UserInterface;
import com.twu.biblioteca.library.Item;
import com.twu.biblioteca.library.Library;

import java.io.IOException;

public class CHECKOUT_OPTION extends OptionManager {

    public CHECKOUT_OPTION(String name)
    {
        super(name);
    }

    @Override
    public void doActionRequested(Library biblioteca, UserInterface libraryInterface) throws IOException {
        if( customer != null) {
            Item item = biblioteca.getItemByTitle(libraryInterface.getTitle());
            boolean statusOfCheckOut = biblioteca.checkOut(customer, item);
            libraryInterface.displayResultOfCheckOut(statusOfCheckOut);
        }
        else
            libraryInterface.requestLogin();
    }

    public boolean isValid()
    {
        if(customer == null )
            return false;
        return true;
    }
}
