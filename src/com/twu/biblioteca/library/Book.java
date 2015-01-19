package com.twu.biblioteca.library;

public class Book extends Item {
    private String title, author;
    private int yearPublished;

    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.availabilty = true;
    }
    public String getTitle() {
        return title;
    }

    public String getAuthor(){ return author;}

    public int getYear(){
        return yearPublished;
    }

    public String getName() {
        return title;
    }

    public boolean equals(Item book1)
    {
        Book book =(Book)book1;
        if(title.equals(book.title) &&
                author.equals(book.author) &&
                yearPublished == book.yearPublished)
            return true;
        return false;
    }
}
