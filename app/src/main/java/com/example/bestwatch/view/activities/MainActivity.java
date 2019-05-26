package com.example.bestwatch.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.bestwatch.R;
import com.example.bestwatch.view.fragments.MoviesFragment;
import com.example.bestwatch.view.fragments.PeopleFragment;
import com.example.bestwatch.view.fragments.ShowsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    MoviesFragment moviesFragment;
    ShowsFragment showsFragment;
    PeopleFragment peopleFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton searchButton = findViewById(R.id.search_imageButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MovieActivity.class);
                startActivity(intent);
            }
        });

        moviesFragment = new MoviesFragment();
        showsFragment = new ShowsFragment();
        peopleFragment = new PeopleFragment();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        loadDefaultFragment(moviesFragment);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    switch (menuItem.getItemId()) {
                        case R.id.movies:
                            displayMoviesFragment();
                            break;
                        case R.id.shows:
                            displayShowsFragment();
                            break;
                        case R.id.people:
                            displayPeopleFragment();
                    }
                    return true;
                }
            };

    private void loadDefaultFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }

    protected void displayMoviesFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (moviesFragment.isAdded()) {
            ft.show(moviesFragment);
        } else {
            ft.add(R.id.fragment_container, moviesFragment, "Movies");
        }
        if (showsFragment.isAdded()) {
            ft.hide(showsFragment);
        }
        if (peopleFragment.isAdded()) {
            ft.hide(peopleFragment);
        }
        ft.commit();
    }

    protected void displayShowsFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (showsFragment.isAdded()) {
            ft.show(showsFragment);
        } else {
            ft.add(R.id.fragment_container, showsFragment, "Shows");
        }
        if (moviesFragment.isAdded()) {
            ft.hide(moviesFragment);
        }
        if (peopleFragment.isAdded()) {
            ft.hide(peopleFragment);
        }
        ft.commit();
    }

    protected void displayPeopleFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (peopleFragment.isAdded()) {
            ft.show(peopleFragment);
        } else {
            ft.add(R.id.fragment_container, peopleFragment, "People");
        }
        if (moviesFragment.isAdded()) {
            ft.hide(moviesFragment);
        }
        if (showsFragment.isAdded()) {
            ft.hide(showsFragment);
        }
        ft.commit();
    }

}
