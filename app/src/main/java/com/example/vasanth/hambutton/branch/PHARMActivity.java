package com.example.vasanth.hambutton.branch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.TextView;

import com.example.vasanth.hambutton.R;

import java.util.ArrayList;

public class PHARMActivity extends AppCompatActivity {

private ListView mListViewInPHARM;

private static final String TAG="PharmActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.listview_layout_pharm);

        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.nothing);

        mListViewInPHARM=(ListView)findViewById(R.id.listViewInPHARM);


        TextView v=(TextView) mListViewInPHARM.findViewById(R.id.cardTitleInPHARM);

        ArrayList<Card> listPHARM=new ArrayList<>();

        listPHARM.add(new Card("drawable://"+R.drawable.oral_preserntaiton,"Oral Presentation"));
        listPHARM.add(new Card("drawable://"+R.drawable.poster_presentation_pharma,"Poster Presentation"));
        listPHARM.add(new Card("drawable://"+R.drawable.pharma_quiz_pharma,"Pharma Quiz"));


        PHARMCustomListAdapter adapterPHARM=new PHARMCustomListAdapter(this,R.layout.pharm_card,listPHARM);
        mListViewInPHARM.setAdapter(adapterPHARM);

    }

}
