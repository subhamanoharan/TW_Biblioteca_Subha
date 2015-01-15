package com.twu.biblioteca.option;

import com.twu.biblioteca.library.Customer;
import com.twu.biblioteca.library.Item;
import com.twu.biblioteca.library.Library;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by subham on 14/01/15.
 */
public class RETURN_OPTION extends Option {
    public RETURN_OPTION(String name) {
        super(name);
    }

    @Override
    public String doActionRequested(Library biblioteca, Customer customer, BufferedReader bufferedReader) throws IOException {
        System.out.println("Enter title of book/movie:");
        String titleOfBook = bufferedReader.readLine();
        Item item = biblioteca.getItemByTitle(titleOfBook);
        return performAction(biblioteca, customer, item);
    }

    private String performAction(Library biblioteca, Customer customer, Item item) {
        if (item == null)
            return "Unsuccessful Return!\nItem doesn't exist!!Check your spelling";
        else {
            boolean statusOfReturn = biblioteca.returnItem(item, customer);
            if (statusOfReturn == true)
                return "Successful Return!\nThank you";
            else
                return "Unsuccessful Return\nItem is not valid for return!!";
        }
    }

}
