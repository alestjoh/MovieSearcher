package com.example.moviesearcher.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.moviesearcher.model.MovieApi;
import com.example.moviesearcher.model.MovieApiData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainViewModel extends ViewModel {
    private MovieApi api;

    private MutableLiveData<MovieApiData> movieData = new MutableLiveData<>();

    public LiveData<MovieApiData> getMovieData() {
        return movieData;
    }

    private void initRetrofit() {
        api = new Retrofit.Builder()
                .baseUrl("https://movies-sample.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MovieApi.class);
    }

    private void retrieveDataFromApi() {
        if (api == null) {
            initRetrofit();
        }
        api.getAllMovies().enqueue(new Callback<MovieApiData>() {
            @Override
            public void onResponse(Call<MovieApiData> call, Response<MovieApiData> response) {
                movieData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<MovieApiData> call, Throwable t) {
                movieData.postValue(null);
            }
        });
    }

    public void retrieveData() {
        //TODO: determine whether to get data from Retrofit or Room
        retrieveDataFromApi();
    }
}
