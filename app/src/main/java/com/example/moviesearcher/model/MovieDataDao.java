package com.example.moviesearcher.model;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MovieDataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(MovieApiData.MovieData movie);

    @Query("SELECT * from movie_table")
    List<MovieApiData.MovieData> getAllMovies();

    @Query("DELETE FROM movie_table")
    void deleteAll();
}
