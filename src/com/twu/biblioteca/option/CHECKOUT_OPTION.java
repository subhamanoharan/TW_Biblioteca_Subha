package com.twu.biblioteca.option;

import com.twu.biblioteca.library.Customer;
import com.twu.biblioteca.library.Item;
import com.twu.biblioteca.library.Library;

import java.io.BufferedReader;
import java.io.IOException;

public class CHECKOUT_OPTION extends Option {
    public CHECKOUT_OPTION(String name)
    {
        super(name);
    }
    @Override
    public String doActionRequested(Library biblioteca, Customer customer, BufferedReader bufferedReader) throws IOException {
        System.out.println("Enter title of book/movie:");
        String title = bufferedReader.readLine();
        Item item = biblioteca.getItemByTitle(title);
        return performAction(biblioteca, customer, item);
    }

    private String performAction(Library biblioteca, Customer customer, Item item) {
        if (item == null)
            return "Unsuccessful Checkout!\nItem doesn't exist!!Check your spelling";
        else {
            boolean statusOfCheckOut = biblioteca.checkOut(customer, item);
            if (statusOfCheckOut ==true)
                return "Successful Checkout!\nEnjoy the book/movie";
            else
                return "Unsuccessful Checkout\nItem isn't available!!";
        }
    }
}
