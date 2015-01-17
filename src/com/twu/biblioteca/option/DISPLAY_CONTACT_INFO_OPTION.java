package com.twu.biblioteca.option;

import com.twu.biblioteca.UserInterface;
import com.twu.biblioteca.library.Library;

import java.io.IOException;

/**
 * Created by subham on 14/01/15.
 */
public class DISPLAY_CONTACT_INFO_OPTION extends OptionManager {
    public DISPLAY_CONTACT_INFO_OPTION(String name) {
        super(name);
    }

    @Override
    public void doActionRequested(Library biblioteca, UserInterface libraryInterface) throws IOException {
        if(customer == null)
            libraryInterface.requestLogin();
        else
            libraryInterface.printContactInfo(customer.getContactInfo());
    }

    public boolean isValid()
    {
        if(customer == null )
            return false;
        return true;
    }
}
