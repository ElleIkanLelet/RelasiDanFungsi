package com.example.relasidanfungsi;

import android.os.Bundle;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import java.util.ArrayList;
import android.content.res.ColorStateList;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Collections;
import android.os.CountDownTimer;
import android.content.Intent;


public class QuizActivity extends AppCompatActivity {
    private TextView tvQuestion, tvScore, tvTimer;
    private Button btnA, btnB, btnC, btnD, btnHint;

    private int currentQuestion = 0;
    private int score = 0;

    private CountDownTimer timer;
    private int timeLeft = 60;
    private ArrayList<Question> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        tvQuestion = findViewById(R.id.tvQuestion);
        tvScore = findViewById(R.id.tvScore);
        tvTimer = findViewById(R.id.tvTimer);

        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnC = findViewById(R.id.btnC);
        btnD = findViewById(R.id.btnD);
        btnHint = findViewById(R.id.btnHint);

        questionList = new ArrayList<>();

        questionList.add(new Question(
                "Misalkan A = {1, 2, 3}. Manakah relasi yang refleksif?",
                "R={(1,1),(2,2),(2,3),(3,2)}",
                "R={(1,1),(2,2),(3,3),(1,2)}",
                "R={(1,1),(1,2),(1,3),(2,3)}",
                "R={(2,2),(3,3)}",
                "B",
                "Pastikan semua elemen memiliki pasangan dengan dirinya sendiri."
        ));

        questionList.add(new Question(
                "Diberikan relasi R={(a,b)|a<=b} pada bilangan bulat. Sifat apa yang dimiliki?",
                "Refleksif dan Simetris",
                "Refleksif dan Transitif",
                "Simetris dan Transitif",
                "Asimetris dan Transitif",
                "B",
                "Periksa apakah a<=a selalu benar dan apakah sifat transitif berlaku."
        ));

        questionList.add(new Question(
                "Relasi saudara kandung bersifat...",
                "Simetris dan Transitif",
                "Refleksif dan Simetris",
                "Hanya Simetris",
                "Refleksif, Simetris, dan Transitif",
                "A",
                "Jika x saudara y maka y saudara x."
        ));

        questionList.add(new Question(
                "Banyak relasi dari A={a,b} ke B={1,2,3} adalah...",
                "6",
                "8",
                "32",
                "64",
                "D",
                "Hitung 2^(|A×B|)."
        ));

        questionList.add(new Question(
                "Relasi kesetaraan harus memenuhi...",
                "Refleksif, Simetris, Transitif",
                "Refleksif, Antisimetris, Transitif",
                "Irrefleksif, Simetris, Transitif",
                "Refleksif, Asimetris, Transitif",
                "A",
                "Ingat definisi equivalence relation."
        ));

        questionList.add(new Question(
                "R={(1,2),(2,3)}. Agar transitif perlu ditambah...",
                "{(1,3)}",
                "{(3,1)}",
                "{(2,1),(3,2)}",
                "{(1,1),(2,2),(3,3)}",
                "A",
                "Jika (1,2) dan (2,3) maka harus ada hubungan langsung."
        ));

        questionList.add(new Question(
                "Relasi 'kelipatan dari' antisimetris karena...",
                "Jika aRb dan bRa maka a=b",
                "Jika aRb maka bRa",
                "a selalu kelipatan a",
                "Jika aRb dan bRc maka aRc",
                "A",
                "Pikirkan definisi antisimetris."
        ));

        questionList.add(new Question(
                "Matriks relasi dengan diagonal utama semua 1 dan simetris menunjukkan sifat...",
                "Refleksif dan Simetris",
                "Refleksif saja",
                "Simetris saja",
                "Antirefleksif dan Simetris",
                "A",
                "Perhatikan diagonal utama dan bentuk matriks."
        ));

        questionList.add(new Question(
                "R1={(1,1),(2,2),(3,3)} dan R2={(1,1),(1,2),(2,3)}. R1∩R2 = ...",
                "{(1,1),(2,2),(3,3),(1,2),(2,3)}",
                "{(1,1)}",
                "{(1,2),(2,3)}",
                "∅",
                "B",
                "Cari pasangan yang ada di kedua relasi."
        ));

        questionList.add(new Question(
                "Jika R={(1,a),(2,b)} dan S={(a,x),(b,y)}, maka S∘R = ...",
                "{(1,x),(2,y)}",
                "{(a,1),(b,2)}",
                "{(x,1),(y,2)}",
                "{(1,a),(2,b),(a,x),(b,y)}",
                "A",
                "Ikuti alur pemetaan melalui R lalu S."
        ));

        questionList.add(new Question(
                "Manakah yang merupakan fungsi dari A={1,2,3} ke B={a,b}?",
                "{(1,a),(2,b)}",
                "{(1,a),(2,a),(3,b)}",
                "{(1,a),(1,b),(2,a),(3,b)}",
                "{(1,a),(2,b),(3,a),(3,b)}",
                "B",
                "Setiap anggota domain harus tepat satu pasangan."
        ));

        questionList.add(new Question(
                "Fungsi injektif adalah fungsi yang...",
                "Setiap elemen B memiliki pasangan",
                "Tidak ada dua elemen domain berbeda dengan bayangan sama",
                "Semua domain ke elemen yang sama",
                "Jumlah anggota domain dan kodomain sama",
                "B",
                "Definisi satu-satu."
        ));

        questionList.add(new Question(
                "f(x)=x² bukan injektif karena...",
                "Nilainya selalu positif",
                "Ada x berbeda menghasilkan nilai sama",
                "Ada kodomain tanpa pra-gambar",
                "Grafiknya parabola",
                "B",
                "Bandingkan f(-2) dan f(2)."
        ));

        questionList.add(new Question(
                "Fungsi surjektif jika...",
                "Kodomain = Range",
                "Domain = Kodomain",
                "Memiliki invers",
                "Setiap domain ke elemen unik",
                "A",
                "Semua elemen kodomain harus terpetakan."
        ));

        questionList.add(new Question(
                "Fungsi yang injektif dan surjektif disebut...",
                "Konstan",
                "Identitas",
                "Bijektif",
                "Polinomial",
                "C",
                "Gabungan dua sifat tersebut."
        ));

        questionList.add(new Question(
                "Invers dari f(x)=3x-5 adalah...",
                "(x-5)/3",
                "(x+5)/3",
                "5x-3",
                "3/(x-5)",
                "B",
                "Ubah y=3x-5 lalu selesaikan untuk x."
        ));

        questionList.add(new Question(
                "Jika f(x)=2x+1 dan g(x)=x²-3 maka (g∘f)(x) = ...",
                "4x²+4x-2",
                "2x²-5",
                "4x²+1",
                "2x²+4x-2",
                "A",
                "Substitusikan f ke dalam g."
        ));

        questionList.add(new Question(
                "Jika f dan g keduanya bijektif maka (g∘f) bersifat...",
                "Hanya Injektif",
                "Hanya Surjektif",
                "Bijektif",
                "Tidak dapat ditentukan",
                "C",
                "Komposisi dua fungsi bijektif."
        ));

        questionList.add(new Question(
                "Nilai floor(-3.4) adalah...",
                "-3",
                "-4",
                "3",
                "-3.5",
                "B",
                "Bilangan bulat terbesar yang <= -3.4."
        ));

        questionList.add(new Question(
                "Manakah fungsi yang pasti memiliki invers pada R?",
                "f(x)=x²+2",
                "f(x)=sin(x)",
                "f(x)=4x-7",
                "f(x)=|x|",
                "C",
                "Fungsi linear dengan gradien tidak nol."
        ));
        Collections.shuffle(questionList);
        showQuestion();
        startTimer();
    }

    private void showQuestion() {

        resetButtonColors();

        Question q = questionList.get(currentQuestion);

        tvQuestion.setText(q.question);

        btnA.setText("A. " + q.optionA);
        btnB.setText("B. " + q.optionB);
        btnC.setText("C. " + q.optionC);
        btnD.setText("D. " + q.optionD);

        btnA.setOnClickListener(v -> {
            animateButton(btnA);
            checkAnswer("A", btnA);
        });

        btnB.setOnClickListener(v -> {
            animateButton(btnB);
            checkAnswer("B", btnB);
        });

        btnC.setOnClickListener(v -> {
            animateButton(btnC);
            checkAnswer("C", btnC);
        });

        btnD.setOnClickListener(v -> {
            animateButton(btnD);
            checkAnswer("D", btnD);
        });

        btnHint.setOnClickListener(v -> {

            new AlertDialog.Builder(QuizActivity.this)
                    .setTitle("Hint")
                    .setMessage(q.hint)
                    .setPositiveButton("OK", null)
                    .show();

        });
    }

    private void resetButtonColors() {

        btnA.setBackgroundResource(R.drawable.rounded_button);
        btnB.setBackgroundResource(R.drawable.rounded_button);
        btnC.setBackgroundResource(R.drawable.rounded_button);
        btnD.setBackgroundResource(R.drawable.rounded_button);
    }

    private void checkAnswer(String selected, Button button) {

        Question q = questionList.get(currentQuestion);

        if (selected.equals(q.answer)) {

            score++;

            button.setText("BENAR");

            button.setBackgroundResource(
                    R.drawable.correct_button
            );

        } else {

            score--;

            button.setText("SALAH");

            button.setBackgroundResource(
                    R.drawable.wrong_button
            );
        }

        tvScore.setText("⭐ Score : " + score);

        button.postDelayed(() -> {

            resetButtonColors();

            currentQuestion++;

            if (currentQuestion >= questionList.size()) {
                Collections.shuffle(questionList);
                currentQuestion = 0;
            }

            showQuestion();

        }, 600);
    }

    private void animateButton(Button button) {

        button.animate()
                .translationY(-20f)
                .scaleX(1.1f)
                .scaleY(1.1f)
                .setDuration(150)
                .withEndAction(() ->
                        button.animate()
                                .translationY(0)
                                .scaleX(1f)
                                .scaleY(1f)
                                .setDuration(150)
                );
    }

    private void shakeButton(Button button) {

        button.animate()
                .translationX(20)
                .setDuration(50)
                .withEndAction(() ->
                        button.animate()
                                .translationX(-20)
                                .setDuration(50)
                                .withEndAction(() ->
                                        button.animate()
                                                .translationX(20)
                                                .setDuration(50)
                                                .withEndAction(() ->
                                                        button.animate()
                                                                .translationX(0)
                                                                .setDuration(50)
                                                )
                                )
                );
    }

    private void startTimer() {

        timer = new CountDownTimer(60000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {

                timeLeft--;

                tvTimer.setText("⏰ " + timeLeft);
            }

            @Override
            public void onFinish() {

                tvTimer.setText("⏰ 0");

                Intent intent = new Intent(
                        QuizActivity.this,
                        ResultActivity.class
                );

                intent.putExtra("score", score);

                startActivity(intent);

                finish();
            }
        };

        timer.start();
    }

}