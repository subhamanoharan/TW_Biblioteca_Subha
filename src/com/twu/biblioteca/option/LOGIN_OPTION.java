package com.twu.biblioteca.option;

import com.twu.biblioteca.UserInterface;
import com.twu.biblioteca.library.Customer;
import com.twu.biblioteca.library.Library;

import java.io.IOException;

public class LOGIN_OPTION extends OptionManager {
    LOGIN_OPTION(String name) {
        super(name);
    }

    @Override
    public void doActionRequested(Library biblioteca, UserInterface libraryInterface) throws IOException {
        if (customer != null) {
            libraryInterface.alreadyLoggedIn();
        }
        else {
            String[] userCredentials = libraryInterface.getUserCredentials();
            Customer customerLogin = (biblioteca.validateLogin(userCredentials[0], userCredentials[1]));
            if (customerLogin == null)
                libraryInterface.printAuthenticationFailure();
            else {
                setCurrentCustomer(customerLogin);
                libraryInterface.printSuccessfulLogin();
            }
        }
    }

    public boolean isValid()
    {
        if(customer == null )
            return true;
        return false;
    }
}
