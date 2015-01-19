package com.twu.biblioteca;

import com.twu.biblioteca.library.Book;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BookTests {
    Book book = new Book("Head First Java", "Kerry Bates", 1990);

    @Test
    public void checkAvailability()
    {
        assertTrue(book.getAvailability());
    }

    @Test
    public void validateSuccessfulCheckOut()
    {
        boolean result=book.checkOut();
        assertEquals(true, result);
    }

    @Test
    public void validateUnavailableCheckOut()
    {
        book.checkOut();
        boolean result=book.checkOut();
        assertEquals(false, result);
    }

    @Test
    public void validateSuccessfulReturn()
    {
        book.checkOut();
        boolean result =book.returnBack();
        assertEquals(true, result);

    }

    @Test
    public void validateUnSuccessfulReturn()
    {
        boolean result = book.returnBack();
        assertEquals(false, result);
    }
}
