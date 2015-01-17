package com.twu.biblioteca;

import com.twu.biblioteca.library.*;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LibrarianTests {
    Librarian librarian = new Librarian("librarian");
    Book book = new Book("Head First Java", "Kerry Bates", 1990);
    Customer customer = new Customer("John","john@gmail.com","9123456780","123-1234","xxxx");
    Movie movie = new Movie("I", 1990, "Shankar", "unrated");
    HashMap<Item, Customer> ledger = new HashMap<Item, Customer>();


    @Test
    public void shouldValidateBookCheckOut() {
        assertTrue(librarian.checkOut(customer, book, ledger));
    }

    @Test
    public void shouldCheckInValidBookCheckOut() {
        assertFalse(librarian.checkOut(customer, null, ledger));
    }

    @Test
    public void shouldCheckBookSuccessfulReturn()
    {
        librarian.checkOut(customer, book, ledger);
        assertTrue(librarian.returnBack(book, customer, ledger));

    }
    @Test
    public void shouldCheckBookUnSuccessfulReturn()
    {
        librarian.checkOut(customer, book, ledger);
        assertFalse(librarian.returnBack(null, customer, ledger));
    }

    @Test
    public void shouldValidateMovieCheckOut() {
        assertTrue(librarian.checkOut(customer, movie, ledger));
    }

    @Test
    public void shouldCheckInValidMovieCheckOut() {
        assertFalse(librarian.checkOut(customer, null, ledger));
    }

    @Test
    public void shouldCheckMovieSuccessfulReturn()
    {
        librarian.checkOut(customer,movie, ledger);
        assertTrue(librarian.returnBack(movie, customer, ledger));
    }

    @Test
    public void shouldCheckMovieUnSuccessfulReturn()
    {
        librarian.checkOut(customer, movie, ledger);
        assertFalse(librarian.returnBack(null, customer, ledger));
    }

    @Test
    public void checkBorrower()
    {
        librarian.checkOut(customer, movie, ledger);
        Customer borrower = librarian.getBorrower(movie, ledger);
        assertEquals(borrower,customer);
    }
    @Test
    public void checkIfNoBorrower()
    {
        librarian.checkOut(customer, movie, ledger);
        librarian.returnBack(movie,customer, ledger);
        Customer borrower = librarian.getBorrower(movie, ledger);
        assertEquals(borrower, null);
    }
}
