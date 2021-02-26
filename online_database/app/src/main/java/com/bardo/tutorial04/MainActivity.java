package com.bardo.tutorial04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.bardo.tutorial04.model.ResponseMovie;
import com.bardo.tutorial04.model.ResultsItem;
import com.bardo.tutorial04.retrofit.RetrofitConfig;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ResultsItem> dataFilm = new ArrayList<>();
    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = findViewById(R.id.recyclerView);

//        ModelFilm movie1 = new ModelFilm();
//        movie1.setJudulFilm("Armageddon");
//        movie1.setPosterFilm("https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fgeeksofdoom.com%2FGoD%2Fimg%2F2016%2F01%2Farmageddon-movie-banner.jpg");
//
//        for (int i = 0; i < 20; i++) {
//            dataFilm.add(movie1);
//        }
        
        getDataOnline();

//        recycler.setAdapter(new FilmAdapter(MainActivity.this, dataFilm));

        recycler.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));


    }

    private void getDataOnline() {
        ProgressDialog progress = new ProgressDialog(MainActivity.this);
        progress.setMessage("loading...");
        progress.show();

        Call<ResponseMovie> request = RetrofitConfig.getApiService().ambilDataMovie("f22298c4b222abbcb4710649ec94cdf4");
        request.enqueue(new Callback<ResponseMovie>() {
            @Override
            public void onResponse(Call<ResponseMovie> call, Response<ResponseMovie> response) {
                progress.dismiss();
                if (response.isSuccessful()) {
                    dataFilm = response.body().getResults();
                    recycler.setAdapter(new FilmAdapter(MainActivity.this, dataFilm));
                } else {
                    Toast.makeText(MainActivity.this,"Request not success", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseMovie> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Request failure" + t.getMessage(), Toast.LENGTH_SHORT).show();
                progress.dismiss();
            }
        });
    }
}