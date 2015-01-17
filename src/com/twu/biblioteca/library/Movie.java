package com.twu.biblioteca.library;

public class Movie extends Item {
    public String name;
    private String director;
    private String movie_rating;
    private int year;
    public Movie(String name, int year, String director, String movie_rating)
    {
        this.name = name;
        this.year = year;
        this.director = director;
        this.movie_rating = movie_rating;
        availabilty = true;
    }
    

    public  String getDetails()
    {
        return (String.format("%-70s%-70s%-70s%-70S\n",
                name, director, year, movie_rating));
    }

    public String[] getValues()
    {
        return new String[]{name, director,movie_rating,String.valueOf(year)};
    }
}
