package com.twu.biblioteca;

import com.twu.biblioteca.library.Book;
import com.twu.biblioteca.library.Customer;
import com.twu.biblioteca.library.Librarian;
import com.twu.biblioteca.library.Movie;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LibrarianTests {
    Librarian librarian = new Librarian("librarian");
    Book book = new Book("Head First Java", "Kerry Bates", 1990);
    Customer customer = new Customer("John","john@gmail.com","9123456780","123-1234","xxxx");
    Movie movie = new Movie("I", 1990, "Shankar", "unrated");

    @Test
    public void shouldValidateBookCheckOut() {
        assertTrue(librarian.checkOut(customer, book));
    }

    @Test
    public void shouldCheckInValidBookCheckOut() {
        assertFalse(librarian.checkOut(customer, null));
    }

    @Test
    public void shouldCheckBookSuccessfulReturn()
    {
        librarian.checkOut(customer, book);
        assertTrue(librarian.returnBack(book, customer));

    }
    @Test
    public void shouldCheckBookUnSuccessfulReturn()
    {
        librarian.checkOut(customer, book);
        assertFalse(librarian.returnBack(null, customer));
    }

    @Test
    public void shouldValidateMovieCheckOut() {
        assertTrue(librarian.checkOut(customer, movie));
    }

    @Test
    public void shouldCheckInValidMovieCheckOut() {
        assertFalse(librarian.checkOut(customer, null));
    }

    @Test
    public void shouldCheckMovieSuccessfulReturn()
    {
        librarian.checkOut(customer,movie);
        assertTrue(librarian.returnBack(movie, customer));
    }

    @Test
    public void shouldCheckMovieUnSuccessfulReturn()
    {
        librarian.checkOut(customer, movie);
        assertFalse(librarian.returnBack(null, customer));
    }

    @Test
    public void checkBorrower()
    {
        librarian.checkOut(customer, movie);
        Customer borrower = librarian.getBorrower(movie);
        assertEquals(borrower,customer);
    }
    @Test
    public void checkIfNoBorrower()
    {
        librarian.checkOut(customer, movie);
        librarian.returnBack(movie,customer);
        Customer borrower = librarian.getBorrower(movie);
        assertEquals(borrower, null);
    }
}
