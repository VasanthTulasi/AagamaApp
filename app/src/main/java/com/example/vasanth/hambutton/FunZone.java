package com.example.vasanth.hambutton;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.vasanth.hambutton.funZone.BreakItIfYouCan;
import com.example.vasanth.hambutton.funZone.CodeBreakers;
import com.example.vasanth.hambutton.funZone.DevilFollows;
import com.example.vasanth.hambutton.funZone.DumbShellElectronics;
import com.example.vasanth.hambutton.funZone.Inversion;
import com.example.vasanth.hambutton.openZone.Fabulous;

public class FunZone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_zone);
    }

    public void dumb(View v){
        startActivity(new Intent(FunZone.this, DumbShellElectronics.class));
    }
    public void breaker(View v){
        startActivity(new Intent(FunZone.this, CodeBreakers.class));
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

}
