package com.example.vasanth.hambutton;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class CustomListAdapterForDev extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] name;
    private final Integer[] imgid;
    private final String[] emailid;
    private final String[] phoneno;

    public CustomListAdapterForDev(Activity context, String[] name, Integer[] imgid, String[] emailid, String[] phoneno) {
        super(context, R.layout.mylist_for_dev, name);

        this.context=context;
        this.name=name;
        this.imgid=imgid;
        this.emailid=emailid;
        this.phoneno=phoneno;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist_for_dev, null,true);

        CircleImageView imageView = (CircleImageView) rowView.findViewById(R.id.image);
        TextView nameView = (TextView) rowView.findViewById(R.id.name);
        TextView emailidView = (TextView) rowView.findViewById(R.id.emailid);
        TextView phonenoView = (TextView) rowView.findViewById(R.id.phoneno);

        nameView.setText(name[position]);
        imageView.setImageResource(imgid[position]);
        emailidView.setText(emailid[position]);
        phonenoView.setText(phoneno[position]);
        return rowView;

    };
}
