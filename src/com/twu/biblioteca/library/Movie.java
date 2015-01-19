package com.twu.biblioteca.library;

public class Movie extends Item {
    public String name;
    private String director;
    private String movie_rating;
    private int year;
    private String title;

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

    public int getYear() {
        return year;
    }

    public String getMovieRating() {
        return movie_rating;
    }

    public String getDirector() {
        return director;
    }

    public String getTitle() {
        return name;
    }

    public boolean equals(Item movie1)
    {
        Movie movie=(Movie)movie1;
        if(name.equals(movie.name) &&
                year == movie.year &&
                director.equals(movie.director) &&
                movie_rating.equals(movie.movie_rating))
            return true;
        return false;
    }
}
