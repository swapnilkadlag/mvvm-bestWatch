package com.example.bestwatch.model.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.bestwatch.model.api.MovieResult;
import com.example.bestwatch.model.BestWatch;
import com.example.bestwatch.model.api.MoviesApi;
import com.example.bestwatch.model.objects.Movie;
import com.example.bestwatch.model.services.MoviesService;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesRepository {

    private MoviesApi moviesApi;

    private MutableLiveData<ArrayList<Movie>> nowPlayingMoviesList;
    private MutableLiveData<ArrayList<Movie>> popularMoviesList;
    private MutableLiveData<ArrayList<Movie>> topRatedMoviesList;

    public MoviesRepository() {
        moviesApi = MoviesService.createMovieService(MoviesApi.class);
    }

    public MutableLiveData<ArrayList<Movie>> getNowPlayingMoviesList() {
        if (nowPlayingMoviesList == null) {
            nowPlayingMoviesList = new MutableLiveData<>();
            getNowPlayingMovies();
        }
        return nowPlayingMoviesList;
    }

    public MutableLiveData<ArrayList<Movie>> getPopularMoviesList() {
        if (popularMoviesList == null) {
            popularMoviesList = new MutableLiveData<>();
            getPopularMovies();
        }
        return popularMoviesList;
    }

    public MutableLiveData<ArrayList<Movie>> getTopRatedMoviesList() {
        if (topRatedMoviesList == null) {
            topRatedMoviesList = new MutableLiveData<>();
            getTopRatedMovies();
        }
        return topRatedMoviesList;
    }

    private void getNowPlayingMovies() {
        Call<MovieResult> call = moviesApi.getNowPlayingMovies(BestWatch.API_KEY);

        call.enqueue(new Callback<MovieResult>() {
            @Override
            public void onResponse(Call<MovieResult> call, Response<MovieResult> response) {
                MovieResult movieResult = response.body();
                ArrayList<Movie> movieArrayList = new ArrayList<>(Arrays.asList(movieResult.getMoviesResults()));
                nowPlayingMoviesList.setValue(movieArrayList);
            }

            @Override
            public void onFailure(Call<MovieResult> call, Throwable t) {

            }
        });
    }

    private void getPopularMovies() {
        Call<MovieResult> call = moviesApi.getPopularMovies(BestWatch.API_KEY);

        call.enqueue(new Callback<MovieResult>() {
            @Override
            public void onResponse(Call<MovieResult> call, Response<MovieResult> response) {
                MovieResult movieResult = response.body();
                ArrayList<Movie> movieArrayList = new ArrayList<>(Arrays.asList(movieResult.getMoviesResults()));
                popularMoviesList.setValue(movieArrayList);
            }

            @Override
            public void onFailure(Call<MovieResult> call, Throwable t) {

            }
        });
    }

    private void getTopRatedMovies() {
        Call<MovieResult> call = moviesApi.getTopRatedMovies(BestWatch.API_KEY);

        call.enqueue(new Callback<MovieResult>() {
            @Override
            public void onResponse(Call<MovieResult> call, Response<MovieResult> response) {
                MovieResult movieResult = response.body();
                ArrayList<Movie> movieArrayList = new ArrayList<>(Arrays.asList(movieResult.getMoviesResults()));
                topRatedMoviesList.setValue(movieArrayList);
            }

            @Override
            public void onFailure(Call<MovieResult> call, Throwable t) {

            }
        });
    }

}
