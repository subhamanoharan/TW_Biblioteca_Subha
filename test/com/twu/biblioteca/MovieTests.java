package com.twu.biblioteca;

import com.twu.biblioteca.library.Movie;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MovieTests {
    Movie movie = new Movie("I", 1990, "Shankar", "unrated");

    @Test
    public void checkAvailability()
    {
        assertTrue(movie.getAvailability());
    }

    @Test
    public void validateSuccessfulCheckOut()
    {
        boolean result=movie.checkOut();
        assertEquals(true, result);
    }

    @Test
    public void validateUnavailableCheckOut()
    {
        movie.checkOut();
        boolean result=movie.checkOut();
        assertEquals(false, result);
    }

    @Test
    public void validateSuccessfulReturn()
    {
        movie.checkOut();
        boolean result= movie.returnBack();
        assertEquals(true, result);
    }

    @Test
    public void validateUnSuccessfulReturn()
    {
        boolean result=movie.returnBack();
        assertEquals(false, result);
    }
}

