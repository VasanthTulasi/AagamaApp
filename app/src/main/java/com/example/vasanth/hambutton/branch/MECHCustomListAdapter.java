package com.example.vasanth.hambutton.branch;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vasanth.hambutton.R;
import com.example.vasanth.hambutton.cseBranchIndividualActivities.CseActivity1;
import com.example.vasanth.hambutton.cseBranchIndividualActivities.CseActivity2;
import com.example.vasanth.hambutton.mechBranchIndividualActivities.DesignExecuteMECH;
import com.example.vasanth.hambutton.mechBranchIndividualActivities.MeetYourThoughtsMECH;
import com.example.vasanth.hambutton.mechBranchIndividualActivities.MekboltMECH;
import com.example.vasanth.hambutton.mechBranchIndividualActivities.MindsparkMECH;
import com.example.vasanth.hambutton.mechBranchIndividualActivities.PaperPresentationMECH;
import com.example.vasanth.hambutton.mechBranchIndividualActivities.PrayogMECH;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

import java.util.ArrayList;

/**
 * Created by mravi on 14-01-2018.
 */

public class MECHCustomListAdapter extends ArrayAdapter<Card> {

    private static final String TAG = "PersonListAdapterMECH";

    private Context mContextMECH;
    private int mResourceMECH;
    private int lastPositionMECH = -1;

    /**
     * Holds variables in a View
     */
    private static class ViewHolder {

        TextView titleMECH;
        ImageView imageMECH;
    }


    public MECHCustomListAdapter(Context context, int resource, ArrayList<Card> objects) {
        super(context, resource, objects);
        mContextMECH = context;
        mResourceMECH = resource;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        //sets up the image loader library
        setupImageLoader();

        //get the persons information
        final String title= getItem(position).getTitle();

        String imgUrl = getItem(position).getImgUrl();

        //create the view result for showing the animation
        final View result;

        //ViewHolder object
        ViewHolder holder;



        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mContextMECH);
            convertView = inflater.inflate(mResourceMECH, parent, false);
            holder= new ViewHolder();
            holder.titleMECH= (TextView) convertView.findViewById(R.id.cardTitleInMECH);
            holder.imageMECH = (ImageView) convertView.findViewById(R.id.cardImageInMECH);
            result = convertView;

            convertView.setTag(holder);
        } else{
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        Button readMoreInMECH = (Button)convertView.findViewById(R.id.readMoreInMECH);
        readMoreInMECH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position == 0)
                   mContextMECH.startActivity(new Intent(mContextMECH, MekboltMECH.class));
                else if (position == 1)
                    mContextMECH.startActivity(new Intent(mContextMECH, MindsparkMECH.class));
                else if (position == 2)
                    mContextMECH.startActivity(new Intent(mContextMECH, PaperPresentationMECH.class));
                else if (position == 3)
                    mContextMECH.startActivity(new Intent(mContextMECH, PrayogMECH.class));
                else if (position == 4)
                    mContextMECH.startActivity(new Intent(mContextMECH, DesignExecuteMECH.class));
                else if (position == 5)
                    mContextMECH.startActivity(new Intent(mContextMECH, MeetYourThoughtsMECH.class));

            }
        });
        Button registerInMECH = (Button)convertView.findViewById(R.id.registerInMECH);
        registerInMECH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position == 0)
                    goToChrome("https://docs.google.com/forms/d/e/1FAIpQLSdErYW-h9D50VlnlfXMlcD91uIF5BjaKKI64dLpDC1Y-P5gqA/viewform?usp=sf_link");
                else if (position == 1)
                    goToChrome("https://docs.google.com/forms/d/e/1FAIpQLSfYYpZ534qSxtkIX48oo7g2evHSiFuuUOJ6KTgBBCGi6Xx9lg/viewform?usp=sf_link");
                else if (position == 2)
                    goToChrome("https://docs.google.com/forms/d/e/1FAIpQLSfPpTlFxFL6LGyK_CQvPPc8I2T-8UoasYNnBi1N38OcCXieXg/viewform?usp=sf_link");
                else if (position == 3)
                    goToChrome("https://docs.google.com/forms/d/e/1FAIpQLSdeI23JttyzlX_tGDAbeH45jrkhlJBUbLlS2oXtgf_vVx4beg/viewform?usp=sf_link");

            }
        });



        //    Animation animation = AnimationUtils.loadAnimation(mContext,
     //           (position > lastPosition) ? R.anim.load_down_anim : R.anim.load_up_anim);
      //  result.startAnimation(animation);
       // lastPosition = position;

        holder.titleMECH.setText(title);


        //create the imageloader object
        ImageLoader imageLoader = ImageLoader.getInstance();

        int defaultImage = mContextMECH.getResources().getIdentifier("@drawable/image_failed",null,mContextMECH.getPackageName());

        //create display options
        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .showImageForEmptyUri(defaultImage)
                .showImageOnFail(defaultImage)
                .showImageOnLoading(defaultImage).build();

        //download and display image from url
        imageLoader.displayImage(imgUrl, holder.imageMECH, options);

        return convertView;


    }

    /**
     * Required for setting up the Universal Image loader Library
     */
    private void setupImageLoader(){
        // UNIVERSAL IMAGE LOADER SETUP
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheOnDisc(true).cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                mContextMECH)
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .discCacheSize(100 * 1024 * 1024).build();

        ImageLoader.getInstance().init(config);
        // END - UNIVERSAL IMAGE LOADER SETUP
    }
    public void goToChrome(String docsLink) {
        try {
            Intent i = new Intent("android.intent.action.MAIN");
            i.setComponent(ComponentName.unflattenFromString("com.android.chrome/com.android.chrome.Main"));
            i.addCategory("android.intent.category.LAUNCHER");
            i.setData(Uri.parse(docsLink));
            mContextMECH.startActivity(i);
        } catch (ActivityNotFoundException e) {
            // Chrome is not installed
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(docsLink));
            mContextMECH.startActivity(i);
        }
    }

}