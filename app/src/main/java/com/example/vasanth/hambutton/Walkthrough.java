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
                .setContent("To be abreast of recent developments and to provide a common platform to the budding technocrats from all over the country, to have knowledge shared and to explore new horizons in the concerned Engineering, Pharmaceutical and Management streams, Anurag Group of institutions is going to conduct Aagama 2K18 on 16th and 17th March, 2018.")
                .setBackgroundColor(Color.parseColor("#1C2833")) // int background color
                .build());

        addFragment(new Step.Builder().setTitle("What is this app about?")
                .setDrawable(R.drawable.logo)
                .setContent("This mobile application guides you through the events conducted in the Aagama 2K18 fest. All the events are clearly listed and sorted according to the departments. The details of each event such as  description, rules, coordinators and registration fee are mentioned. A partipant can also register for an event through the application. We hope that you make a good use of the app to gain knowledge about the events of Aagama 2K18. Thank you.")
                .setBackgroundColor(Color.parseColor("#1C2833")) // int background color
                .build());


    }

    public void finishTutorial() {
        Intent i = new Intent(Walkthrough.this,HamButtonActivity.class);
        startActivity(i);
    }
}
