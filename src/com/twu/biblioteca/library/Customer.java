package com.twu.biblioteca.library;

public class Customer {
    private String libraryNumber;
    private String password;
    public String name;
    private String email;
    private String phoneNumber;

    public Customer(String name, String email, String phoneNumber, String libraryNumber, String password) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public Customer() {

    }

    public Customer(Customer customer) {
        this.name = customer.name;
        this.email = customer.email;
        this.phoneNumber = customer.phoneNumber;
        this.libraryNumber = customer.libraryNumber;
        this.password = customer.password;
    }

    public boolean equals(Customer customer) {
        if (customer == null)
            return false;
        if (name == customer.name &&
                libraryNumber == customer.libraryNumber &&
                email == customer.email &&
                phoneNumber == customer.phoneNumber &&
                password == customer.password)
            return true;
        return false;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public boolean isPasswordValid(String password) {
        if (this.password.equals(password))
            return true;
        return false;
    }

    public String[] getContactInfo() {
        return new String[]{name, email, phoneNumber};
    }
}
