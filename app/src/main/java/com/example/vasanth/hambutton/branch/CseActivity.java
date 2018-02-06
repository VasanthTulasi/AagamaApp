package com.example.vasanth.hambutton.branch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        setContentView(R.layout.listview_layout);

        mListView=(ListView)findViewById(R.id.listView);


        TextView v=(TextView) mListView.findViewById(R.id.cardTitle);

        ArrayList<Card> list=new ArrayList<>();

        list.add(new Card("drawable://"+R.drawable.creative1,"Activity1"));
        list.add(new Card("drawable://"+R.drawable.creative1,"Activity2"));
        list.add(new Card("drawable://"+R.drawable.creative1,"Activity3"));
        list.add(new Card("drawable://"+R.drawable.creative1,"Activity4"));
        list.add(new Card("drawable://"+R.drawable.creative1,"Activity5"));
        list.add(new Card("drawable://"+R.drawable.creative1,"Activity6"));
        list.add(new Card("drawable://"+R.drawable.creative1,"Activity7"));

        CustomListAdapter adapter=new CustomListAdapter(this,R.layout.cselist_layout,list);
        mListView.setAdapter(adapter);

    }

}
