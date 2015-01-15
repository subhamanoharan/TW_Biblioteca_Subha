package com.twu.biblioteca.option;

import com.twu.biblioteca.library.Customer;
import com.twu.biblioteca.library.Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class DISPLAY_BOOKS_OPTION extends Option {
    public DISPLAY_BOOKS_OPTION(String name)
    {
        super(name);
    }
    @Override
    public String doActionRequested(Library biblioteca, Customer customer, BufferedReader bufferedReader) throws IOException {
        return getFormattedStatement(biblioteca.getListOfBooks());
    }

    public String getFormattedStatement(ArrayList<String[]> values)
    {
        String result="ITEMS AVAILABLE\n";
        result += String.format("%-70s%-70s%-70s\n","Name","Author","YearOfPublishing");
        if(values.size() == 0)
            return "NO ITEMS AVAILABLE CURRENTLY";
        else
        {
            for(String[] itemValue:values)
            {
                String temp=" ";
                for(String item : itemValue) {
                    temp += item;
                    result += String.format("%-70s ", item);
                }
                result+="\n";
            }
            return result;
        }
    }

}
