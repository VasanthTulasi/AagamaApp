package com.example.vasanth.hambutton.branch;

import android.content.Context;
import android.content.Intent;
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
import com.example.vasanth.hambutton.itIndividualActivities.CPUCollabIT;
import com.example.vasanth.hambutton.itIndividualActivities.CascadingCodeIt;
import com.example.vasanth.hambutton.itIndividualActivities.CodeMazeIT;
import com.example.vasanth.hambutton.itIndividualActivities.CodeSinkIT;
import com.example.vasanth.hambutton.itIndividualActivities.DeadlyHunt;
import com.example.vasanth.hambutton.itIndividualActivities.MobileAppMockUpIT;
import com.example.vasanth.hambutton.itIndividualActivities.PaperPresentationIT;
import com.example.vasanth.hambutton.itIndividualActivities.PosterPresentationIT;
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

public class ITCustomListAdapter extends ArrayAdapter<Card> {

    private static final String TAG = "PersonListAdapterIT";

    private Context mContextIT;
    private int mResourceIT;
    private int lastPositionIT = -1;

    /**
     * Holds variables in a View
     */
    private static class ViewHolder {

        TextView titleIT;
        ImageView imageIT;
    }


    public ITCustomListAdapter(Context context, int resource, ArrayList<Card> objects) {
        super(context, resource, objects);
        mContextIT = context;
        mResourceIT = resource;
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
            LayoutInflater inflater = LayoutInflater.from(mContextIT);
            convertView = inflater.inflate(mResourceIT, parent, false);
            holder= new ViewHolder();
            holder.titleIT= (TextView) convertView.findViewById(R.id.cardTitleInIT);
            holder.imageIT = (ImageView) convertView.findViewById(R.id.cardImageInIT);
            result = convertView;

            convertView.setTag(holder);
        } else{
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        Button readMoreInIT = (Button)convertView.findViewById(R.id.readMoreInIT);
        readMoreInIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position == 0)
                   mContextIT.startActivity(new Intent(mContextIT, CodeMazeIT.class));
                else if(position == 1)
                    mContextIT.startActivity(new Intent(mContextIT, PaperPresentationIT.class));
                else if(position == 2)
                    mContextIT.startActivity(new Intent(mContextIT, PosterPresentationIT.class));
                else if(position == 3)
                    mContextIT.startActivity(new Intent(mContextIT, MobileAppMockUpIT.class));
                else if(position == 4)
                    mContextIT.startActivity(new Intent(mContextIT, CPUCollabIT.class));
                else if(position == 5)
                    mContextIT.startActivity(new Intent(mContextIT, CascadingCodeIt.class));
                else if(position == 6)
                    mContextIT.startActivity(new Intent(mContextIT, CodeSinkIT.class));
                else if(position == 7)
                    mContextIT.startActivity(new Intent(mContextIT, DeadlyHunt.class));
            }



        });




        //    Animation animation = AnimationUtils.loadAnimation(mContext,
     //           (position > lastPosition) ? R.anim.load_down_anim : R.anim.load_up_anim);
      //  result.startAnimation(animation);
       // lastPosition = position;

        holder.titleIT.setText(title);


        //create the imageloader object
        ImageLoader imageLoader = ImageLoader.getInstance();

        int defaultImage = mContextIT.getResources().getIdentifier("@drawable/image_failed",null,mContextIT.getPackageName());

        //create display options
        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .showImageForEmptyUri(defaultImage)
                .showImageOnFail(defaultImage)
                .showImageOnLoading(defaultImage).build();

        //download and display image from url
        imageLoader.displayImage(imgUrl, holder.imageIT, options);

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
                mContextIT)
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .discCacheSize(100 * 1024 * 1024).build();

        ImageLoader.getInstance().init(config);
        // END - UNIVERSAL IMAGE LOADER SETUP
    }
}