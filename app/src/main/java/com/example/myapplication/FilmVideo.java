package com.example.myapplication;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class FilmVideo extends AppCompatActivity {
    VideoView video;
    Uri uri;
    MediaController mediaController;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.film_video_layout);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        String name = getIntent().getStringExtra("name");
        String director = getIntent().getStringExtra("director");

        video = (VideoView) findViewById(R.id.filmVideo);
//        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.ngan;
//        uri = Uri.parse(videoPath);
//        video.setVideoURI(uri);
        video.setVideoPath("https://sample-videos.com/video123/mp4/720/big_buck_bunny_720p_20mb.mp4");
        mediaController = new MediaController(this);
        video.setMediaController(mediaController);
        mediaController.setAnchorView(video);
        video.start();

    }
}
