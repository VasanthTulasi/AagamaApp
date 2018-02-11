package com.example.vasanth.hambutton.branch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.TextView;

import com.example.vasanth.hambutton.R;

import java.util.ArrayList;

public class EVEActivity extends AppCompatActivity {

private ListView mListViewInECE;

private static final String TAG="EceActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.listview_layout_ece);

        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.nothing);

        mListViewInECE=(ListView)findViewById(R.id.listViewInECE);


        TextView v=(TextView) mListViewInECE.findViewById(R.id.cardTitleInECE);

        ArrayList<Card> listECE=new ArrayList<>();

        listECE.add(new Card("drawable://"+R.drawable.ece_techquiz2,"Technical Quiz"));
        listECE.add(new Card("drawable://"+R.drawable.circuitrix_ece,"Circuitrix"));
        listECE.add(new Card("drawable://"+R.drawable.ramandrom_ece,"RAM and ROM"));


        ECECustomListAdapter adapterECE=new ECECustomListAdapter(this,R.layout.ece_card,listECE);
        mListViewInECE.setAdapter(adapterECE);

    }

}
