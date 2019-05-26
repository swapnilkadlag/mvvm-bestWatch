package com.example.bestwatch.model.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PeopleApi {

    @GET("popular")
    Call<PersonResult> getPopularPeople(@Query("api_key") String apiKey);
}
