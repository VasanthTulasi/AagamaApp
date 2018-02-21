package com.example.vasanth.hambutton.branch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.TextView;


import com.example.vasanth.hambutton.R;

import java.util.ArrayList;

public class CseActivity extends AppCompatActivity {

private ListView mListView;

private static final String TAG="CseActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.listview_layout_cse);

        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.nothing);


        mListView=(ListView)findViewById(R.id.listView);


        TextView v=(TextView) mListView.findViewById(R.id.cardTitleInCSE);

        ArrayList<Card> list=new ArrayList<>();

        list.add(new Card("drawable://"+R.drawable.cse_paper_presentation,"Paper Presentation"));
        list.add(new Card("drawable://"+R.drawable.cse_poster_presentation,"Poster Presentation"));
        list.add(new Card("drawable://"+R.drawable.cse_web_design,"Web Club Hackathon"));
        list.add(new Card("drawable://"+R.drawable.idea_presentation_cse,"Idea Presentation"));
        list.add(new Card("drawable://"+R.drawable.cse_project_expo,"Project Expo"));
        list.add(new Card("drawable://"+R.drawable.null_club_hackathon_cse,"Null Club Hackathon"));
        list.add(new Card("drawable://"+R.drawable.code_cup,"Code Cup "));

        CSECustomListAdapter adapter=new CSECustomListAdapter(this,R.layout.cse_card,list);
        mListView.setAdapter(adapter);

    }

}
