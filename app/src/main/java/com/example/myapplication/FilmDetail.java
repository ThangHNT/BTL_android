package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FilmDetail extends AppCompatActivity {
    Button watchMovieBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.film_detail_layout);
        String nameOfFilm = getIntent().getStringExtra("name");
        watchMovieBtn = findViewById(R.id.watchMovieBtn);
        watchMovieBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToFilmVideo(nameOfFilm);
            }
        });
    }

    private void moveToFilmVideo(String name){
        System.out.println(name);
        Intent intent = new Intent(FilmDetail.this, FilmVideo.class);
        startActivity(intent);
    }

}
