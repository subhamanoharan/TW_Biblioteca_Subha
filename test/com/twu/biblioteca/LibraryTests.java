package com.twu.biblioteca;

import com.twu.biblioteca.library.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

//Test the biblioteca class
public class LibraryTests {
   Library biblioteca = new Library( );
    Movie movie = new Movie("I", 1990, "Shankar", "unrated");
    Book book = new Book("Head First Java", "Kerry Bates", 1990);
    Customer customer = new Customer("John","john@gmail.com","9123456780", "xxxx");
    UserInterface userInterface = new UserInterface();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void shouldValidateSuccessfulBookCheckout() {
        biblioteca.addCustomer("123-1234",customer);
        biblioteca.addBook(book);
        boolean result=biblioteca.checkOut( biblioteca.getItemByTitle("Head First Java"),"123-1234");
        assertEquals(true, result);
    }
    @Test
    public void shouldValidateSuccessfulMovieCheckout() {
        biblioteca.addCustomer("123-1234",customer);
        biblioteca.addMovie(movie);
        boolean result=biblioteca.checkOut(biblioteca.getItemByTitle("I"),"123-1234");
        assertEquals(true, result);
    }
    @Test
    public void shouldValidateBookUnSuccessfulTypoCheckout() {
        biblioteca.addCustomer("123-1234",customer);
        biblioteca.addBook(book);
        String title = "Head First";
        boolean result=biblioteca.checkOut(biblioteca.getItemByTitle(title),"123-1234");
        assertEquals(false, result);
    }

    @Test
    public void shouldValidateMovieUnSuccessfulTypoCheckout() {
        biblioteca.addCustomer("123-1234",customer);
        Movie movie = new Movie("I", 1990, "Shankar", "unrated");
        biblioteca.addMovie(movie);
        String title = "Head First";
        boolean result=biblioteca.checkOut(biblioteca.getItemByTitle(title),"123-1234");
        assertEquals(false, result);
    }

    @Test
    public void shouldValidateBookUnSuccessfulUnavailableCheckout() {
        biblioteca.addCustomer("123-1234",customer);
        Book book = new Book("Head First Java", "Kerry Bates", 1990);
        biblioteca.addBook(book);
        String title = "Head First Java";
        biblioteca.checkOut(biblioteca.getItemByTitle(title),"123-1234");
        boolean result=biblioteca.checkOut(biblioteca.getItemByTitle(title),"123-1234");
        assertEquals(false, result);
    }

    @Test
    public void shouldValidateMovieUnSuccessfulUnavailableCheckout() {
        biblioteca.addCustomer("123-1234",customer);
        biblioteca.addMovie(movie);
        String title = "I";
        biblioteca.checkOut(biblioteca.getItemByTitle(title),"123-1234");
        boolean result=biblioteca.checkOut(biblioteca.getItemByTitle(title),"123-1234");
        assertEquals(false, result);
    }

    @Test
    public void shouldSuccessfullyReturnBook()
    {
        biblioteca.addCustomer("123-1234",customer);
        biblioteca.addBook(book);
        String title = "Head First Java";
        biblioteca.checkOut(biblioteca.getItemByTitle(title),"123-1234");
        boolean result=biblioteca.returnItem(biblioteca.getItemByTitle(title),"123-1234");
        assertEquals(true, result);
    }
  @Test
    public void shouldSuccessfullyReturnMovie()
    {
        biblioteca.addCustomer("123-1234",customer);
        biblioteca.addMovie(movie);
        String title = "I";
        biblioteca.checkOut( biblioteca.getItemByTitle(title),"123-1234");
        boolean result=biblioteca.returnItem(biblioteca.getItemByTitle(title),"123-1234");
        assertEquals(true, result);
    }

    @Test
    public void shouldIndicateInvalidReturnBook()
    {
        biblioteca.addCustomer("123-1234",customer);
        biblioteca.addBook(book);
        String title = "Head First Java";
        boolean result=biblioteca.returnItem(biblioteca.getItemByTitle(title),"123-1234");
        assertEquals(false, result);
    }
    @Test
    public void shouldIndicateInvalidReturnMovie()
    {
        biblioteca.addCustomer("123-1234",customer);
        biblioteca.addMovie(movie);
        String title = "I";
        boolean result=biblioteca.returnItem(biblioteca.getItemByTitle(title),"123-1234");
        assertEquals(false, result);
    }

    @Test
    public void shouldIndicateTypoReturnBook()
    {
        biblioteca.addCustomer("123-1234",customer);
        biblioteca.addBook(book);
        String title = "Head First";
        boolean result=biblioteca.returnItem(biblioteca.getItemByTitle(title),"123-1234");
        assertEquals(false, result);
    }

    @Test
    public void shouldIndicateTypoReturnMovie()
    {
        biblioteca.addCustomer("123-1234",customer);
        biblioteca.addMovie(movie);
        String title = "I";
        boolean result=biblioteca.returnItem(biblioteca.getItemByTitle(title),"123-1234");
        assertEquals(false, result);
    }
    @Test
    public void shouldRetrieveBookByTitle()
    {
        biblioteca.addBook(book);
        assertTrue(null!=(biblioteca.getItemByTitle("Head First Java")));
    }

    @Test
    public void shouldNotRetrieveBookByInvalidTitle()
    {
        biblioteca.addBook(book);
        assertTrue((biblioteca.getItemByTitle("Head Java"))==null);
    }
    @Test
    public void shouldRetrieveMovieByTitle()
    {
        biblioteca.addMovie(movie);
        assertFalse(null ==(biblioteca.getItemByTitle("I")));
    }

    @Test
    public void shouldNotRetrieveMovieByInvalidTitle()
    {
        biblioteca.addMovie(movie);
        assertTrue(null ==(biblioteca.getItemByTitle("Head Java")));
    }

    protected void verifyOutput(String actualValue, String fileName) throws IOException {
        BufferedReader file = new BufferedReader(new FileReader("test/data" + '/' + fileName));
        BufferedReader actualStream = new BufferedReader(new StringReader(actualValue));
        String thisFileLine;
        while ((thisFileLine = file.readLine()) != null) {
            assertThat("in file: " + fileName, actualStream.readLine(), equalTo(thisFileLine));
        }
    }

    @Test
    public void shouldLoginCorrectly()
    {
        biblioteca.addCustomer("123-1234",customer);
        Customer member = biblioteca.validateLogin("123-1234","xxxx");
        assertEquals(member,customer);
    }

    @Test
    public void shouldAvoidInvalidLibraryNUmberLogin()
    {
        biblioteca.addCustomer("123-1234",customer);
        Customer member = biblioteca.validateLogin("123-1233","xxx");
        assertEquals(member, null);
    }
    @Test
    public void shouldAvoidInvalidPasswordLogin()
    {
        biblioteca.addCustomer("123-1234",customer);
        Customer member = biblioteca.validateLogin("123-1233","xxx");
        assertEquals(member, null);
    }
    @Test
    public void checkValidGetLibraryNumber()
    {
        biblioteca.addCustomer("123-1234",customer);
        assertEquals("123-1234",biblioteca.getLibraryNo(customer));
    }
    @Test
    public void checkInValidGetLibraryNumber()
    {
        biblioteca.addCustomer("123-1234",customer);
        assertNotEquals("123-1233", biblioteca.getLibraryNo(customer));
    }
    @Test
    public void checkBorrowerIsValid()
    {
        biblioteca.addCustomer("123-1234",customer);
        biblioteca.addBook(book);
        biblioteca.checkOut(book,"123-1234");
        assertEquals(customer,biblioteca.getBorrowerDetails(book));
    }
    @Test
    public void checkInvalidItemForBorrower()
    {
        biblioteca.addCustomer("123-1234", customer);
        biblioteca.addBook(book);
        biblioteca.checkOut(book,"123-1234");
        assertNotEquals(customer, biblioteca.getBorrowerDetails(movie));
    }

    @Test
    public void checkBookDisplay() throws IOException {
        userInterface.printBooks(biblioteca.getBooks());
        verifyOutput(outContent.toString(),"BooksList");
      }
}

