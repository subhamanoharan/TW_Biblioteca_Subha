package com.twu.biblioteca.option;

import com.twu.biblioteca.library.Customer;
import com.twu.biblioteca.library.Library;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by subham on 14/01/15.
 */
public class DISPLAY_CONTACT_INFO_OPTION extends Option {
    public DISPLAY_CONTACT_INFO_OPTION(String name) {
        super(name);
    }

    @Override
    public String doActionRequested(Library biblioteca, Customer customer, BufferedReader bufferedReader) throws IOException {
        return (customer.getContactInfo());
    }
}
