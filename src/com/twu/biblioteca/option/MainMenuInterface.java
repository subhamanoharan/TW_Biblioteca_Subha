package com.twu.biblioteca.option;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class MainMenuInterface {
    static HashMap<String, OptionManager> options = new HashMap<String, OptionManager>();

    public MainMenuInterface() {
        addOption(new LOGIN_OPTION("LOGIN"));
        addOption(new DISPLAY_BOOKS_OPTION(("DISPLAY LIST OF BOOKS")));
        addOption(new DISPLAY_MOVIES_OPTION(("DISPLAY LIST OF MOVIES")));
        addOption(new CHECKOUT_OPTION(("CHECKOUT")));
        addOption(new RETURN_OPTION(("RETURN")));
        addOption(new DISPLAY_CONTACT_INFO_OPTION(("VIEW MY INFO")));
        addOption(new CHECK_BORROWER_OPTION("CHECK BORROWER OF ITEM"));
        addOption(new QUIT_OPTION(("QUIT")));
    }

    public void addOption(OptionManager newOption) {
        options.put(newOption.getName(), newOption);
    }

    public OptionManager chooseOption(int choice) throws IOException {
        OptionManager optionSelected= getValidOptions().get(choice);
        if(optionSelected == null)
            return new INVALID_OPTION("INVALID OPTION");
        return optionSelected;
    }

    public HashMap<Integer , OptionManager> getValidOptions()
    {
        HashMap<Integer,OptionManager> validOptions = new HashMap<Integer, OptionManager>();
        Collection<String> stringReference = options.keySet();
        for (String string : stringReference)
        {
            OptionManager option = options.get(string);
            if(option.isValid())
                validOptions.put(validOptions.size() + 1, option);
        }
        return validOptions;
    }
    public ArrayList<String[]> getOptionsPossible()
    {
        ArrayList<String[]> optionsProvided = new ArrayList<String[]>();
        HashMap<Integer,OptionManager> validOptions =getValidOptions();
        Collection<Integer> intReference = validOptions.keySet();
        for (int intRef : intReference) {
            OptionManager option = validOptions.get(intRef);
            optionsProvided.add(new String[]{String.valueOf(intRef),option.getName()});
        }
        return optionsProvided;
    }

}
