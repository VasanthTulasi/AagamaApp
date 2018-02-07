package com.example.vasanth.hambutton.branch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        mListViewInIT=(ListView)findViewById(R.id.listViewInIT);


        TextView v=(TextView) mListViewInIT.findViewById(R.id.cardTitleInIT);

        ArrayList<Card> listIT=new ArrayList<>();

        listIT.add(new Card("drawable://"+R.drawable.creative1,"IT"));


        ITCustomListAdapter adapterIT=new ITCustomListAdapter(this,R.layout.it_card,listIT);
        mListViewInIT.setAdapter(adapterIT);

    }

}
