package com.example.moviesearcher.model;

import java.util.List;

public class MovieApiData {
    public class MovieData {
        public int id;
        public String title, year, genre, poster;
    }

    public List<MovieData> data;
}
