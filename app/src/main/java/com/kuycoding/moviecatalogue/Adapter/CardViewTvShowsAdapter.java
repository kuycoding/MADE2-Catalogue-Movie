package com.kuycoding.moviecatalogue.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.kuycoding.moviecatalogue.DetailTvShowsActivity;
import com.kuycoding.moviecatalogue.R;
import com.kuycoding.moviecatalogue.TvShows;

import java.util.ArrayList;

public class CardViewTvShowsAdapter extends RecyclerView.Adapter<CardViewTvShowsAdapter.ListViewHolder> {

    private ArrayList<TvShows> listTv;

    public ArrayList<TvShows> getListTv() {
        return listTv;
    }

    public CardViewTvShowsAdapter(ArrayList<TvShows> list) {
        this.listTv = list;
    }
    @NonNull
    @Override
    public CardViewTvShowsAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_tvshows, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewTvShowsAdapter.ListViewHolder holder, int position) {
        TvShows tvShows = listTv.get(position);

        Glide.with(holder.itemView.getContext())
                .load(tvShows.getPoster())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPoster);

        holder.tvTitle.setText(tvShows.getTitle());
        holder.tvRuntime.setText(tvShows.getRuntime());
        holder.tvGenre.setText(tvShows.getGenre());

    }

    @Override
    public int getItemCount() {
        return listTv.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imgPoster;
        TextView tvTitle, tvRuntime, tvGenre;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.img_item_photo);
            tvTitle = itemView.findViewById(R.id.tv_item_name);
            tvRuntime = itemView.findViewById(R.id.tv_item_time);
            tvGenre = itemView.findViewById(R.id.tv_item_genre);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            int position = getAdapterPosition();
            TvShows tvShows = getListTv().get(position);

            tvShows.setTitle(tvShows.getTitle());
            tvShows.setOverview(tvShows.getOverview());

            Intent intent = new Intent(itemView.getContext(), DetailTvShowsActivity.class);
            intent.putExtra(DetailTvShowsActivity.EXTRA_TV, tvShows);
            view.getContext().startActivity(intent);
        }
    }
}
