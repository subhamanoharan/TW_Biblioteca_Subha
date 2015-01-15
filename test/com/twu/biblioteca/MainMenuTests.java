package com.twu.biblioteca;

import com.twu.biblioteca.library.Customer;
import com.twu.biblioteca.library.Librarian;
import com.twu.biblioteca.library.Library;
import com.twu.biblioteca.option.MainMenuManager;
import org.junit.After;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertEquals;

//To test the biblioteca app
public class MainMenuTests {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    Customer customer;
    Librarian librarian;
    Library biblioteca;
    MainMenuManager mainMenu;
    /*
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        setUpInput();
    }

    @Before
    public void setUpInput() {

        librarian = new Librarian();
        biblioteca = new Library("Biblioteca", librarian);
        customer = new Customer("John", "john@gmail.com", "9123456780", "123-1234", "xxxx");
        biblioteca.addCustomer(customer);
    }
/*
    @Test
    public void checkOptionDisplayBooks() throws IOException {
        boolean result=mainMenuManager.chooseOption(1, customer,biblioteca,inputReader,outputPrinter);
        assertEquals("NO BOOKS CURRENTLY AVAILABLE FOR CHECKOUT\n",outputPrinter.toString());
    }


    @Test
    public void checkOptionQuit() throws IOException {
        Librarian librarian = new Librarian();
        Library biblioteca = new Library("Biblioteca", librarian);
        Customer customer = new Customer("John","john@gmail.com","9123456780","123-1234","xxxx");
        biblioteca.addCustomer(customer);
        BibliotecaApp.performActionChosen(5, customer);
        assertEquals("Thanks For Visting Us!!\n", outContent.toString());
    }

    @Test
    public void checkInvalidOption() throws IOException {
        Librarian librarian = new Librarian();
        Library biblioteca = new Library("Biblioteca", librarian);
        Customer customer = new Customer("John","john@gmail.com","9123456780","123-1234","xxxx");
        biblioteca.addCustomer(customer);
        BibliotecaApp.performActionChosen(15, customer);
        assertEquals("Invalid Menu option\n", outContent.toString());
    }

*/
    @Test
    public void checkListDisplay()
    {
        MainMenuManager mainMenu = new MainMenuManager();
        assertEquals(mainMenu.getOptionsPossible(), "1)Display the list of available books\n2)Display the list of available movies\n3)CheckOut\n4)Return\n5)View My Info\n6)Quit\n");
    }
    @After
    public void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

}
