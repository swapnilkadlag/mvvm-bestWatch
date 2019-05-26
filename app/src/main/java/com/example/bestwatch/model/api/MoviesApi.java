package com.example.bestwatch.model.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoviesApi {

    @GET("now_playing")
    Call<MovieResult> getNowPlayingMovies(@Query("api_key") String apiKey);

    @GET("popular")
    Call<MovieResult> getPopularMovies(@Query("api_key") String apiKey);

    @GET("top_rated")
    Call<MovieResult> getTopRatedMovies(@Query("api_key") String apiKey);

}
