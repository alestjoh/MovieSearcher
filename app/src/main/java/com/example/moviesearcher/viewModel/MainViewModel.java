package com.example.moviesearcher.viewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.moviesearcher.model.MovieApi;
import com.example.moviesearcher.model.MovieApiData;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainViewModel extends ViewModel {
    private MovieApi api;
    private MutableLiveData<MovieApiData> movieData = new MutableLiveData<>();

    private void initRetrofit() {
        api = new Retrofit.Builder()
                .baseUrl("https://movies-sample.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MovieApi.class);
    }

    private void retreiveDataFromApi() {
        if (api == null) {
            initRetrofit();
        }

    }
}
