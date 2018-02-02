package com.example.vasanth.hambutton;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.nightonke.boommenu.Animation.BoomEnum;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;
import com.nightonke.boommenu.Util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.example.vasanth.hambutton.R.layout.ham_button;


public class HamButtonActivity extends AppCompatActivity{

    private TextView txtTimerDay, txtTimerHour, txtTimerMinute, txtTimerSecond;
    private TextView tvEvent;
    private Handler handler;
    private Runnable runnable;



   BoomMenuButton bmb;
   ArrayList<Integer> images;
   ArrayList<String> textInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ham_button);

        txtTimerDay = (TextView) findViewById(R.id.txtTimerDay);
        txtTimerHour = (TextView) findViewById(R.id.txtTimerHour);
        txtTimerMinute = (TextView) findViewById(R.id.txtTimerMinute);
        txtTimerSecond = (TextView) findViewById(R.id.txtTimerSecond);
        tvEvent = (TextView) findViewById(R.id.tvhappyevent);
        countDownStart();



        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

          //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
          getSupportActionBar().setTitle(R.string.nothing);
         // getSupportActionBar().setIcon(R.drawable.launch1);
          // toolbar.setLogo(R.drawable.home_icon);

        bmb = findViewById(R.id.boom);
       images = new ArrayList<>();
       textInfo = new ArrayList<>();
       setInitialData();
       bmb.setButtonEnum(ButtonEnum.TextOutsideCircle);
       bmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_7_1);
       bmb.setButtonPlaceEnum(ButtonPlaceEnum.SC_7_1);


        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {
            TextOutsideCircleButton.Builder builder = new TextOutsideCircleButton.Builder()
                   //  .isRound(false)
                    // .shadowCornerRadius(Util.dp2px(10))
                    // .buttonCornerRadius(Util.dp2px(10))
                    .normalImageRes(images.get(i))
                    .normalText(textInfo.get(i))
                    .normalColor(R.color.colorPrimary)
                    .pieceColor(Color.WHITE)
                    //.subNormalText(" ")
                    .listener(new OnBMClickListener() {

                        android.app.FragmentManager fm = getFragmentManager();
                        @Override
                        public void onBoomButtonClick(int index) {
                            if(index == 6) {
                                fm.beginTransaction()
                                        .replace(R.id.main_screen,new HomeFragment())
                                        .commit();
                            }
                            else if(index == 0){
                                fm.beginTransaction()
                                        .replace(R.id.main_screen,new About())
                                        .commit();
                            }
                            else if(index == 1){
                                fm.beginTransaction()
                                        .replace(R.id.main_screen,new Gallery())
                                        .commit();
                            }
                            else if(index == 2){
                                fm.beginTransaction()
                                        .replace(R.id.main_screen,new Team())
                                        .commit();
                            }
                            else if(index == 3){
                                fm.beginTransaction()
                                        .replace(R.id.main_screen,new Sponsor())
                                        .commit();
                            }
                            else if(index == 4){
                                fm.beginTransaction()
                                        .replace(R.id.main_screen,new Contact())
                                        .commit();
                            }
                            else if(index == 5) {

                                if (appInstalledOrNot("com.google.android.apps.maps")) {

                                    String strUri = "http://maps.google.com/maps?q=Anurag Group of Institutions, Venkatapur, Telangana";
                                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(strUri));
                                    intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                                    startActivity(intent);

                                }
                                else{
                                    fm.beginTransaction()
                                            .replace(R.id.main_screen,new Location())
                                            .commit();
                                }
                            }

                        }
                    });
            bmb.addBuilder(builder);
        }



    }

    private void setInitialData() {
        images.add(R.drawable.about_icon);
        images.add(R.drawable.gallery_icon);
        images.add(R.drawable.team_icon);
        images.add(R.drawable.sponsor_icon);
        images.add(R.drawable.contact_icon);
        images.add(R.drawable.location_icon);
        images.add(R.drawable.home_icon);


        textInfo.add("About");
        textInfo.add("Gallery");
        textInfo.add("Team");
        textInfo.add("Sponsor");
        textInfo.add("Contact");
        textInfo.add("Location");
        textInfo.add("Home");

    }

    private boolean appInstalledOrNot(String uri)
    {
        PackageManager pm = getPackageManager();
        boolean app_installed = false;
        try
        {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            app_installed = true;
        }
        catch (PackageManager.NameNotFoundException e)
        {
            app_installed = false;
        }
        return app_installed ;
    }
    public void countDownStart() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, 1000);
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat(
                            "yyyy-MM-dd");
// Please here set your event date//YYYY-MM-DD
                    Date futureDate = dateFormat.parse("2018-03-16");
                    Date currentDate = new Date();
                    if (!currentDate.after(futureDate)) {
                        long diff = futureDate.getTime()
                                - currentDate.getTime();
                        long days = diff / (24 * 60 * 60 * 1000);
                        diff -= days * (24 * 60 * 60 * 1000);
                        long hours = diff / (60 * 60 * 1000);
                        diff -= hours * (60 * 60 * 1000);
                        long minutes = diff / (60 * 1000);
                        diff -= minutes * (60 * 1000);
                        long seconds = diff / 1000;
                        txtTimerDay.setText("" + String.format("%02d", days));
                        txtTimerHour.setText("" + String.format("%02d", hours));
                        txtTimerMinute.setText(""
                                + String.format("%02d", minutes));
                        txtTimerSecond.setText(""
                                + String.format("%02d", seconds));
                    } else {
                        tvEvent.setVisibility(View.VISIBLE);
                        tvEvent.setText("The event started!");
                        textViewGone();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        handler.postDelayed(runnable, 1 * 1000);
    }
    public void textViewGone() {
        findViewById(R.id.LinearLayout10).setVisibility(View.GONE);
        findViewById(R.id.LinearLayout11).setVisibility(View.GONE);
        findViewById(R.id.LinearLayout12).setVisibility(View.GONE);
        findViewById(R.id.LinearLayout13).setVisibility(View.GONE);
        findViewById(R.id.textView1).setVisibility(View.GONE);
        findViewById(R.id.textView2).setVisibility(View.GONE);
    }


}
