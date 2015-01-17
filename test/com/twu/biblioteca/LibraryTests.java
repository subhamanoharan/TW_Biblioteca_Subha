package com.twu.biblioteca;

import com.twu.biblioteca.library.*;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

//Test the biblioteca class
public class LibraryTests {
    Librarian librarian = new Librarian("librarian");
    Library biblioteca = new Library("Biblioteca", librarian);
    Movie movie = new Movie("I", 1990, "Shankar", "unrated");
    Book book = new Book("Head First Java", "Kerry Bates", 1990);
    Customer customer = new Customer("John","john@gmail.com","9123456780","123-1234","xxxx");
    ArrayList<Item> items = new ArrayList<Item>();

    @Test
    public void shouldValidateBookListAfterCheckOut() throws IOException {
        biblioteca.addCustomer(customer);
        biblioteca.addBook(book);
        //biblioteca.addBook(new Book("Harry Potter and the Philosopher's stone", "J.K.Rowling", 2001));
        //biblioteca.addBook(new Book("Java", "Kerry Bates", 1990));
        biblioteca.checkOut(customer, biblioteca.getItemByTitle("Head First Java"));
        ArrayList<String[]> result=biblioteca.getListOfBooks();
        ArrayList<String[]> expected = new ArrayList<String[]>();
        assertTrue(checkEqualityOfArrayListOfStringArrays(result,expected));
    }

    @Test
    public void shouldValidateMovieListAfterCheckOut() throws IOException {
        biblioteca.addCustomer(customer);
        Movie movie = new Movie("I", 1990, "Shankar", "unrated");
        biblioteca.addMovie(movie);
        biblioteca.checkOut(customer, biblioteca.getItemByTitle("I"));
        ArrayList<String[]> result=biblioteca.getListOfBooks();
        ArrayList<String[]> expected = new ArrayList<String[]>();
        assertTrue(checkEqualityOfArrayListOfStringArrays(result, expected));
    }

    @Test
    public void checkTextFormatting()
    {
        ArrayList<String[]> result = biblioteca.getValuesStatement(items);
        String[] books = new String[]{"Head First Java","K ","1990"};
        ArrayList<String[]> expectedResult =new ArrayList<String[]>();
        expectedResult.add(books);
        assertTrue(checkEqualityOfArrayListOfStringArrays(result, expectedResult));
    }

    @Test
    public void checkTextFormattingWhenEmpty()
    {
        ArrayList<String[]> result=biblioteca.getValuesStatement(items);
        ArrayList<String[]> expectedResult = new ArrayList<String[]>();
        assertTrue(checkEqualityOfArrayListOfStringArrays(result,expectedResult));
    }

    private boolean checkEqualityOfArrayListOfStringArrays(ArrayList<String[]> result, ArrayList<String[]> expectedResult) {
        for(int index =0;index<result.size();index++)
        {
            if(checkEqualityOfStringArrays(result.get(index),expectedResult.get(index))== false)
                return false;
        }
        return true;
    }

    private boolean checkEqualityOfStringArrays(String[] strings, String[] strings1) {
        for(int index =0;index<strings.length;index++)
        {
            if(strings[index].equals(strings1) == false)
                return false;
        }
        return true;
    }
    @Test
    public void shouldGetExistingBookByTitle() {
        biblioteca.addBook(book);
        assertEquals(biblioteca.getItemByTitle("Head First Java"), book);
    }

    @Test
    public void shouldSearchForNonExistingBookByTitle() {
        biblioteca.addBook(book);
        assertEquals(biblioteca.getItemByTitle("Head "), null);
    }

    @Test
    public void shouldGetExistingMovieByTitle() {
        biblioteca.addBook(book);
        assertEquals(biblioteca.getItemByTitle("Head First Java"), book);
    }

    @Test
    public void shouldSearchForNonExistingMovieByTitle() {
        biblioteca.addMovie(movie);
        assertEquals(biblioteca.getItemByTitle("Head "), null);
    }

    @Test
    public void shouldValidateSuccessfulBookCheckout() {
        biblioteca.addCustomer(customer);
        biblioteca.addBook(book);
        boolean result=biblioteca.checkOut(customer, biblioteca.getItemByTitle("Head First Java"));
        assertEquals(true, result);
    }
    @Test
    public void shouldValidateSuccessfulMovieCheckout() {
        biblioteca.addCustomer(customer);
        biblioteca.addMovie(movie);
        boolean result=biblioteca.checkOut(customer, biblioteca.getItemByTitle("I"));
        assertEquals(true, result);
    }
    @Test
    public void shouldValidateBookUnSuccessfulTypoCheckout() {
        biblioteca.addCustomer(customer);
        biblioteca.addBook(book);
        String title = "Head First";
        boolean result=biblioteca.checkOut(customer, biblioteca.getItemByTitle(title));
        assertEquals(false, result);
    }

    @Test
    public void shouldValidateMovieUnSuccessfulTypoCheckout() {
        Customer customer = new Customer("John","john@gmail.com","9123456780","123-1234","xxxx");
        biblioteca.addCustomer(customer);
        Movie movie = new Movie("I", 1990, "Shankar", "unrated");
        biblioteca.addMovie(movie);
        String title = "Head First";
        boolean result=biblioteca.checkOut(customer, biblioteca.getItemByTitle(title));
        assertEquals(false, result);
    }

    @Test
    public void shouldValidateBookUnSuccessfulUnavailableCheckout() {
        Customer customer = new Customer("John","john@gmail.com","9123456780","123-1234","xxxx");
        biblioteca.addCustomer(customer);
        Book book = new Book("Head First Java", "Kerry Bates", 1990);
        biblioteca.addBook(book);
        String title = "Head First Java";
        biblioteca.checkOut(customer, biblioteca.getItemByTitle(title));
        boolean result=biblioteca.checkOut(customer, biblioteca.getItemByTitle(title));
        assertEquals(false, result);
    }

    @Test
    public void shouldValidateMovieUnSuccessfulUnavailableCheckout() {
        biblioteca.addCustomer(customer);
        biblioteca.addMovie(movie);
        String title = "I";
        biblioteca.checkOut(customer, biblioteca.getItemByTitle(title));
        boolean result=biblioteca.checkOut(customer, biblioteca.getItemByTitle(title));
        assertEquals(false, result);
    }

    @Test
    public void shouldSuccessfullyReturnBook()
    {
        biblioteca.addCustomer(customer);
        biblioteca.addBook(book);
        String title = "Head First Java";
        biblioteca.checkOut(customer, biblioteca.getItemByTitle(title));
        boolean result=biblioteca.returnItem(biblioteca.getItemByTitle(title), customer);
        assertEquals(true, result);
    }
  @Test
    public void shouldSuccessfullyReturnMovie()
    {
        biblioteca.addCustomer(customer);
        biblioteca.addMovie(movie);
        String title = "I";
        biblioteca.checkOut(customer, biblioteca.getItemByTitle(title));
        boolean result=biblioteca.returnItem(biblioteca.getItemByTitle(title), customer);
        assertEquals(true, result);
    }

    @Test
    public void shouldIndicateInvalidReturnBook()
    {
        biblioteca.addCustomer(customer);
        biblioteca.addBook(book);
        String title = "Head First Java";
        boolean result=biblioteca.returnItem(biblioteca.getItemByTitle(title), customer);
        assertEquals(false, result);
    }
    @Test
    public void shouldIndicateInvalidReturnMovie()
    {
        biblioteca.addCustomer(customer);
        biblioteca.addMovie(movie);
        String title = "I";
        boolean result=biblioteca.returnItem(biblioteca.getItemByTitle(title), customer);
        assertEquals(false, result);
    }

    @Test
    public void shouldIndicateTypoReturnBook()
    {
        biblioteca.addCustomer(customer);
        biblioteca.addBook(book);
        String title = "Head First";
        boolean result=biblioteca.returnItem(biblioteca.getItemByTitle(title), customer);
        assertEquals(false, result);
    }

    @Test
    public void shouldIndicateTypoReturnMovie()
    {
        biblioteca.addCustomer(customer);
        biblioteca.addMovie(movie);
        String title = "I";
        boolean result=biblioteca.returnItem(biblioteca.getItemByTitle(title), customer);
        assertEquals(false, result);
    }
/*
    @Test
    public void checkAdditionOfCustomers()
    {
        Customer addedCustomer =new Customer("John","john@gmail.com","9123456780","123-1234","xxxx");
        biblioteca.addCustomer(addedCustomer);
        Customer searchResult = biblioteca.searchCustomerByLibraryNumber("123-1234");
        assertTrue(searchResult.equals(addedCustomer));
    }
    @Test
    public void checkInvalidCustomerSearch()
    {
        Customer addedCustomer =new Customer("John","john@gmail.com","9123456780","123-1234","xxxx");
        biblioteca.addCustomer(addedCustomer);
        Customer searchResult = biblioteca.searchCustomerByLibraryNumber("123-1244");
        assertFalse(addedCustomer.equals(searchResult));
    }*/
    @Test
    public void shouldRetrieveBookByTitle()
    {
        biblioteca.addBook(book);
        assertTrue(book.equals(biblioteca.getItemByTitle("Head First Java")));
    }

    @Test
    public void shouldNotRetrieveBookByInvalidTitle()
    {
        biblioteca.addBook(book);
        assertFalse(book.equals(biblioteca.getItemByTitle("Head Java")));
    }
    @Test
    public void shouldRetrieveMovieByTitle()
    {
        biblioteca.addMovie(movie);
        assertTrue(movie.equals(biblioteca.getItemByTitle("I")));
    }

    @Test
    public void shouldNotRetrieveMovieByInvalidTitle()
    {
        biblioteca.addMovie(movie);
        assertFalse(movie.equals(biblioteca.getItemByTitle("Head Java")));
    }


    /*@Test
    public void out() {
        System.out.println("hello");
        assertEquals("hello\n", result);
    }*/

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
        biblioteca.addCustomer(customer);
        Customer member = biblioteca.validateLogin(customer.getLibraryNumber(),"xxxx");
        assertEquals(member,customer);
    }

    @Test
    public void shouldAvoidInvalidLogin()
    {
        biblioteca.addCustomer(customer);
        Customer member = biblioteca.validateLogin(customer.getLibraryNumber(),"xxx");
        assertEquals(member, null);
    }
}

