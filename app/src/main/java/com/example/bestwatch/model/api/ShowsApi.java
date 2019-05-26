package com.example.bestwatch.model.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ShowsApi {

    @GET("airing_today")
    Call<ShowResult> getAiringTodayShows(@Query("api_key") String apiKey);

    @GET("popular")
    Call<ShowResult> getPopularShows(@Query("api_key") String apiKey);

    @GET("top_rated")
    Call<ShowResult> getTopRatedShows(@Query("api_key") String apiKey);


}
