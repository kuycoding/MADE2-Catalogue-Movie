package com.kuycoding.moviecatalogue.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.kuycoding.moviecatalogue.Movies;
import com.kuycoding.moviecatalogue.DetailMovieActivity;
import com.kuycoding.moviecatalogue.R;

import java.util.ArrayList;

public class CardViewMoviesAdapter extends RecyclerView.Adapter<CardViewMoviesAdapter.CardViewViewHolder> {
    private Context context;
    private ArrayList<Movies> lisMovies;

    public ArrayList<Movies> getListMovies() {
        return lisMovies;
    }

    public CardViewMoviesAdapter(ArrayList<Movies> list) {
        this.lisMovies = list;
    }

        public CardViewMoviesAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_movies, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder holder, int position) {

        Movies movies = lisMovies.get(position);

        Glide.with(holder.itemView.getContext())
                .load(movies.getPoster())
                .apply(new RequestOptions().override(350,550))
                .into(holder.imgPoster);

        holder.tvTitle.setText(movies.getTitle());
        holder.tvRuntime.setText(movies.getRuntime());
        holder.tvGenre.setText(movies.getGenre());
        holder.tvRatingBar.setProgress(movies.getRating());


    }

    @Override
    public int getItemCount() {
        return lisMovies.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imgPoster;
        TextView tvTitle, tvRuntime, tvGenre;
        RatingBar tvRatingBar;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.img_item_photo);
            tvTitle = itemView.findViewById(R.id.tv_item_name);
            tvGenre = itemView.findViewById(R.id.tv_item_genre);
            tvRuntime = itemView.findViewById(R.id.tv_item_time);
            tvRatingBar = itemView.findViewById(R.id.rating);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Movies movies = getListMovies().get(position);

            movies.setTitle(movies.getTitle());
            movies.setOverview(movies.getOverview());

            Intent intent = new Intent(itemView.getContext(), DetailMovieActivity.class);
            intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movies);
            view.getContext().startActivity(intent);
        }
    }
}
