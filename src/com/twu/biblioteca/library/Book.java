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

    public String getDetails() {
        return String.format("%-70s%-70s%-70s\n",
                title, author, yearPublished);
    }
     public String[] getValues()
     {
         return new String[]{title, author, String.valueOf(yearPublished)};
     }

    public String getTitle() {
        return title;
    }

    }
