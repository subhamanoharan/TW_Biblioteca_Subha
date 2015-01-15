package com.twu.biblioteca.library;

import java.util.HashMap;
public class Librarian {
    private String name;
    HashMap<Item, Customer> ledger = new HashMap<Item, Customer>();

    public Librarian(String name)
    {
        this.name = name;
    }

    public boolean checkOut(Customer customer, Item item) {
        boolean statusOfCheckOut = false;
        if(item != null)
        {
            statusOfCheckOut = item.checkOut();
            if(statusOfCheckOut == true)
                ledger.put(item,customer);
        }
        return statusOfCheckOut;
    }

    public boolean returnBack(Item item, Customer customer) {
        boolean statusOfReturn = false;
        if (item != null) {
            Customer borrower = ledger.get(item);
            if (borrower != null && borrower.equals(customer)) {
                statusOfReturn = item.returnBack();
                ledger.remove(item);
            }
        }
        return statusOfReturn;
    }

    public Customer getBorrower(Item item)
    {
        return ledger.get(item);
    }
}
