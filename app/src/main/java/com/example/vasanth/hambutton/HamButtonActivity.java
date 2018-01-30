package com.example.vasanth.hambutton;

import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PointF;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;
import com.nightonke.boommenu.Util;

import java.util.ArrayList;


public class HamButtonActivity extends AppCompatActivity{

   BoomMenuButton bmb;
   ArrayList<Integer> images;
   ArrayList<String> textInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ham_button);

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
       bmb.setButtonEnum(ButtonEnum.Ham);
       bmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_6_1);
       bmb.setButtonPlaceEnum(ButtonPlaceEnum.HAM_6);

        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {
            HamButton.Builder builder = new HamButton.Builder()
                    .normalImageRes(images.get(i))
                    .normalText(textInfo.get(i))
                  //.subNormalText(" ")
                    .listener(new OnBMClickListener() {

                        android.app.FragmentManager fm = getFragmentManager();
                        @Override
                        public void onBoomButtonClick(int index) {
                            if(index == 0){
                                fm.beginTransaction()
                                        .replace(R.id.main_screen,new HomeFragment())
                                        .commit();
                            }
                            else if(index == 1){
                                fm.beginTransaction()
                                        .replace(R.id.main_screen,new About())
                                        .commit();
                            }
                            else if(index == 2){
                                fm.beginTransaction()
                                        .replace(R.id.main_screen,new Gallery())
                                        .commit();
                            }
                            else if(index == 3){
                                fm.beginTransaction()
                                        .replace(R.id.main_screen,new Team())
                                        .commit();
                            }
                            else if(index == 4){
                                fm.beginTransaction()
                                        .replace(R.id.main_screen,new Sponsor())
                                        .commit();
                            }
                            else if(index == 5){
                                fm.beginTransaction()
                                        .replace(R.id.main_screen,new Contact())
                                        .commit();
                            }

                        }
                    });
            bmb.addBuilder(builder);
        }


    }

    private void setInitialData() {
        images.add(R.drawable.home_icon);
        images.add(R.drawable.about_icon);
        images.add(R.drawable.gallery_icon);
        images.add(R.drawable.team_icon);
        images.add(R.drawable.sponsor_icon);
        images.add(R.drawable.contact_icon);

        textInfo.add("Home");
        textInfo.add("About");
        textInfo.add("Gallery");
        textInfo.add("Team");
        textInfo.add("Sponsor");
        textInfo.add("Contact");

    }

}
