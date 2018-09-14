package com.example.tdsaint.inspire_lang;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.felipecsl.gifimageview.library.GifImageView;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class SplashScreen extends AppCompatActivity {
    private GifImageView gifImageView; //Variable for gifImageView
    private ProgressBar progressBar; //Variable for gifImageView
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        gifImageView = (GifImageView) findViewById(R.id.gifImageView); //Search gifImageView
        progressBar = (ProgressBar) findViewById(R.id.progressBar); //Search progressBar

        try
        {
            InputStream inputStream = getAssets().open("SplashScreen_gif.gif"); //Open assets and search gif image
            byte[] bytes = IOUtils.toByteArray(inputStream); // Create array for inputStream
            gifImageView.setBytes(bytes); //Initialized array
            gifImageView.startAnimation(); // Start animation
        }
        catch (IOException ex)
        {
            //Exception message
        }

        new Handler().postDelayed(new Runnable() { //New methon for run SplashScreen
            @Override
            public void run() {
                SplashScreen.this.startActivity(new Intent(SplashScreen.this, MainActivity.class)); //Start activity SplashScreen
                SplashScreen.this.finish(); //Stop activity SplashScreen and run MainActivity
            }
        }, 3000);

    }
}
