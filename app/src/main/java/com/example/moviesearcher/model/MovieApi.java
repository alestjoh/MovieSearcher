package com.example.moviesearcher.model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieApi {
    @GET("movies")
    Call<MovieApiData> getAllMovies();
}
