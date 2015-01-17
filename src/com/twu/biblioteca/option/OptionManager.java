package com.twu.biblioteca.option;

import com.twu.biblioteca.UserInterface;
import com.twu.biblioteca.library.Customer;
import com.twu.biblioteca.library.Library;

import java.io.IOException;

public abstract class OptionManager {
    public String name = "";
    static Customer customer;
    static boolean shouldContinue = true;

    OptionManager(String name) {
        this.name = name;
    }

    void setQuitStatus() {
        shouldContinue = false;
    }

    public void setCurrentCustomer(Customer customer) {
        this.customer = new Customer(customer);
    }

    public void resetCustomer() {
        this.customer = null;
    }

    public abstract void doActionRequested(Library biblioteca, UserInterface libraryInterface) throws IOException;


    public  boolean isValid()
    {
        return true;
    }

    public String getName() {
        return name;
    }

    public boolean shouldContinue() {
        return shouldContinue;
    }
}
