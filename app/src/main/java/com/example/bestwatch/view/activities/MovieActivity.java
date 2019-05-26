package com.example.bestwatch.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.bestwatch.R;

public class MovieActivity extends AppCompatActivity {

    ImageView posterImageView;
    TextView titleTextView;
    TextView ratingTextView;
    TextView yearTextView;
    TextView genreTextView;
    TextView summaryTextView;
    ImageButton closeImageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        closeImageButton = findViewById(R.id.close_imageButton);
        closeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        posterImageView = findViewById(R.id.poster_imageView);
        titleTextView = findViewById(R.id.title_textView);
        ratingTextView = findViewById(R.id.rating_textView);
        yearTextView = findViewById(R.id.year_textView);
        genreTextView = findViewById(R.id.genre_textView);
        summaryTextView = findViewById(R.id.summary_textView);

        Intent intent = getIntent();
        String imageUrl = "https://image.tmdb.org/t/p/original" + intent.getStringExtra("Poster");
        Glide.with(getApplicationContext()).load(imageUrl).centerCrop().placeholder(R.drawable.ic_icon).into(posterImageView);
        titleTextView.setText(intent.getStringExtra("Title"));
        ratingTextView.setText(intent.getStringExtra("Rating"));
        yearTextView.setText(intent.getStringExtra("Year"));
        int[] genreArray = intent.getIntArrayExtra("Genre");
        int genreId = 0;
        if (genreArray.length > 0) genreId = genreArray[0];
        genreTextView.setText(getGenre(genreId));
        summaryTextView.setText(intent.getStringExtra("Summary"));

    }

    public String getGenre(int genreId) {

        String genre;

        switch (genreId) {
            case 28:
                genre = "Action";
                break;
            case 12:
                genre = "Adventure";
                break;
            case 16:
                genre = "Animation";
                break;
            case 35:
                genre = "Comedy";
                break;
            case 80:
                genre = "Crime";
                break;
            case 99:
                genre = "Documentary";
                break;
            case 18:
                genre = "Drama";
                break;
            case 10751:
                genre = "Family";
                break;
            case 14:
                genre = "Fantasy";
                break;
            case 36:
                genre = "History";
                break;
            case 27:
                genre = "Horror";
                break;
            case 10402:
                genre = "Music";
                break;
            case 9648:
                genre = "Mystery";
                break;
            case 10749:
                genre = "Romance";
                break;
            case 878:
                genre = "Science Fiction";
                break;
            case 10770:
                genre = "TV Movie";
                break;
            case 53:
                genre = "Thriller";
                break;
            case 10752:
                genre = "War";
                break;
            case 37:
                genre = "Western";
                break;
            case 0:
                genre = "N/A";
                break;
            default:
                genre = "N/A";
                break;
        }
        return genre;
    }
}
