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

        list.add(new Card("drawable://"+R.drawable.image_cse_paper,"Paper Presentation"));
        list.add(new Card("drawable://"+R.drawable.it_posterpresentation,"Poster Presentation"));
        list.add(new Card("drawable://"+R.drawable.idea_presentation,"Idea Presentation"));
        list.add(new Card("drawable://"+R.drawable.web_design,"Web Design"));
        list.add(new Card("drawable://"+R.drawable.project_expo,"Project Expo"));
        list.add(new Card("drawable://"+R.drawable.creative1,"Bugsmash"));

        CSECustomListAdapter adapter=new CSECustomListAdapter(this,R.layout.cse_card,list);
        mListView.setAdapter(adapter);

    }

}
