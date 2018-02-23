package com.example.vasanth.hambutton;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.vasanth.hambutton.skillZone.ChemTreasureHunt;
import com.example.vasanth.hambutton.skillZone.CompoundPreparation;
import com.example.vasanth.hambutton.skillZone.FilmQuiz;
import com.example.vasanth.hambutton.skillZone.PharmaTreasureHunt;
import com.example.vasanth.hambutton.skillZone.BestOutOfWaste;
import com.example.vasanth.hambutton.skillZone.FilmyQuiz;
import com.example.vasanth.hambutton.skillZone.JigsawPuzzle;
import com.example.vasanth.hambutton.skillZone.LANGaming;
import com.example.vasanth.hambutton.skillZone.PlayZone;
import com.example.vasanth.hambutton.skillZone.PuzzleBreak;
import com.example.vasanth.hambutton.skillZone.RopeTieing;
import com.example.vasanth.hambutton.skillZone.RubixCube;
import com.example.vasanth.hambutton.skillZone.TechPowerHunt;
import com.example.vasanth.hambutton.skillZone.TechnicalThambola;
import com.example.vasanth.hambutton.skillZone.WordWrap;

public class SkillZone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill_zone);

        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.nothing);
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
    public void techPower(View v) {
        startActivity(new Intent(SkillZone.this, TechPowerHunt.class));
    }
    public void wordWrap(View v){
        startActivity(new Intent(SkillZone.this, WordWrap.class));
    }
    public void bestOut(View v){
        startActivity(new Intent(SkillZone.this, BestOutOfWaste.class));
    }
    public void filmyQuiz(View v){
        startActivity(new Intent(SkillZone.this, FilmyQuiz.class));
    }
    public void puzzleBreak(View v){
        startActivity(new Intent(SkillZone.this, PuzzleBreak.class));
    }
    public void rope(View v){
        startActivity(new Intent(SkillZone.this, RopeTieing.class));
    }
    public void chemTreasureHunt(View v){
        startActivity(new Intent(SkillZone.this, ChemTreasureHunt.class));
    }

    public void compound(View v){
        startActivity(new Intent(SkillZone.this, CompoundPreparation.class));
    }

    public void filmChem(View v){
        startActivity(new Intent(SkillZone.this, FilmQuiz.class));
    }

    public void rubix(View v){
        startActivity(new Intent(SkillZone.this, RubixCube.class));
    }

    public void treasureHunt(View v){
        startActivity(new Intent(SkillZone.this, PharmaTreasureHunt.class));
    }




}
