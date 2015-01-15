package com.twu.biblioteca.library;

public abstract class Item {

    protected boolean availabilty;

    public boolean getAvailability() {
        return availabilty;
    }

    public boolean checkOut() {
        if (availabilty == true) {
            availabilty = false;
            return true;
        } else
            return false;
    }

    public boolean returnBack() {
        if (availabilty == true)
            return false;
        else {
            availabilty = true;
            return true;
        }
    }

    public abstract String getDetails();

    public abstract String[] getValues();
}
