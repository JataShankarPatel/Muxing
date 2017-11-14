package com.example.user.muxing;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
String TAG="MainActityMuxer";
    Button go;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        go=(Button)findViewById(R.id.go);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String root = Environment.getExternalStorageDirectory().getPath();
                String audiopath = root + "/"+"FvdTube/audio";
                String videopath = root+ "/"+"FvdTube/video.mp4";
                Mp4ParserAudioMuxer muxer=new Mp4ParserAudioMuxer();
               boolean result= muxer.mux(videopath,audiopath,Environment.getExternalStorageDirectory().getPath()+"/out.mp4");
                if (result==true){
                    Toast.makeText(getApplicationContext(),"muxing is completed", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"something went wrong", Toast.LENGTH_SHORT).show();
                }

                //  muxit();
            }
        });
    }




}