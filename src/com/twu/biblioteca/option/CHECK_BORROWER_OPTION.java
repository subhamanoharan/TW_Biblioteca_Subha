package com.twu.biblioteca.option;

import com.twu.biblioteca.UserInterface;
import com.twu.biblioteca.library.Customer;
import com.twu.biblioteca.library.Item;
import com.twu.biblioteca.library.Library;

import java.io.IOException;

public class CHECK_BORROWER_OPTION extends OptionManager {
    public CHECK_BORROWER_OPTION(String s) {
        super(s);
    }

    @Override
    public void doActionRequested(Library biblioteca, UserInterface libraryInterface) throws IOException {
        String credential =libraryInterface.getAdminPassword();
        if(credential.equals("admin1234")) {
            String title = libraryInterface.getTitle();
            Item item = biblioteca.getItemByTitle(title);
            if (item == null)
                libraryInterface.indicateUnavailability();
            else {
                String[] borrower = biblioteca.getBorrowerDetails(item);
                if (borrower == null)
                    libraryInterface.indicateAvailability();
                else
                    libraryInterface.printContactInfo(borrower);
            }
        }
        else
            libraryInterface.printAuthenticationFailure();
    }
}
