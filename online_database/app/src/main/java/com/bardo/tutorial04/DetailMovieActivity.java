package com.bardo.tutorial04;

import android.os.Bundle;

import com.bardo.tutorial04.model.ResultsItem;
import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Parcel;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.parceler.Parcels;

public class DetailMovieActivity extends AppCompatActivity {

    ResultsItem dataMovie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bundle = getIntent().getBundleExtra(FilmAdapter.DATA_EXTRA);
        dataMovie = Parcels.unwrap(bundle.getParcelable(FilmAdapter.DATA_MOVIE));

        getSupportActionBar().setTitle(dataMovie.getTitle());
//        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
//        toolBarLayout.setTitle(getTitle());


        ImageView ivBackdrop = findViewById(R.id.ivDetailPoster);
        TextView tvDetailDeskripsi = findViewById(R.id.tvDetailDescription);

        Glide.with(DetailMovieActivity.this).load("https://image.tmdb.org/t/p/w500" + dataMovie.getBackdropPath()).into(ivBackdrop);
        tvDetailDeskripsi.setText(dataMovie.getOverview());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}