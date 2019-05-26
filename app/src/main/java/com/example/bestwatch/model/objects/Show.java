package com.example.bestwatch.model.objects;

/*"results": [
    {
      "original_name": "Game of Thrones",
      "genre_ids": [
        18,
        10759,
        10765
      ],
      "name": "Game of Thrones",
      "popularity": 545.987,
      "origin_country": [
        "US"
      ],
      "vote_count": 5874,
      "first_air_date": "2011-04-17",
      "backdrop_path": "/qsD5OHqW7DSnaQ2afwz8Ptht1Xb.jpg",
      "original_language": "en",
      "id": 1399,
      "vote_average": 8.1,
      "overview": "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
      "poster_path": "/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg"
    }
]*/

import com.google.gson.annotations.SerializedName;

public class Show {

    @SerializedName("id")
    private int id;

    @SerializedName("vote_average")
    private float rating;

    @SerializedName("name")
    private String title;

    @SerializedName("poster_path")
    private String posterUrl;

    @SerializedName("backdrop_path")
    private String backdropUrl;

    @SerializedName("genre_ids")
    private int[] genre;

    @SerializedName("first_air_date")
    private String releaseDate;

    @SerializedName("overview")
    private String summary;

    public Show(int id, float rating, String title, String posterUrl, String backdropUrl, int[] genre, String releaseDate, String summary) {
        this.id = id;
        this.rating = rating;
        this.title = title;
        this.posterUrl = posterUrl;
        this.backdropUrl = backdropUrl;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.summary = summary;
    }

    public int getId() {
        return id;
    }

    public float getRating() {
        return rating;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public String getBackdropUrl() {
        return backdropUrl;
    }

    public int[] getGenre() {
        return genre;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getSummary() {
        return summary;
    }
}
