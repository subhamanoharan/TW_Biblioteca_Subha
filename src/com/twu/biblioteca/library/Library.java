package com.twu.biblioteca.library;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

//collection of books made accessible to a defined community for borrowing
public class Library {
    private List<Book> books = new ArrayList<Book>();
    private List<Movie> movies = new ArrayList<Movie>();
    private HashMap<Item, String> ledger = new HashMap<Item, String>();
    private HashMap<String,Customer> customers = new HashMap<String, Customer>();

    public Library()
    {
        setUpLibrary();
    }

    public void setUpLibrary() {
        addMovie(new Movie("I", 1990, "Shankar", "unrated"));
        addBook(new Book("Head First Java", "Kerry Bates", 1990));
        addBook(new Book("Harry Potter and the Philosopher's stone", "J.K.Rowling", 2001));
        addCustomer("123-1234",new Customer("John", "john@gmail.com", "9123456780",  "xxxx"));
        addCustomer( "123-1235",new Customer("Jane", "jane@gmail.com", "9123456789", "xxxx"));
      }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public void addCustomer(String libraryNo,Customer newCustomer)
    {
        customers.put(libraryNo, newCustomer);
    }

    public List<Item> getBooks()
    {
        List<Item> itemsAvailable = new ArrayList<Item>();
        for(Book book : books)
        {
            if(book.getAvailability() == true)
                itemsAvailable.add(book);
        }
        return itemsAvailable;
    }

    public String getLibraryNo(Customer customer) {
        Collection<String> keys = customers.keySet();
        for( String key : keys) {
        if(customers.get(key).equals(customer))
            return key;
        }
        return null;
    }
    public Customer getContactInfo(String libraryNumber)
    {
        return customers.get(libraryNumber);
    }

    public List<Item> getMovies()
    {
        List<Item> itemsAvailable = new ArrayList<Item>();
        for(Item item : movies)
        {
            if(item.getAvailability() == true)
                itemsAvailable.add(item);
        }
        return itemsAvailable;
    }
    public boolean checkOut(Item item,String loggedInCustomer) {
        boolean statusOfCheckOut = false;
        if(item != null)
        {
            statusOfCheckOut = item.checkOut();
            if(statusOfCheckOut == true)
                ledger.put(item,loggedInCustomer);
        }
        return statusOfCheckOut;
    }

    public Customer getBorrowerDetails(Item item)
    {
        String borrower = ledger.get(item);;
        if( borrower == null)
        return null;
        else
        return customers.get(borrower);
    }

    public boolean returnItem(Item item,String loggedInCustomer) {
        boolean statusOfReturn = false;
        if (item != null) {
            String borrower = ledger.get(item);
            if (borrower != null && borrower.equals(loggedInCustomer)) {
                statusOfReturn = item.returnBack();
                ledger.remove(item);
            }
        }
        return statusOfReturn;
    }

    public Customer validateLogin(String libraryNumber,String password)
    {
        Customer customer = customers.get(libraryNumber);
        if(customer!=null && customer.isPasswordValid(password)) return customer;
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
