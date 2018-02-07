package com.example.vasanth.hambutton;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.view.View;

import com.example.vasanth.hambutton.skillZone.Circuitrix;
import com.example.vasanth.hambutton.skillZone.CodeCup;
import com.example.vasanth.hambutton.skillZone.JigsawPuzzle;
import com.example.vasanth.hambutton.skillZone.LANGaming;
import com.example.vasanth.hambutton.skillZone.ModelMaking;
import com.example.vasanth.hambutton.skillZone.PlayZone;
import com.example.vasanth.hambutton.skillZone.TechPowerHunt;
import com.example.vasanth.hambutton.skillZone.TechnicalThambola;
import com.example.vasanth.hambutton.skillZone.ThreeDChallenge;

public class SkillZone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill_zone);
    }

    public void cup(View v){
        startActivity(new Intent(SkillZone.this, CodeCup.class));
    }
    public void lan(View v){
        startActivity(new Intent(SkillZone.this, LANGaming.class));
    }
    public void tham(View v){
        startActivity(new Intent(SkillZone.this, TechnicalThambola.class));
    }
    public void puzzle(View v){
        startActivity(new Intent(SkillZone.this, JigsawPuzzle.class));
    }
    public void playz(View v){
        startActivity(new Intent(SkillZone.this, PlayZone.class));
    }
    public void circuitrix(View v){
        startActivity(new Intent(SkillZone.this, Circuitrix.class));
    }
    public void techPower(View v){
        startActivity(new Intent(SkillZone.this, TechPowerHunt.class));
    }
    public void three(View v){
        startActivity(new Intent(SkillZone.this, ThreeDChallenge.class));
    }
    public void model(View v){
        startActivity(new Intent(SkillZone.this, ModelMaking.class));
    }

}
