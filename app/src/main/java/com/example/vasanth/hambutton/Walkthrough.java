package com.example.vasanth.hambutton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.hololo.tutorial.library.Step;
import com.hololo.tutorial.library.TutorialActivity;

import me.biubiubiu.justifytext.library.JustifyTextView;

public class Walkthrough extends TutorialActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        addFragment(new Step.Builder().setTitle("This is first header")
                .setContent("")
                .setBackgroundColor(Color.parseColor("#1C2833")) // int background color
                .build());


    }

    public void finishTutorial() {
        Intent i = new Intent(Walkthrough.this,HamButtonActivity.class);
        startActivity(i);
    }
}
