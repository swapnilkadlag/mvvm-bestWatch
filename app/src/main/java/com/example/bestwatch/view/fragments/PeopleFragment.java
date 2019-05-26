package com.example.bestwatch.view.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bestwatch.R;
import com.example.bestwatch.model.objects.Person;
import com.example.bestwatch.view.activities.PersonActivity;
import com.example.bestwatch.view.adapters.PeopleAdapter;
import com.example.bestwatch.viewmodel.MainViewModel;

import java.util.ArrayList;

public class PeopleFragment extends Fragment {

    private RecyclerView recyclerView;
    private PeopleAdapter peopleAdapter;
    private ContentLoadingProgressBar contentLoadingProgressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_people, container, false);

        contentLoadingProgressBar = view.findViewById(R.id.progress_circular);

        MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        recyclerView = view.findViewById(R.id.people_recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));

        viewModel.getPopularPeopleList().observe(this, new Observer<ArrayList<Person>>() {
            @Override
            public void onChanged(ArrayList<Person> peopleList) {
                peopleAdapter = new PeopleAdapter(getActivity(), peopleList);
                peopleAdapter.notifyDataSetChanged();
                contentLoadingProgressBar.setVisibility(View.GONE);
                recyclerView.setAdapter(peopleAdapter);
                peopleAdapter.setOnItemClickListener(new PeopleAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(Person person) {
                        Intent intent = new Intent(getActivity(), PersonActivity.class);
                        intent.putExtra("Name", person.getName());
                        intent.putExtra("Profile", person.getImageUrl());
                        startActivity(intent);
                    }
                });
            }
        });
        return view;
    }

}
