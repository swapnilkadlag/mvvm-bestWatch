package com.example.bestwatch.model.services;

import com.example.bestwatch.model.BestWatch;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MoviesService {

    private static Retrofit retrofit=new Retrofit.Builder()
            .baseUrl(BestWatch.MOVIES_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static <S> S createMovieService(Class<S> serviceClass){
        return retrofit.create(serviceClass);
    }
}
