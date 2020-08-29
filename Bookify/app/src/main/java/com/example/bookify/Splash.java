package com.example.bookify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * splash screen java class
 */
public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            /**
             * run method
             */
            @Override
            public void run() {
                Intent intent=new Intent(getApplicationContext(),Authenticate.class);
                startActivity(intent);
                finish();
            }
        },3000);

    }


}