package com.example.vasanth.hambutton;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;


import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;

import java.util.ArrayList;
import java.util.Arrays;


public class HamButtonActivity extends AppCompatActivity {

   BoomMenuButton bmb;
   ArrayList<Integer> images;
   ArrayList<String> textInfo;
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ham_button);


       bmb = (BoomMenuButton)findViewById(R.id.boom);
       images = new ArrayList<>();
       textInfo = new ArrayList<>();
       setInitialData();
       bmb.setButtonEnum(ButtonEnum.Ham);
       bmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_3_1);
       bmb.setButtonPlaceEnum(ButtonPlaceEnum.HAM_3);

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
                                        .replace(R.id.main_screen,new FirstFragment())
                                        .commit();
                            }
                            else if(index == 2){
                                fm.beginTransaction()
                                        .replace(R.id.main_screen,new SecondFragment())
                                        .commit();
                            }
                        }
                    });
            bmb.addBuilder(builder);
        }


    }

    private void setInitialData() {
        images.add(R.drawable.home_icon_two);
        images.add(R.drawable.home_icon_two);
        images.add(R.drawable.home_icon_two);

        textInfo.add("Home");
        textInfo.add("First");
        textInfo.add("Second");

    }

}
