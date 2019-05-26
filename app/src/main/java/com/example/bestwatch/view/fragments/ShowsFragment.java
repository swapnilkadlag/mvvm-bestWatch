package com.example.bestwatch.view.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bestwatch.R;
import com.example.bestwatch.model.objects.Show;
import com.example.bestwatch.view.activities.MovieActivity;
import com.example.bestwatch.view.adapters.ShowsAdapter;
import com.example.bestwatch.viewmodel.MainViewModel;

import java.util.ArrayList;

public class ShowsFragment extends Fragment {

    private RecyclerView recyclerView;
    private ShowsAdapter showsAdapter;
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

        viewModel.getAiringTodayShowsList().observe(this, new Observer<ArrayList<Show>>() {
            @Override
            public void onChanged(ArrayList<Show> moviesList) {
                showsAdapter = new ShowsAdapter(getActivity(), moviesList);
                showsAdapter.notifyDataSetChanged();
                contentLoadingProgressBar.setVisibility(View.GONE);
                recyclerView.setAdapter(showsAdapter);
                showsAdapter.setOnItemClickListener(new ShowsAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(Show show) {
                        Intent intent = new Intent(getActivity(), MovieActivity.class);
                        intent.putExtra("Title", show.getTitle());
                        String rating = String.valueOf(show.getRating());
                        intent.putExtra("Rating", rating);
                        intent.putExtra("Year", show.getReleaseDate());
                        intent.putExtra("Poster", show.getPosterUrl());
                        intent.putExtra("Genre", show.getGenre());
                        intent.putExtra("Summary", show.getSummary());
                        startActivity(intent);
                    }
                });
            }
        });
        return view;
    }

}
