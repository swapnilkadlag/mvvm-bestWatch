package com.example.bestwatch.model.objects;

/*"results": [
        {
        "vote_count": 5544,
        "id": 299534,
        "video": false,
        "vote_average": 8.5,
        "title": "Avengers: Endgame",
        "popularity": 368.982,
        "poster_path": "/or06FN3Dka5tukK1e9sl16pB3iy.jpg",
        "original_language": "en",
        "original_title": "Avengers: Endgame",
        "genre_ids": [
        12,
        878,
        28
        ],
        "backdrop_path": "/7RyHsO4yDXtBv1zUU3mTpHeQ0d5.jpg",
        "adult": false,
        "overview": "After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order to the universe once and for all, no matter what consequences may be in store.",
        "release_date": "2019-04-24"
        }
]*/

import com.google.gson.annotations.SerializedName;

public class Movie {

    @SerializedName("id")
    private int id;

    @SerializedName("vote_average")
    private float rating;

    @SerializedName("title")
    private String title;

    @SerializedName("poster_path")
    private String posterUrl;

    @SerializedName("backdrop_path")
    private String backdropUrl;

    @SerializedName("genre_ids")
    private int[] genre;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("overview")
    private String summary;

    public Movie(int id, float rating, String title, String posterUrl, String backdropUrl, int[] genre, String releaseDate,String summary) {
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
