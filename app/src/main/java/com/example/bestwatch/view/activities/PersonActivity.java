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

public class PersonActivity extends AppCompatActivity {

    ImageView profileImageView;
    TextView nameTextView;
    ImageButton closeImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        closeImageButton = findViewById(R.id.close_imageButton);
        closeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        profileImageView = findViewById(R.id.poster_imageView);
        nameTextView = findViewById(R.id.name_textView);

        Intent intent = getIntent();
        String imageUrl = "https://image.tmdb.org/t/p/original" + intent.getStringExtra("Profile");
        Glide.with(getApplicationContext()).load(imageUrl).centerCrop().placeholder(R.drawable.ic_icon).into(profileImageView);
        nameTextView.setText(intent.getStringExtra("Name"));
    }
}
