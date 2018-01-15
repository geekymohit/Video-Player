package com.example.mohit.videoplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    VideoView videoView;
    MediaController mediaController;
    ArrayList mySongs;
    int position;
    Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        videoView = (VideoView)findViewById(R.id.videoView);

        Intent intent =getIntent();
        Bundle bundle =intent.getExtras();
        mySongs = (ArrayList) bundle.getParcelableArrayList("songs");
        position = bundle.getInt("position",0);
        videoView.setVideoPath(mySongs.get(position).toString());
        //uri = Uri.parse(mySongs.get(position).toString());
        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();
        if(mediaController!=null)
        {
            videoView.stopPlayback();

        }
    }
}
