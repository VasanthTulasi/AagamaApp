package com.example.vasanth.hambutton;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.vasanth.hambutton.branch.CHEMActivity;
import com.example.vasanth.hambutton.branch.CseActivity;
import com.example.vasanth.hambutton.branch.EVEActivity;
import com.example.vasanth.hambutton.branch.EEEActivity;
import com.example.vasanth.hambutton.branch.ITActivity;
import com.example.vasanth.hambutton.branch.MECHActivity;


public class MainActivityDept extends AppCompatActivity{


    private CardView bankCard,ideasCard,addCard,linksCard,wifiCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dept);


    }

    public void cse(View view){
        Intent i=new Intent(MainActivityDept.this,CseActivity.class);
        startActivity(i);
    }
    public void ece(View view){
        Intent i=new Intent(MainActivityDept.this,EVEActivity.class);
        startActivity(i);
    }
    public void eee(View view){
        Intent i=new Intent(MainActivityDept.this,EEEActivity.class);
        startActivity(i);
    }
    public void chemical(View view){
        Intent i=new Intent(MainActivityDept.this,CHEMActivity.class);
        startActivity(i);
    }
    public void mech(View view){
        Intent i=new Intent(MainActivityDept.this,MECHActivity.class);
        startActivity(i);
    }
    public void it(View view){
        Intent i=new Intent(MainActivityDept.this,ITActivity.class);
        startActivity(i);
    }





}
