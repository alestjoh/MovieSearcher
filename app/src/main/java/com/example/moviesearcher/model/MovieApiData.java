package com.example.moviesearcher.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

public class MovieApiData {

    @Entity(tableName = "movie_table")
    public class MovieData {
        @PrimaryKey
        @ColumnInfo
        public int id;
        @ColumnInfo
        public String title;
        @ColumnInfo
        public String year;
        @ColumnInfo
        public String genre;
        @ColumnInfo
        public String poster;

        public boolean containsString(String str) {
            str = str.toUpperCase();
            return  title.toUpperCase().contains(str) ||
                    year.toUpperCase().contains(str) ||
                    genre.toUpperCase().contains(str);
        }
    }

    public List<MovieData> data;
}
