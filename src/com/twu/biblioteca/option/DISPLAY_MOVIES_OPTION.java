package com.twu.biblioteca.option;

import com.twu.biblioteca.library.Customer;
import com.twu.biblioteca.library.Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class DISPLAY_MOVIES_OPTION extends Option {
    public DISPLAY_MOVIES_OPTION(String name) {
        super(name);
    }

    @Override
    public String doActionRequested(Library biblioteca, Customer customer, BufferedReader bufferedReader) throws IOException {
        return (getFormattedStatement(biblioteca.getListOfMovies()));
    }

    public String getFormattedStatement(ArrayList<String[]> values)
    {
        String result="ITEMS AVAILABLE\n";
        result += String.format("%-70s%-70s%-70s%-70s\n","Name","Director","Movie Rating","Year");
        if(values.size() == 0)
            return "NO ITEMS AVAILABLE CURRENTLY";
        else
        {
            for(String[] itemValue:values)
            {
                for(String item : itemValue)
                  result+=String.format("%-70s ",item);
                result+="\n";
            }
            return result;
        }
    }

}
