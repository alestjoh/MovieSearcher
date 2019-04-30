package com.example.moviesearcher.modules;

import com.example.moviesearcher.model.MovieApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class MovieNetworkModule {

    @Provides
    @Singleton
    public Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://movies-sample.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public MovieApi getApi(Retrofit retrofit) {
        return retrofit.create(MovieApi.class);
    }
}
