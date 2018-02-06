package com.example.vasanth.hambutton;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class DevFragment extends Fragment {

    ListView list;
    String[] name ={
            "M Ravi Teja",
            "T Vasanth",
            "K Shamantha",
            "G Likhitha",
            "B S V Haswitha",
            "P Lavanya Sai",
    };

    Integer[] imgid={
            R.drawable.raviteja,
            R.drawable.vasanth,
            R.drawable.sam,
            R.drawable.likhithaa,
            R.drawable.haswitha,
            R.drawable.lav,
    };

    String[] emailid ={
            "mraviteja9949@gmail.com",
            "lalithavasanth10@gmail.com",
            "shamantharockz@gmail.com",
            "likhithagaddi@gmail.com",
            "bsvhaswitha@gmail.com",
            "lavanyasaipentela@gmail.com",
    };

    String[] phoneno ={
            "9542436509",
            "9948646868",
            "9063748493",
            "9542355551",
            "8106048493",
            "9848983188",
    };
    CustomListAdapterForDev customListAdapterForDev;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dev, container, false);

        customListAdapterForDev =new CustomListAdapterForDev(getActivity(), name, imgid, emailid, phoneno);
        list=(ListView) view.findViewById(R.id.list);
        list.setAdapter(customListAdapterForDev);

        return view;
    }
}