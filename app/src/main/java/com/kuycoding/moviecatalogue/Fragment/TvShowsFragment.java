package com.kuycoding.moviecatalogue.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kuycoding.moviecatalogue.Adapter.CardViewMoviesAdapter;
import com.kuycoding.moviecatalogue.Adapter.CardViewTvShowsAdapter;
import com.kuycoding.moviecatalogue.Model.TvShowsData;
import com.kuycoding.moviecatalogue.R;
import com.kuycoding.moviecatalogue.TvShows;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvShowsFragment extends Fragment {

    private RecyclerView rvTvShows;
    private ArrayList<TvShows> list = new ArrayList<>();


    public TvShowsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tv_shows, container, false);
        rvTvShows = view.findViewById(R.id.rv_tv_shows);
        rvTvShows.setHasFixedSize(true);

        list.addAll(TvShowsData.getListDataTv());
        showRecycleView();

        return view;

    }
    private void showRecycleView() {
        rvTvShows.setLayoutManager(new LinearLayoutManager(this.getContext()));
        CardViewTvShowsAdapter cardViewTvShowsAdapter = new CardViewTvShowsAdapter(list);
        rvTvShows.setAdapter(cardViewTvShowsAdapter);
    }
}
