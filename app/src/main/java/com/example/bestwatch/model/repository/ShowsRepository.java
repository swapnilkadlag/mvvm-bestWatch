package com.example.bestwatch.model.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.bestwatch.model.BestWatch;
import com.example.bestwatch.model.api.ShowResult;
import com.example.bestwatch.model.api.ShowsApi;
import com.example.bestwatch.model.objects.Show;
import com.example.bestwatch.model.services.ShowsService;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShowsRepository {

    private ShowsApi showsApi;

    private MutableLiveData<ArrayList<Show>> airingTodayShowsList;
    private MutableLiveData<ArrayList<Show>> popularShowsList;
    private MutableLiveData<ArrayList<Show>> topRatedShowsList;

    public ShowsRepository() {
        showsApi = ShowsService.createShowsService(ShowsApi.class);
    }

    public MutableLiveData<ArrayList<Show>> getAiringTodayShowsList() {
        if (airingTodayShowsList == null) {
            airingTodayShowsList = new MutableLiveData<>();
            getAiringTodayShows();
        }
        return airingTodayShowsList;
    }

    public MutableLiveData<ArrayList<Show>> getPopularShowsList() {
        if (popularShowsList == null) {
            popularShowsList = new MutableLiveData<>();
            getPopularShows();
        }
        return popularShowsList;
    }

    public MutableLiveData<ArrayList<Show>> getTopRatedShowsList() {
        if (topRatedShowsList == null) {
            topRatedShowsList = new MutableLiveData<>();
            getTopRatedShows();
        }
        return topRatedShowsList;
    }

    private void getAiringTodayShows() {
        Call<ShowResult> call=showsApi.getAiringTodayShows(BestWatch.API_KEY);

        call.enqueue(new Callback<ShowResult>() {
            @Override
            public void onResponse(Call<ShowResult> call, Response<ShowResult> response) {
                ShowResult showResult=response.body();
                ArrayList<Show> showArrayList=new ArrayList<>(Arrays.asList(showResult.getShowsResults()));
                airingTodayShowsList.setValue(showArrayList);
            }

            @Override
            public void onFailure(Call<ShowResult> call, Throwable t) {

            }
        });
    }

    private void getPopularShows() {
        Call<ShowResult> call = showsApi.getPopularShows(BestWatch.API_KEY);

        call.enqueue(new Callback<ShowResult>() {
            @Override
            public void onResponse(Call<ShowResult> call, Response<ShowResult> response) {
                ShowResult showResult=response.body();
                ArrayList<Show> showArrayList=new ArrayList<>(Arrays.asList(showResult.getShowsResults()));
                popularShowsList.setValue(showArrayList);
            }

            @Override
            public void onFailure(Call<ShowResult> call, Throwable t) {

            }
        });
    }

    private void getTopRatedShows() {
        Call<ShowResult> call = showsApi.getTopRatedShows(BestWatch.API_KEY);

        call.enqueue(new Callback<ShowResult>() {
            @Override
            public void onResponse(Call<ShowResult> call, Response<ShowResult> response) {
                ShowResult showResult = response.body();
                ArrayList<Show> showArrayList = new ArrayList<>(Arrays.asList(showResult.getShowsResults()));
                topRatedShowsList.setValue(showArrayList);
            }

            @Override
            public void onFailure(Call<ShowResult> call, Throwable t) {

            }
        });
    }
}
