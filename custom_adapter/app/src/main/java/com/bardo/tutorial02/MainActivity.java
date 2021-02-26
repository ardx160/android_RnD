package com.bardo.tutorial02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView list;
    String[] namabuah = {
            "alpukat",
            "apel",
            "ceri",
            "durian",
            "jambu air",
            "manggis",
            "stroberi"
    };

    int[] gambarbuah = {
            R.drawable.alpukat,
            R.drawable.apel,
            R.drawable.ceri,
            R.drawable.durian,
            R.drawable.jambuair,
            R.drawable.manggis,
            R.drawable.strawberry
    };

    int[] suarabuah = {
            R.raw.alpukat,
            R.raw.apel,
            R.raw.ceri,
            R.raw.durian,
            R.raw.jambuair,
            R.raw.manggis,
            R.raw.strawberry
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.ListView);

//        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, namabuah);
        customListAdapter adapter = new customListAdapter(MainActivity.this, namabuah, gambarbuah);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                MediaPlayer.create(MainActivity.this, suarabuah[position]).start();

                Intent pindah = new Intent(MainActivity.this, Detil.class);
                pindah.putExtra(Konstanta.DATANAMA, namabuah[position]);
                pindah.putExtra(Konstanta.DATAGAMBAR, gambarbuah[position]);
                startActivity(pindah);
            }
        });
    }
}