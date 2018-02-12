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
import android.widget.Toast;

import com.example.vasanth.hambutton.R;
import com.example.vasanth.hambutton.cseBranchIndividualActivities.CseActivity1;
import com.example.vasanth.hambutton.cseBranchIndividualActivities.CseActivity2;
import com.example.vasanth.hambutton.cseBranchIndividualActivities.CseActivity3;
import com.example.vasanth.hambutton.cseBranchIndividualActivities.CseActivity4;
import com.example.vasanth.hambutton.cseBranchIndividualActivities.CseActivity5;
import com.example.vasanth.hambutton.cseBranchIndividualActivities.CseActivity6;
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

public class CSECustomListAdapter extends ArrayAdapter<Card> {

    private static final String TAG = "PersonListAdapter";

    private Context mContext;
    private int mResource;
    private int lastPosition = -1;


    /**
     * Holds variables in a View
     */
    private static class ViewHolder {

        TextView title;
        ImageView image;
    }


    public CSECustomListAdapter(Context context, int resource, ArrayList<Card> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
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
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
            holder= new ViewHolder();
            holder.title= (TextView) convertView.findViewById(R.id.cardTitleInCSE);
            holder.image = (ImageView) convertView.findViewById(R.id.cardImageInCSE);
            result = convertView;

            convertView.setTag(holder);
        } else{
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

            ImageView imageInCSE = (ImageView) convertView.findViewById(R.id.cardImageInCSE);
            imageInCSE.setImageResource(R.drawable.idea_presentation_cse);


        Button readMoreInCSE = (Button)convertView.findViewById(R.id.readMoreInCSE);
        readMoreInCSE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position == 0)
                   mContext.startActivity(new Intent(mContext, CseActivity1.class));
                else if (position == 1)
                    mContext.startActivity(new Intent(mContext, CseActivity2.class));
                else if (position == 2)
                    mContext.startActivity(new Intent(mContext, CseActivity3.class));
                else if (position == 3)
                    mContext.startActivity(new Intent(mContext, CseActivity4.class));
                else if (position == 4)
                    mContext.startActivity(new Intent(mContext, CseActivity5.class));
                else if (position == 5)
                    mContext.startActivity(new Intent(mContext, CseActivity6.class));
            }
        });
        Button register = (Button)convertView.findViewById(R.id.registerInCSE);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position == 0)
                    Toast.makeText(mContext,"Register for "+ title,Toast.LENGTH_SHORT).show();
                else if (position == 1)
                    Toast.makeText(mContext,"Register for "+ title,Toast.LENGTH_SHORT).show();

            }
        });

        // Animation animation = AnimationUtils.loadAnimation(mContext,
        // (position > lastPosition) ? R.anim.load_down_anim : R.anim.load_up_anim);
        // result.startAnimation(animation);
        // lastPosition = position;

        holder.title.setText(title);

        //create the imageloader object
        ImageLoader imageLoader = ImageLoader.getInstance();

        int defaultImage = mContext.getResources().getIdentifier("@drawable/image_failed",null,mContext.getPackageName());

        //create display options
        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .showImageForEmptyUri(defaultImage)
                .showImageOnFail(defaultImage)
                .showImageOnLoading(defaultImage).build();

        //download and display image from url
        imageLoader.displayImage(imgUrl, holder.image, options);

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
                mContext)
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .discCacheSize(100 * 1024 * 1024).build();

        ImageLoader.getInstance().init(config);
        // END - UNIVERSAL IMAGE LOADER SETUP
    }
}