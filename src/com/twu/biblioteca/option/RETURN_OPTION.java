package com.twu.biblioteca.option;
import com.twu.biblioteca.UserInterface;
import com.twu.biblioteca.library.Item;
import com.twu.biblioteca.library.Library;

import java.io.IOException;

public class RETURN_OPTION extends OptionManager {
    public RETURN_OPTION(String name) {
        super(name);
    }

    @Override
    public void doActionRequested(Library biblioteca, UserInterface libraryInterface) throws IOException {
        if (customer == null)
            libraryInterface.requestLogin();
        else {
            String titleOfBook = libraryInterface.getTitle();
            Item item = biblioteca.getItemByTitle(titleOfBook);
            boolean statusOfReturn = biblioteca.returnItem(item, customer);
            libraryInterface.displayResultOfReturn(statusOfReturn);
        }
    }

    public boolean isValid()
    {
        if(customer == null )
            return false;
        return true;
    }

}
