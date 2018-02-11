package com.example.vasanth.hambutton.branch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.TextView;

import com.example.vasanth.hambutton.R;

import java.util.ArrayList;

public class ITActivity extends AppCompatActivity {

private ListView mListViewInIT;

private static final String TAG="ItActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.listview_layout_it);

        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.nothing);

        mListViewInIT=(ListView)findViewById(R.id.listViewInIT);


        TextView v=(TextView) mListViewInIT.findViewById(R.id.cardTitleInIT);

        ArrayList<Card> listIT=new ArrayList<>();

        listIT.add(new Card("drawable://"+R.drawable.creative1,"Code Maze"));
        listIT.add(new Card("drawable://"+R.drawable.creative1,"Paper Presentation"));
        listIT.add(new Card("drawable://"+R.drawable.creative1,"Poster Presentation"));
        listIT.add(new Card("drawable://"+R.drawable.creative1,"Mobile App Mock Up"));
        listIT.add(new Card("drawable://"+R.drawable.creative1,"CPU collab"));
        listIT.add(new Card("drawable://"+R.drawable.creative1,"Cascading Code "));
        listIT.add(new Card("drawable://"+R.drawable.creative1,"Code Sink"));




        ITCustomListAdapter adapterIT=new ITCustomListAdapter(this,R.layout.it_card,listIT);
        mListViewInIT.setAdapter(adapterIT);

    }

}
