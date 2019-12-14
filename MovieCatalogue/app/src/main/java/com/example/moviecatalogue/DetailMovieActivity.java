package com.example.moviecatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailMovieActivity extends AppCompatActivity {
    public static final String EXTRA_MOVIE = "extra_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        TextView movieTitleYear = findViewById(R.id.movie_title_year);
        TextView movieScore = findViewById(R.id.movie_score);
        TextView movieOverview = findViewById(R.id.movie_overview);
        TextView movieDirector = findViewById(R.id.movie_director);
        TextView movieCast = findViewById(R.id.movie_cast);
        ImageView moviePoster = findViewById(R.id.movie_poster);

        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);

        assert movie != null;

        String textTitleYear = movie.getTitle() + " (" + movie.getYear() + ")";
        movieTitleYear.setText(textTitleYear);

        String textScore = movie.getUserScore();
        movieScore.setText(textScore);

        String textOverview = movie.getOverview();
        movieOverview.setText(textOverview);

        String textDirector = movie.getDirector();
        movieDirector.setText(textDirector);

        String textCast = movie.getCast();
        movieCast.setText(textCast);

        int textPoster = movie.getPoster();
        moviePoster.setImageResource(textPoster);
    }
}
