package com.example.vasanth.hambutton;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.Date;

public class SplashScreen extends Activity {

    ImageView aagamaLogo;
    TextView aagamaText;
    TextView cse_department;
    private Boolean firstTime = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

           deleteCache(this);
          // clearApplicationData();

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.splash_screen);
        cse_department = (TextView)findViewById(R.id.cse_dep);
        cse_department.setText("@CSE department");
        aagamaLogo = findViewById(R.id.iv);
        aagamaText = findViewById(R.id.changingTextView);
        Animation blinkLogo = AnimationUtils.loadAnimation(this, R.anim.blink_for_logo_in_splash);
        Animation blinkText = AnimationUtils.loadAnimation(this, R.anim.blink_for_text_in_splash);
        aagamaLogo.startAnimation(blinkLogo);
        blinkText.setStartOffset(1500);
        aagamaText.startAnimation(blinkText);

        final Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                aagamaText.setText(R.string.changed_text);
            }
        }, 3000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                aagamaText.setText(R.string.final_text);
            }
        }, 4500);

        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(6000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    if(isFirstTime()) {
                        startActivity(new Intent(SplashScreen.this, Walkthrough.class));
                        finish();
                    }else{
                        startActivity(new Intent(SplashScreen.this, HamButtonActivity.class));
                        finish();
                    }
                }
            }
        };
        timer.start();
    }

    private boolean isFirstTime() {
        if (firstTime == null) {
            SharedPreferences mPreferences = this.getSharedPreferences("first_time", Context.MODE_PRIVATE);
            firstTime = mPreferences.getBoolean("firstTime", true);
            if (firstTime) {
                SharedPreferences.Editor editor = mPreferences.edit();
                editor.putBoolean("firstTime", false);
                editor.commit();
            }
        }
        return firstTime;
    }


   /*
    public void clearApplicationData() {
        File cacheDirectory = getCacheDir();
        File applicationDirectory = new File(cacheDirectory.getParent());
        if (applicationDirectory.exists()) {
            String[] fileNames = applicationDirectory.list();
            for (String fileName : fileNames) {
                if (!fileName.equals("lib")) {
                    deleteFile(new File(applicationDirectory, fileName));
                }
            }
        }
    }

    public static boolean deleteFile(File file) {
        boolean deletedAll = true;
        if (file != null) {
            if (file.isDirectory()) {
                String[] children = file.list();
                for (int i = 0; i < children.length; i++) {
                    deletedAll = deleteFile(new File(file, children[i])) && deletedAll;
                }
            } else {
                deletedAll = file.delete();
            }
        }

        return deletedAll;
    }

*/


    public static void deleteCache(Context context){
        try {
            File dir = context.getCacheDir();
            if (dir != null && dir.isDirectory()) {
                deleteDir(dir);
            }
        } catch (Exception e) {}
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

}
