package com.example.moviesearcher.view;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.moviesearcher.R;
import com.example.moviesearcher.model.MovieApiData;
import com.example.moviesearcher.viewModel.MainViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements TextWatcher {

    String searchString = null;

    @BindView(R.id.et_search_main)
    public EditText search;
    @BindView(R.id.recycler_view_main)
    public RecyclerView recyclerView;

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        viewModel.getMovieData().observe(this, this::onDataListChanged);
        viewModel.retrieveData();

        search.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) { }

    @Override
    public void afterTextChanged(Editable s) {
        searchString = s.toString();
        viewModel.retrieveData();
    }

    private void onDataListChanged(MovieApiData movieApiData) {
        if (movieApiData != null && movieApiData.data != null) {
            List<MovieApiData.MovieData> data = movieApiData.data;

            filterBySearchString(data);

            recyclerView.setAdapter(new MovieRecyclerAdapter(data));
        }
    }

    private void filterBySearchString(List<MovieApiData.MovieData> data) {
        if (searchString != null && searchString.length() > 0) {
            for (int i = data.size() - 1; i >= 0; i--) {
                if (!data.get(i).containsString(searchString)) {
                    data.remove(i);
                }
            }
        }
    }
}
