package com.twu.biblioteca;

import com.twu.biblioteca.library.Customer;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CustomerTests {
    Customer customer = new Customer("John","john@gmail.com","9123456780", "xxxx");

    @Test
    public void checkEquality()
    {
        assertTrue(customer.equals(new Customer("John","john@gmail.com","9123456780", "xxxx")));
    }

    @Test
    public void checkInequality()
    {
        assertFalse(customer.equals(new Customer("Jane", "john@gmail.com", "9123456780", "xxxx")));
    }

    @Test
    public void checkValidPassword()
    {
        assertTrue(customer.isPasswordValid("xxxx"));
    }

    @Test
    public void checkInValidPassword()
    {
        Customer customer = new Customer("John","john@gmail.com","9123456780", "xxxx");
        assertFalse(customer.isPasswordValid("xxx"));
    }

}

