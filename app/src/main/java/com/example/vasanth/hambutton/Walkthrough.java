package com.example.vasanth.hambutton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.webkit.WebView;

import com.hololo.tutorial.library.Step;
import com.hololo.tutorial.library.TutorialActivity;

import me.biubiubiu.justifytext.library.JustifyTextView;

public class Walkthrough extends TutorialActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        addFragment(new Step.Builder().setTitle("About Aagama")
                .setDrawable(R.drawable.logo)
                .setContent("To be abreast of recent developments and to provide a common platform to the budding technocrats from all over  the country, to  have knowledge share and to explore  new horizons in the  concerned  Engineering, Pharmaceutical  and Management  streams,  Anurag Group of institutions is conducting Aagama 2K18 on 16th and 17th March, 2018.")
                .setBackgroundColor(Color.parseColor("#1C2833")) // int background color
                .build());


    }

    public void finishTutorial() {
        Intent i = new Intent(Walkthrough.this,HamButtonActivity.class);
        startActivity(i);
    }
}
