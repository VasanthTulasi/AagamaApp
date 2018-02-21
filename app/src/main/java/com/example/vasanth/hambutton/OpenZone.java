package com.example.vasanth.hambutton;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.vasanth.hambutton.openZone.BrickChallenge;
import com.example.vasanth.hambutton.openZone.ClayMoulding;
import com.example.vasanth.hambutton.openZone.CreativeSelfie;
import com.example.vasanth.hambutton.openZone.Dandiya;
import com.example.vasanth.hambutton.itIndividualActivities.DeadlyHunt;
import com.example.vasanth.hambutton.openZone.Fabulous;
import com.example.vasanth.hambutton.openZone.KingOfDice;
import com.example.vasanth.hambutton.eceBranchIndividualActivities.MatlabMania;
import com.example.vasanth.hambutton.openZone.MirrorWalk;
import com.example.vasanth.hambutton.openZone.MockCID;
import com.example.vasanth.hambutton.openZone.Painting;
import com.example.vasanth.hambutton.openZone.Rangoli;
import com.example.vasanth.hambutton.openZone.VirtualJobFair;
import com.example.vasanth.hambutton.openZone.WordsWorth;

public class OpenZone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_zone);

        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.nothing);


    }

    public void clay(View v){
        startActivity(new Intent(OpenZone.this, ClayMoulding.class));
    }
    public void paint(View v){
        startActivity(new Intent(OpenZone.this, Painting.class));
    }
    public void rangoli(View v){
        startActivity(new Intent(OpenZone.this, Rangoli.class));
    }
    public void dandiya(View v){
        startActivity(new Intent(OpenZone.this, Dandiya.class));
    }
    public void matlab(View v){
        startActivity(new Intent(OpenZone.this, MatlabMania.class));
    }
    public void fabulous(View v){
        startActivity(new Intent(OpenZone.this, Fabulous.class));
    }
    public void brick(View v){
        startActivity(new Intent(OpenZone.this, BrickChallenge.class));
    }public void selfie(View v){
        startActivity(new Intent(OpenZone.this, CreativeSelfie.class));
    }
    public void king(View v){
        startActivity(new Intent(OpenZone.this, KingOfDice.class));
    }
    public void cid(View v){startActivity(new Intent(OpenZone.this, MockCID.class));}
    public void mirror(View v){
        startActivity(new Intent(OpenZone.this, MirrorWalk.class));
    }
    public void wordsWorth(View v){startActivity(new Intent(OpenZone.this, WordsWorth.class));}
    public void virtual(View v){startActivity(new Intent(OpenZone.this, VirtualJobFair.class));}
    public void deadly(View v){
        startActivity(new Intent(OpenZone.this, DeadlyHunt.class));
    }




}
