package com.example.vasanth.hambutton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.hololo.tutorial.library.Step;
import com.hololo.tutorial.library.TutorialActivity;

public class Walkthrough extends TutorialActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        addFragment(new Step.Builder().setTitle("This is first header")
                .setContent("This is the content")
                .setBackgroundColor(Color.parseColor("#1C2833")) // int background color
                .build());

        addFragment(new Step.Builder().setTitle("This is second header")
                .setContent("This is the content")
                .setBackgroundColor(Color.parseColor("#1C2833")) // int background color
                .build());

        addFragment(new Step.Builder().setTitle("This is third header")
                .setContent("This is the content")
                .setBackgroundColor(Color.parseColor("#1C2833")) // int background color
                .build());

    }

    public void finishTutorial() {
        Intent i = new Intent(Walkthrough.this,HamButtonActivity.class);
        startActivity(i);
    }
}
