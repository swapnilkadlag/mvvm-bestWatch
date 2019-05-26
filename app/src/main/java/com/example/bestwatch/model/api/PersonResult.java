package com.example.bestwatch.model.api;

import com.example.bestwatch.model.objects.Person;
import com.google.gson.annotations.SerializedName;

public class PersonResult {

    @SerializedName("results")
    private Person[] personResults;

    public Person[] getPersonResults() {
        return personResults;
    }
}
