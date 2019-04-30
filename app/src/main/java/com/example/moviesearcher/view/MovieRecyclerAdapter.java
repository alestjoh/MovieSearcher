package com.example.moviesearcher.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.moviesearcher.R;
import com.example.moviesearcher.model.MovieApiData;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieRecyclerAdapter extends
        RecyclerView.Adapter<MovieRecyclerAdapter.MovieViewHolder> {

    private List<MovieApiData.MovieData> data;

    public MovieRecyclerAdapter(List<MovieApiData.MovieData> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.movie_recycler_item_layout, viewGroup, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int i) {
        MovieApiData.MovieData item = data.get(i);

        movieViewHolder.title.setText(item.title);
        movieViewHolder.year.setText(item.year);
        movieViewHolder.genre.setText(item.genre);

        Picasso.get().load(item.poster).into(movieViewHolder.poster);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {

        public TextView title, genre, year;
        public ImageView poster;

        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.tv_title_item);
            genre = itemView.findViewById(R.id.tv_genre_item);
            year = itemView.findViewById(R.id.tv_year_item);
            poster = itemView.findViewById(R.id.iv_poster_item);
        }
    }
}
