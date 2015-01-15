package com.twu.biblioteca.option;

import com.twu.biblioteca.option.*;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

public class MainMenuManager {
    static HashMap<Integer, Option> options = new HashMap<Integer, Option>();

    public MainMenuManager() {
        addOption(new DISPLAY_BOOKS_OPTION(("DISPLAY LIST OF BOOKS")));
        addOption(new DISPLAY_MOVIES_OPTION(("DISPLAY LIST OF MOVIES")));
        addOption(new CHECKOUT_OPTION(("CHECKOUT")));
        addOption(new RETURN_OPTION(("RETURN")));
        addOption(new DISPLAY_CONTACT_INFO_OPTION(("VIEW MY INFO")));
        addOption(new QUIT_OPTION(("QUIT")));
    }

    public void addOption(Option newOption) {
        options.put(options.size() + 1, newOption);
    }

    public Option chooseOption(int choice) throws IOException {
        Option optionSelected;
         optionSelected = options.get(choice);
        return optionSelected;
    }

    public static String getOptionsPossible() {
        Collection<Integer> intReference = options.keySet();
        String result = "";
        for (int intRef : intReference)
            result += intRef + ")" + options.get(intRef).getName() + "\n";
        return result;
    }

}
