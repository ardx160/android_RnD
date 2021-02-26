package com.bardo.tutorial;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class menumenu extends AppCompatActivity {

    Button utama, kiat, kaat, kiba, kaba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menumenu);

        utama = findViewById(R.id.button16);
        kiat = findViewById(R.id.button12);
        kaat = findViewById(R.id.button13);
        kiba = findViewById(R.id.button14);
        kaba = findViewById(R.id.button15);

        utama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(menumenu.this, "Haloo", Toast.LENGTH_SHORT).show();
                Intent pindah = new Intent(menumenu.this, framenya.class);
                startActivity(pindah);
            }
        });

        kiat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder pesan = new AlertDialog.Builder(menumenu.this);
                pesan.setTitle("Alert");
                pesan.setMessage("Ini Alert Dialog");
                pesan.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(menumenu.this, "ini OK", Toast.LENGTH_SHORT).show();
                        Intent pindah = new Intent(menumenu.this, MainActivity.class);
                        startActivity(pindah);
                    }
                });
                pesan.setNegativeButton("No", null);
                pesan.setNeutralButton("Cancel", null);
                pesan.show();
            }
        });

        kaat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        kiba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        kaba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}