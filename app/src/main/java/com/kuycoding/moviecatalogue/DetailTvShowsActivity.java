package com.kuycoding.moviecatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailTvShowsActivity extends AppCompatActivity {

    public static final String EXTRA_TV = "extra_tv";

    private TextView tvTitle, tvOverview, tvStatus, tvType, tvLanguage, tvRuntime, tvGenre, tvImdb, tvUser_score;
    ImageView imgPoster, imgCover;
    private RatingBar rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv_shows_detail);

        tvTitle = findViewById(R.id.txt_title);
        tvRuntime = findViewById(R.id.txt_runtime);
        tvImdb = findViewById(R.id.txt_imdb);
        tvUser_score = findViewById(R.id.txt_userscore);
        tvStatus = findViewById(R.id.txt_release);
        tvType = findViewById(R.id.txt_type);
        tvLanguage = findViewById(R.id.txt_lang);
        tvGenre = findViewById(R.id.txt_genre);
        tvOverview = findViewById(R.id.txt_overview);
        imgCover = findViewById(R.id.img_cover);
        imgPoster = findViewById(R.id.img_poster);
        rating = (RatingBar)findViewById(R.id.rating);

        TvShows tvShows = getIntent().getParcelableExtra(EXTRA_TV);

        tvTitle.setText(tvShows.getTitle());
        tvOverview.setText(tvShows.getOverview());
        tvStatus.setText(tvShows.getStatus());
        tvType.setText(tvShows.getType());
        tvLanguage.setText(tvShows.getLanguage());
        tvRuntime.setText(tvShows.getRuntime());
        tvGenre.setText(tvShows.getGenre());
        tvImdb.setText(tvShows.getImdb());
        tvUser_score.setText(tvShows.getUser_score());

        Glide.with(this)
                .load(tvShows.getPoster())
                .apply(new RequestOptions().override(350, 550))
                .into(imgPoster);

        Glide.with(this)
                .load(tvShows.getCover())
                .apply(new RequestOptions().override(350, 550))
                .into(imgCover);
    }
}
