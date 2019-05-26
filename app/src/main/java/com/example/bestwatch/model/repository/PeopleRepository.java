package com.example.bestwatch.model.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.bestwatch.model.BestWatch;
import com.example.bestwatch.model.api.PeopleApi;
import com.example.bestwatch.model.api.PersonResult;
import com.example.bestwatch.model.objects.Person;
import com.example.bestwatch.model.services.PeopleService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeopleRepository {

    private PeopleApi peopleApi;

    private MutableLiveData<ArrayList<Person>> popularPeopleList;

    public PeopleRepository() {
        peopleApi = PeopleService.createPeopleService(PeopleApi.class);
    }

    public MutableLiveData<ArrayList<Person>> getPopularPeopleList() {
        if (popularPeopleList == null) {
            popularPeopleList = new MutableLiveData<>();
            getPopularPeople();
        }
        return popularPeopleList;
    }

    private void getPopularPeople() {
        Call<PersonResult> call = peopleApi.getPopularPeople(BestWatch.API_KEY);

        call.enqueue(new Callback<PersonResult>() {
            @Override
            public void onResponse(Call<PersonResult> call, Response<PersonResult> response) {
                PersonResult personResult = response.body();
                ArrayList<Person> personArrayList = new ArrayList<>(Arrays.asList(personResult.getPersonResults()));
                popularPeopleList.setValue(personArrayList);
            }

            @Override
            public void onFailure(Call<PersonResult> call, Throwable t) {

            }
        });
    }

}
