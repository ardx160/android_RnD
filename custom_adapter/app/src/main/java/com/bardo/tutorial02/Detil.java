package com.bardo.tutorial02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class Detil extends AppCompatActivity {

    private static final String TAG = "Detil Activity";

    TextView tvnamabuah;
    ImageView ivgambarbuah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detil);

        String namabuah = getIntent().getStringExtra(Konstanta.DATANAMA);
        int gambarbuah = getIntent().getIntExtra(Konstanta.DATAGAMBAR, 0);

        Log.i(TAG, "Nama: "+ namabuah);
        Log.i(TAG, "Gambar: " + gambarbuah);

        tvnamabuah = findViewById(R.id.nama_detil);
        ivgambarbuah = findViewById(R.id.gambar_detil);

        tvnamabuah.setText(namabuah);
        ivgambarbuah.setImageResource(gambarbuah);
    }
}