package com.example.bestwatch.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bestwatch.model.objects.Movie;
import com.example.bestwatch.model.objects.Person;
import com.example.bestwatch.model.objects.Show;
import com.example.bestwatch.model.repository.MoviesRepository;
import com.example.bestwatch.model.repository.PeopleRepository;
import com.example.bestwatch.model.repository.ShowsRepository;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Movie>> nowPlayingMoviesList;
    private MutableLiveData<ArrayList<Movie>> popularMoviesList;
    private MutableLiveData<ArrayList<Movie>> topRatedMoviesList;
    private MutableLiveData<ArrayList<Show>> airingTodayShowsList;
    private MutableLiveData<ArrayList<Show>> popularShowsList;
    private MutableLiveData<ArrayList<Show>> topRatedShowsList;
    private MutableLiveData<ArrayList<Person>> popularPeopleList;

    public MainViewModel() {
        MoviesRepository moviesRepository = new MoviesRepository();
        ShowsRepository showsRepository = new ShowsRepository();
        PeopleRepository peopleRepository = new PeopleRepository();
        nowPlayingMoviesList = moviesRepository.getNowPlayingMoviesList();
        popularMoviesList = moviesRepository.getPopularMoviesList();
        topRatedMoviesList = moviesRepository.getTopRatedMoviesList();
        airingTodayShowsList = showsRepository.getAiringTodayShowsList();
        popularShowsList = showsRepository.getPopularShowsList();
        topRatedShowsList = showsRepository.getTopRatedShowsList();
        popularPeopleList = peopleRepository.getPopularPeopleList();
    }

    public MutableLiveData<ArrayList<Movie>> getNowPlayingMovies() {
        return nowPlayingMoviesList;
    }

    public MutableLiveData<ArrayList<Movie>> getPopularMoviesList() {
        return popularMoviesList;
    }

    public MutableLiveData<ArrayList<Movie>> getTopRatedMoviesList() {
        return topRatedMoviesList;
    }

    public MutableLiveData<ArrayList<Show>> getAiringTodayShowsList() {
        return airingTodayShowsList;
    }

    public MutableLiveData<ArrayList<Show>> getPopularShowsList() {
        return popularShowsList;
    }

    public MutableLiveData<ArrayList<Show>> getTopRatedShowsList() {
        return topRatedShowsList;
    }

    public MutableLiveData<ArrayList<Person>> getPopularPeopleList(){
        return popularPeopleList;
    }

}
