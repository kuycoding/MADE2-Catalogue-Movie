package com.kuycoding.moviecatalogue.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kuycoding.moviecatalogue.Adapter.CardViewMoviesAdapter;
import com.kuycoding.moviecatalogue.Model.MoviesData;
import com.kuycoding.moviecatalogue.Movies;
import com.kuycoding.moviecatalogue.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {

    private RecyclerView rvMovies;
    private ArrayList<Movies> list = new ArrayList<>();


    public MoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movies, container, false);
        rvMovies = view.findViewById(R.id.rv_movies);
        rvMovies.setHasFixedSize(true);

        list.addAll(MoviesData.getListData());
        showRecycleView();

        return view;
    }

    private void showRecycleView() {
        rvMovies.setLayoutManager(new LinearLayoutManager(this.getContext()));
        CardViewMoviesAdapter cardViewMoviesAdapter = new CardViewMoviesAdapter(list);
        rvMovies.setAdapter(cardViewMoviesAdapter);
    }

}
