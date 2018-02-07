package com.example.vasanth.hambutton.branch;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
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
import com.example.vasanth.hambutton.eeeBranchIndividualActivities.PaperPresentationEEE;
import com.example.vasanth.hambutton.eeeBranchIndividualActivities.PosterPresentationEEE;
import com.example.vasanth.hambutton.eeeBranchIndividualActivities.ProjectExpoEEE;
import com.example.vasanth.hambutton.eeeBranchIndividualActivities.TechnicalQuizEEE;
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

public class EEECustomListAdapter extends ArrayAdapter<Card> {

    private static final String TAG = "PersonListAdapterEEE";

    private Context mContextEEE;
    private int mResourceEEE;
    private int lastPositionEEE = -1;

    /**
     * Holds variables in a View
     */
    private static class ViewHolder {

        TextView titleEEE;
        ImageView imageEEE;
    }


    public EEECustomListAdapter(Context context, int resource, ArrayList<Card> objects) {
        super(context, resource, objects);
        mContextEEE = context;
        mResourceEEE = resource;
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
            LayoutInflater inflater = LayoutInflater.from(mContextEEE);
            convertView = inflater.inflate(mResourceEEE, parent, false);
            holder= new ViewHolder();
            holder.titleEEE= (TextView) convertView.findViewById(R.id.cardTitleInEEE);
            holder.imageEEE = (ImageView) convertView.findViewById(R.id.cardImageInEEE);
            result = convertView;

            convertView.setTag(holder);
        } else{
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        Button readMoreInEEE = (Button)convertView.findViewById(R.id.readMoreInEEE);
        readMoreInEEE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position == 0)
                   mContextEEE.startActivity(new Intent(mContextEEE, PaperPresentationEEE.class));
                else if (position == 1)
                    mContextEEE.startActivity(new Intent(mContextEEE, PosterPresentationEEE.class));
                else if (position == 2)
                    mContextEEE.startActivity(new Intent(mContextEEE, ProjectExpoEEE.class));
                else if (position == 3)
                    mContextEEE.startActivity(new Intent(mContextEEE, TechnicalQuizEEE.class));

            }
        });




        //    Animation animation = AnimationUtils.loadAnimation(mContext,
     //           (position > lastPosition) ? R.anim.load_down_anim : R.anim.load_up_anim);
      //  result.startAnimation(animation);
       // lastPosition = position;

        holder.titleEEE.setText(title);


        //create the imageloader object
        ImageLoader imageLoader = ImageLoader.getInstance();

        int defaultImage = mContextEEE.getResources().getIdentifier("@drawable/image_failed",null,mContextEEE.getPackageName());

        //create display options
        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .showImageForEmptyUri(defaultImage)
                .showImageOnFail(defaultImage)
                .showImageOnLoading(defaultImage).build();

        //download and display image from url
        imageLoader.displayImage(imgUrl, holder.imageEEE, options);

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
                mContextEEE)
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .discCacheSize(100 * 1024 * 1024).build();

        ImageLoader.getInstance().init(config);
        // END - UNIVERSAL IMAGE LOADER SETUP
    }
}