package com.twu.biblioteca.option;

import com.twu.biblioteca.library.Customer;
import com.twu.biblioteca.library.Library;

import java.io.BufferedReader;
import java.io.IOException;

public  class Option {
    public String name="";
    Option(String name)
    {
        this.name = name;
    }
    public String doActionRequested(Library biblioteca, Customer customer, BufferedReader bufferedReader) throws IOException
    {
        return "Invalid Menu option";
    }
    public String getName()
    {
        return name;
    }

}
