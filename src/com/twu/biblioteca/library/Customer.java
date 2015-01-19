package com.twu.biblioteca.library;

public class Customer {
    private String password;
    private String name;
    private String email;
    private String phoneNumber;

    public Customer(String name, String email, String phoneNumber, String password) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
    public Customer(){}

    public Customer(Customer customer) {
        this.name = customer.name;
        this.email = customer.email;
        this.phoneNumber = customer.phoneNumber;
        this.password = customer.password;
    }

    public boolean isPasswordValid(String password) {
        if (this.password.equals(password))
            return true;
        return false;
    }
    public boolean equals(Customer expected)
    {
        if( password.equals(expected.password) &&
                name.equals(expected.name) &&
                email.equals(expected.email) &&
                phoneNumber.equals(expected.phoneNumber))
            return true;
        return false;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
