package com.example.relasidanfungsi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    static {
        System.loadLibrary("relasidanfungsi");
    }
    public native int updateHighScore(
            int score,
            int highScore
    );
    TextView tvFinalScore;
    TextView tvHighScore;

    Button btnPlayAgain;
    Button btnHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvFinalScore = findViewById(R.id.tvFinalScore);
        tvHighScore = findViewById(R.id.tvHighScore);

        btnPlayAgain = findViewById(R.id.btnPlayAgain);
        btnHome = findViewById(R.id.btnHome);

        int score = getIntent().getIntExtra("score", 0);

        tvFinalScore.setText("⭐ Score : " + score);

        SharedPreferences prefs =
                getSharedPreferences("GAME_DATA", MODE_PRIVATE);

        int highScore =
                prefs.getInt("HIGH_SCORE", 0);

        highScore = updateHighScore(
                score,
                highScore
        );

            prefs.edit()
                    .putInt("HIGH_SCORE", highScore)
                    .apply();

        tvHighScore.setText("🏆 High Score : " + highScore);

        btnPlayAgain.setOnClickListener(v -> {

            Intent intent =
                    new Intent(
                            ResultActivity.this,
                            QuizActivity.class
                    );

            startActivity(intent);
            finish();
        });

        btnHome.setOnClickListener(v -> {

            Intent intent =
                    new Intent(
                            ResultActivity.this,
                            MainActivity.class
                    );

            startActivity(intent);
            finish();
        });
    }

}