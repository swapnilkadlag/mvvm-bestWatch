package com.example.bestwatch.model.api;

import com.example.bestwatch.model.objects.Movie;
import com.google.gson.annotations.SerializedName;

public class MovieResult {

    @SerializedName("results")
    private Movie[] moviesResults;

    public Movie[] getMoviesResults() {
        return moviesResults;
    }


}
