package com.example.bestwatch.model.objects;

/*{
      "popularity": 58.938,
      "id": 1033632,
      "profile_path": "/grkDGC4RBIN7d4CJ9uOhKdouNST.jpg",
      "name": "Victória Guerra",
      "known_for": [
        {
          "vote_average": 7.6,
          "vote_count": 37,
          "id": 315868,
          "video": false,
          "media_type": "movie",
          "title": "Cosmos",
          "popularity": 3.468,
          "poster_path": "/6URD5yquEQMqUjTgsdDGD8KTymy.jpg",
          "original_language": "fr",
          "original_title": "Cosmos",
          "genre_ids": [
            18
          ],
          "backdrop_path": "/35k6AyKKPixaRde0uQDfHb2MgCa.jpg",
          "adult": false,
          "overview": "Two young men seek the solitude of the country; their peace is disturbed when a set of random occurrences suggest to their susceptible minds a pattern with sinister meanings.",
          "release_date": "2015-12-03"
        },
       */

import com.google.gson.annotations.SerializedName;

public class Person {

    @SerializedName("id")
    private int id;

    @SerializedName("profile_path")
    private String imageUrl;

    @SerializedName("name")
    private String name;

    public Person(int id, String imageUrl, String name) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getName() {
        return name;
    }
}
