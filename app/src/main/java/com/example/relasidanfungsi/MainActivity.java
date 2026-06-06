package com.example.relasidanfungsi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnPlay, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = findViewById(R.id.btnPlay);
        btnExit = findViewById(R.id.btnExit);

        btnPlay.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    QuizActivity.class
            );
            startActivity(intent);
        });

        btnExit.setOnClickListener(v -> {

            new AlertDialog.Builder(this)
                    .setTitle("Keluar?")
                    .setMessage("Yakin ingin keluar dari game?")
                    .setPositiveButton("Ya",
                            (dialog, which) -> finishAffinity())
                    .setNegativeButton("Tidak", null)
                    .show();

        });
    }
}