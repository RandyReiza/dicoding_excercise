package com.example.moviecatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] movieTitle;
    private String[] movieYear;
    private String[] movieScore;
    private String[] movieOverview;
    private String[] movieDirector;
    private String[] movieCast;
    private TypedArray moviePoster;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // prepare data
        prepare();

        ListView listView = findViewById(R.id.list_movie);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, movieTitle);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, movieTitle[i], Toast.LENGTH_SHORT).show();
                // Object Movie
                Movie movie = new Movie();
                movie.setTitle(movieTitle[i]);
                movie.setYear(movieYear[i]);
                movie.setUserScore(movieScore[i]);
                movie.setOverview(movieOverview[i]);
                movie.setDirector(movieDirector[i]);
                movie.setCast(movieCast[i]);
                movie.setPoster(moviePoster.getResourceId(i, -1));

                Intent detailMovie = new Intent(MainActivity.this, DetailMovieActivity.class);
                detailMovie.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie);
                startActivity(detailMovie);
            }
        });
    }

    private void prepare() {
        moviePoster = getResources().obtainTypedArray(R.array.movie_poster);
        movieTitle = getResources().getStringArray(R.array.movie_title);
        movieYear = getResources().getStringArray(R.array.movie_year);
        movieScore = getResources().getStringArray(R.array.movie_score);
        movieOverview = getResources().getStringArray(R.array.movie_overview);
        movieDirector = getResources().getStringArray(R.array.movie_director);
        movieCast = getResources().getStringArray(R.array.movie_cast);
    }
}
