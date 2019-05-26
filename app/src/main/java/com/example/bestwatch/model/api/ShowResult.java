package com.example.bestwatch.model.api;

import com.example.bestwatch.model.objects.Show;
import com.google.gson.annotations.SerializedName;

public class ShowResult {

    @SerializedName("results")
    private Show[] showsResults;

    public Show[] getShowsResults() {
        return showsResults;
    }

}
