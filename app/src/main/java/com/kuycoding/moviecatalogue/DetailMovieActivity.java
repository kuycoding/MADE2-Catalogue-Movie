package com.kuycoding.moviecatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailMovieActivity extends AppCompatActivity {

    public static final String EXTRA_MOVIE = "extra_movie";
    TextView tvTitle, tvRuntime, tvImdb, tvUserScore, tvStatus, tvDateReleased, tvLang, tvGenre, tvRevenue,tvOverview;
    ImageView imagePoster, imageCover;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_detail);

        tvTitle = findViewById(R.id.txt_title);
        tvRuntime = findViewById(R.id.txt_runtirme);
        tvImdb = findViewById(R.id.txt_imdb);
        tvUserScore = findViewById(R.id.txt_userscore);
        tvStatus = findViewById(R.id.txt_status);
        tvDateReleased = findViewById(R.id.txt_date);
        tvLang = findViewById(R.id.txt_lang);
        tvGenre = findViewById(R.id.txt_genre);
        tvRevenue = findViewById(R.id.txt_revenue);
        tvOverview = findViewById(R.id.txt_overview);
        imageCover = findViewById(R.id.img_cover);
        imagePoster = findViewById(R.id.img_poster);
        ratingBar = (RatingBar)findViewById(R.id.rating);

        Movies movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        tvTitle.setText(movie.getTitle());
        tvRuntime.setText(movie.getRuntime());
        tvImdb.setText(movie.getImdb());
        tvUserScore.setText(movie.getUser_score());
        tvStatus.setText(movie.getStatus());
        tvDateReleased.setText(movie.getRelease_information());
        tvLang.setText(movie.getLanguage());
        tvGenre.setText(movie.getGenre());
        tvRevenue.setText(movie.getRevenue());
        tvOverview.setText(movie.getOverview());
        ratingBar.setRating(movie.getRating());


        Glide.with(this)
                .load(movie.getCover())
                .apply(new RequestOptions().override(350, 550))
                .into(imageCover);

        Glide.with(this)
                .load(movie.getPoster())
                .apply(new RequestOptions().override(350, 550))
                .into(imagePoster);

    }
}
