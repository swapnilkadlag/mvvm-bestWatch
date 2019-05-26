package com.example.bestwatch.model.services;

import com.example.bestwatch.model.BestWatch;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PeopleService {

    private static Retrofit retrofit=new Retrofit.Builder()
            .baseUrl(BestWatch.PEOPLE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static <S> S createPeopleService(Class<S> serviceClass){
        return retrofit.create(serviceClass);
    }
}
