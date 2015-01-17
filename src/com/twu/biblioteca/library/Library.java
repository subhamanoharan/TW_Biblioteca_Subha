package com.twu.biblioteca.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//collection of books made accessible to a defined community for borrowing
public class Library {
    Librarian librarian;
    String name;
    List<Book> books = new ArrayList<Book>();
    List<Movie> movies = new ArrayList<Movie>();
    List<Customer> customers = new ArrayList<Customer>();
    HashMap<Item, Customer> ledger = new HashMap<Item, Customer>();


    public Library(String name, Librarian librarian) {
        this.name = name;
        this.librarian = librarian;
    }

    public void setUpLibrary() {
        addMovie(new Movie("I", 1990, "Shankar", "unrated"));
        addBook(new Book("Head First Java", "Kerry Bates", 1990));
        addBook(new Book("Harry Potter and the Philosopher's stone", "J.K.Rowling", 2001));
        addCustomer(new Customer("John", "john@gmail.com", "9123456780", "123-1234", "xxxx"));
        addCustomer(new Customer("Jane", "jane@gmail.com", "9123456789", "123-1235", "xxxx"));
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void addCustomer(Customer newCustomer)
    {
        customers.add(newCustomer);
    }

    public ArrayList<String[]> getListOfMovies()
    {
        return getValuesStatement((ArrayList) movies);
    }

    public ArrayList<String[]> getListOfBooks()
    {
        return getValuesStatement((ArrayList) books);
    }

    public ArrayList<String[]> getValuesStatement(ArrayList<Item> items)
    {
        ArrayList<String[]> itemValues= new ArrayList<String[]>();
            for(Item item : items)
            {
                if (item.availabilty == true)
                    itemValues.add(item.getValues());
            }
        return itemValues;
    }
    public boolean checkOut(Customer customer,Item item) {
        return librarian.checkOut(customer, item,ledger);
    }

    public String[] getBorrowerDetails(Item item)
    {
        Customer borrower = librarian.getBorrower(item,ledger);
        if( borrower == null)
        return null;
        else
        return borrower.getContactInfo();
    }

    public boolean returnItem(Item item, Customer customer) {
        return librarian.returnBack(item, customer,ledger);
    }

    public Customer validateLogin(String libraryNumber,String password)
    {
        for(Customer customer : customers)
        {
            if(customer.getLibraryNumber().equals(libraryNumber) && customer.isPasswordValid(password))
                return customer;
        }
        return null;
    }

    public Item getItemByTitle(String title)
    {
        for (Book b : books)
        {
            if ( (b.getTitle()).equals(title) )
                return b;
        }
        for (Movie movie : movies)
        {
            if ( (movie.name).equals(title) )
                return movie;
        }
        return null;
    }
}
