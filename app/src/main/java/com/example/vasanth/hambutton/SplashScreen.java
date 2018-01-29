package com.example.vasanth.hambutton;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends Activity {

    ImageView aagamaLogo;
    TextView aagamaText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.splash_screen);


        aagamaLogo = findViewById(R.id.iv);
        aagamaText = findViewById(R.id.changingTextView);
        Animation blinkLogo = AnimationUtils.loadAnimation(this, R.anim.blink_for_logo_in_splash);
        Animation blinkText = AnimationUtils.loadAnimation(this, R.anim.blink_for_text_in_splash);
        aagamaLogo.startAnimation(blinkLogo);
        blinkText.setStartOffset(2000);
        aagamaText.startAnimation(blinkText);

        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                aagamaText.setText(R.string.changed_text);
            }
        }, 4000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                aagamaText.setText(R.string.final_text);
            }
        }, 6000);

        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(7500);
                }catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    startActivity(new Intent(SplashScreen.this, Walkthrough.class));
                    finish();
                }
            }
        };
        timer.start();
    }


    }
