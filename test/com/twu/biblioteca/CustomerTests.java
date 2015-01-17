package com.twu.biblioteca;

import com.twu.biblioteca.library.Customer;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CustomerTests {
    @Test
    public void checkEquality()
    {
        Customer customer = new Customer("John","john@gmail.com","9123456780","123-1234","xxxx");
        assertTrue(customer.equals(new Customer("John","john@gmail.com","9123456780","123-1234","xxxx")));
    }

    @Test
    public void checkInequality()
    {
        Customer customer = new Customer("John","john@gmail.com","9123456780","123-1234","xxxx");
        assertFalse(customer.equals(new Customer("Jane", "john@gmail.com", "9123456780", "123-1234", "xxxx")));
    }

    @Test
    public void checkGetLibraryNumber()
    {
        Customer customer = new Customer("John","john@gmail.com","9123456780","123-1234","xxxx");
        assertEquals(customer.getLibraryNumber(),"123-1234");
    }

    @Test
    public void checkValidPassword()
    {
        Customer customer = new Customer("John","john@gmail.com","9123456780","123-1234","xxxx");
        assertTrue(customer.isPasswordValid("xxxx"));
    }
/*
    @Test
    public void shouldPrintUserInfo()
    {
        Customer customer = new Customer("John","john@gmail.com","9123456780","123-1234","xxxx");
        String result=customer.getContactInfo();
        assertEquals("MY CONTACT INFORMATION\nNAME:John\nEMAIL ID:john@gmail.com\nPHONE NUMBER:9123456780\n",result);
    }*/

    @Test
    public void checkInValidPassword()
    {
        Customer customer = new Customer("John","john@gmail.com","9123456780","123-1234","xxxx");
        assertFalse(customer.isPasswordValid("xxx"));
    }

}

