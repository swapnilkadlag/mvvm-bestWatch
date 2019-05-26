package com.example.bestwatch.view.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bestwatch.R;
import com.example.bestwatch.model.objects.Movie;
import com.example.bestwatch.view.activities.MovieActivity;
import com.example.bestwatch.view.adapters.MoviesAdapter;
import com.example.bestwatch.viewmodel.MainViewModel;

import java.util.ArrayList;

public class MoviesFragment extends Fragment {

    private RecyclerView recyclerView;
    private MoviesAdapter moviesAdapter;
    private ContentLoadingProgressBar contentLoadingProgressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies, container, false);

        contentLoadingProgressBar = view.findViewById(R.id.progress_circular);

        MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        recyclerView = view.findViewById(R.id.movies_recyclerView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        viewModel.getNowPlayingMovies().observe(this, new Observer<ArrayList<Movie>>() {
            @Override
            public void onChanged(ArrayList<Movie> moviesList) {
                moviesAdapter = new MoviesAdapter(getActivity(), moviesList);
                recyclerView.setAdapter(moviesAdapter);
                moviesAdapter.notifyDataSetChanged();
                contentLoadingProgressBar.setVisibility(View.GONE);
                moviesAdapter.setOnItemClickListener(new MoviesAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(Movie movie) {
                        Intent intent = new Intent(getActivity(), MovieActivity.class);
                        intent.putExtra("Title", movie.getTitle());
                        String rating = String.valueOf(movie.getRating());
                        intent.putExtra("Rating", rating);
                        intent.putExtra("Year", movie.getReleaseDate());
                        intent.putExtra("Poster", movie.getPosterUrl());
                        intent.putExtra("Genre", movie.getGenre());
                        intent.putExtra("Summary", movie.getSummary());
                        startActivity(intent);
                    }
                });
            }
        });


        return view;
    }
}

