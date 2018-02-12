package com.example.vasanth.hambutton.branch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.TextView;

import com.example.vasanth.hambutton.R;

import java.util.ArrayList;

public class EEEActivity extends AppCompatActivity {

private ListView mListViewInEEE;

private static final String TAG="EeeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.listview_layout_eee);

        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.nothing);

        mListViewInEEE=(ListView)findViewById(R.id.listViewInEEE);


        TextView v=(TextView) mListViewInEEE.findViewById(R.id.cardTitleInEEE);

        ArrayList<Card> listEEE=new ArrayList<>();

        listEEE.add(new Card("drawable://"+R.drawable.paper_presentation_eee,"Paper Presentation"));
        listEEE.add(new Card("drawable://"+R.drawable.cse_poster_presentation,"Poster Presentation"));
        listEEE.add(new Card("drawable://"+R.drawable.project_expo_eee,"Project Expo"));
        listEEE.add(new Card("drawable://"+R.drawable.ece_techquiz2,"Techinical Quiz"));


        EEECustomListAdapter adapterEEE=new EEECustomListAdapter(this,R.layout.eee_card,listEEE);
        mListViewInEEE.setAdapter(adapterEEE);

    }

}
