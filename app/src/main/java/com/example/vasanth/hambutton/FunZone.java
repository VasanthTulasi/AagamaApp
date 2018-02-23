package com.example.vasanth.hambutton;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.vasanth.hambutton.funZone.BreakItIfYouCan;
import com.example.vasanth.hambutton.eceBranchIndividualActivities.CodeBreakers;
import com.example.vasanth.hambutton.funZone.DevilFollows;
import com.example.vasanth.hambutton.eceBranchIndividualActivities.DumbShellElectronics;
import com.example.vasanth.hambutton.funZone.DhamLaga;
import com.example.vasanth.hambutton.funZone.FunCarnival;
import com.example.vasanth.hambutton.funZone.GiftUnwrapping;
import com.example.vasanth.hambutton.funZone.GolGappa;
import com.example.vasanth.hambutton.funZone.Inversion;
import com.example.vasanth.hambutton.funZone.LuckyDraw;
import com.example.vasanth.hambutton.funZone.SaveME;
import com.example.vasanth.hambutton.funZone.SlowCycling;
import com.example.vasanth.hambutton.funZone.SpellBee;

public class FunZone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_zone);

        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.nothing);
    }

    public void devil(View v){
        startActivity(new Intent(FunZone.this, DevilFollows.class));
    }
    public void ifYouCan(View v){
        startActivity(new Intent(FunZone.this, BreakItIfYouCan.class));
    }
    public void inversion(View v){
        startActivity(new Intent(FunZone.this, Inversion.class));
    }
    public void carnival(View v){
        startActivity(new Intent(FunZone.this, FunCarnival.class));
    }
    public void dham(View v){
        startActivity(new Intent(FunZone.this, DhamLaga.class));
    }
    public void giftUnwrapping(View v){
        startActivity(new Intent(FunZone.this, GiftUnwrapping.class));
    }
    public void golGappa(View v){
        startActivity(new Intent(FunZone.this, GolGappa.class));
    }
    public void luckyDraw(View v){
        startActivity(new Intent(FunZone.this, LuckyDraw.class));
    }
    public void saveMe(View v){
        startActivity(new Intent(FunZone.this, SaveME.class));
    }
    public void slowCycling(View v){
        startActivity(new Intent(FunZone.this, SlowCycling.class));
    }
    public void spellBee(View v){
        startActivity(new Intent(FunZone.this, SpellBee.class));
    }




}
