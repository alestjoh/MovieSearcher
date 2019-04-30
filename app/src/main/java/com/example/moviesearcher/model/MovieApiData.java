package com.example.moviesearcher.model;

import java.util.List;

public class MovieApiData {

    public class MovieData {
        public int id;
        public String title, year, genre, poster;

        public boolean containsString(String str) {
            str = str.toUpperCase();
            return  title.toUpperCase().contains(str) ||
                    year.toUpperCase().contains(str) ||
                    genre.toUpperCase().contains(str);
        }
    }

    public List<MovieData> data;
}
