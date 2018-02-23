package com.example.vasanth.hambutton.branch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.TextView;

import com.example.vasanth.hambutton.R;

import java.util.ArrayList;

public class CHEMICALActivity extends AppCompatActivity {

private ListView mListViewInCHEMICAL;

private static final String TAG="ChemicalActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.listview_layout_chemical);

        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.nothing);

        mListViewInCHEMICAL=(ListView)findViewById(R.id.listViewInCHEMICAL);


        TextView v=(TextView) mListViewInCHEMICAL.findViewById(R.id.cardTitleInCHEMICAL);

        ArrayList<Card> listCHEMICAL=new ArrayList<>();

        listCHEMICAL.add(new Card("drawable://"+R.drawable.paper_presentation_chem,"Paper Presentation"));
        listCHEMICAL.add(new Card("drawable://"+R.drawable.poster_presentation_chem,"Poster Presentation"));
        listCHEMICAL.add(new Card("drawable://"+R.drawable.technical_quiz_chem,"Technical Quiz"));



        CHEMICALCustomListAdapter adapterCHEMICAL=new CHEMICALCustomListAdapter(this,R.layout.chemical_card,listCHEMICAL);
        mListViewInCHEMICAL.setAdapter(adapterCHEMICAL);

    }

}
