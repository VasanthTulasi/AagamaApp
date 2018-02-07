package com.example.vasanth.hambutton;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivityForZones extends AppCompatActivity {
       public Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_zones);

        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.nothing);
        // getSupportActionBar().setIcon(R.drawable.launch1);
        // toolbar.setLogo(R.drawable.home_icon);

    }
    public void techzone(View view){
        Intent i = new Intent(MainActivityForZones.this,MainActivityDept.class);
        startActivity(i);
    }
    public void openzone(View view){
        Intent i = new Intent(MainActivityForZones.this,OpenZone.class);
        startActivity(i);
    }
    public void skillzone(View view){
        Intent i = new Intent(MainActivityForZones.this,SkillZone.class);
        startActivity(i);
    }
    public void funzone(View view){
        Intent i = new Intent(MainActivityForZones.this,FunZone.class);
        startActivity(i);
    }


}
