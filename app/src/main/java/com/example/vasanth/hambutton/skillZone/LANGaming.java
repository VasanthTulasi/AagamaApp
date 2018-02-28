package com.example.vasanth.hambutton.skillZone;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.vasanth.hambutton.R;

public class LANGaming extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_langaming);
    }
    public void rcreative(View v){
        String url = "https://docs.google.com/forms/d/e/1FAIpQLSeiz4UwvHsCW75EAfBZsdqG0ZqFUSYS6OopGKO2Onwg2R6rEA/viewform?usp=sf_link";
        try {
            Intent i = new Intent("android.intent.action.MAIN");
            i.setComponent(ComponentName.unflattenFromString("com.android.chrome/com.android.chrome.Main"));
            i.addCategory("android.intent.category.LAUNCHER");
            i.setData(Uri.parse(url));
            startActivity(i);
        }
        catch(ActivityNotFoundException e) {
            // Chrome is not installed
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(i);
        }
    }
}
