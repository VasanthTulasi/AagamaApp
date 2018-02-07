package com.example.vasanth.hambutton.branch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.example.vasanth.hambutton.R;

import java.util.ArrayList;

public class CHEMActivity extends AppCompatActivity {

private ListView mListViewInCHEM;

private static final String TAG="ChemActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.listview_layout_chem);

        mListViewInCHEM=(ListView)findViewById(R.id.listViewInCHEM);


        TextView v=(TextView) mListViewInCHEM.findViewById(R.id.cardTitleInCHEM);

        ArrayList<Card> listCHEM=new ArrayList<>();

        listCHEM.add(new Card("drawable://"+R.drawable.creative1,"Project Presentation"));
        listCHEM.add(new Card("drawable://"+R.drawable.creative1,"Innovative Idea Presentation"));
        listCHEM.add(new Card("drawable://"+R.drawable.creative1,"Poster Presentation"));


        CHEMCustomListAdapter adapterCHEM=new CHEMCustomListAdapter(this,R.layout.chem_card,listCHEM);
        mListViewInCHEM.setAdapter(adapterCHEM);

    }

}
