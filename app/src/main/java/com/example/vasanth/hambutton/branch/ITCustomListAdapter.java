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

        Button registerInIT = (Button)convertView.findViewById(R.id.registerInIT);
        registerInIT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(position == 0)
                    goToChrome("https://docs.google.com/forms/d/e/1FAIpQLSePMi9KhhAMz58T2CMT37GYbQtUoROuhIblIpoVCAjy0bLs1w/viewform");
                else if(position == 1)
                    goToChrome("https://docs.google.com/forms/d/e/1FAIpQLSeTqZR0yPJERE0lDsFdzwceIqQXTmBC26uVjIUt2oOsIsCivA/viewform");
                else if(position == 2)
                    goToChrome("https://docs.google.com/forms/d/e/1FAIpQLSdqY8HhSYyLxkmfTL0Y9UwhoBJR80vudBPDQur7-NOjqXTWZQ/viewform");
                else if(position == 3)
                    goToChrome("https://docs.google.com/forms/d/e/1FAIpQLScpOjSyQv7F5wvN8eBfjEr0zF3wQLUA-U1I1Rcs1E9vnHA7eA/viewform");
                else if(position == 4)
                    goToChrome("https://docs.google.com/forms/d/e/1FAIpQLSfhc3StAFN0iH2-nvQMh0U9A94NAvLimW3pbc9_IkfRlgBU6w/viewform");
                else if(position == 5)
                    goToChrome("https://docs.google.com/forms/d/e/1FAIpQLSdNkUaG_i3L5kaLIHrIEJEAqq6QgDpsZ9B7D2wJ2gbNELUJlg/viewform");
                else if(position == 6)
                    goToChrome("https://docs.google.com/forms/d/e/1FAIpQLSd2tg1JcIfzM7JCzlHTNXSOc8KeG6-187SeAq2ScsJNIJkTjA/viewform");
                else if(position == 7)
                    goToChrome("https://docs.google.com/forms/d/e/1FAIpQLSe3K00iQTXnNlpGbV1-g13O4ea_3VeY1HFzBiGnTCbPaowb6Q/viewform");
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

    public void goToChrome(String docsLink){
        try {
            Intent i = new Intent("android.intent.action.MAIN");
            i.setComponent(ComponentName.unflattenFromString("com.android.chrome/com.android.chrome.Main"));
            i.addCategory("android.intent.category.LAUNCHER");
            i.setData(Uri.parse(docsLink));
            mContextIT.startActivity(i);
        }
        catch(ActivityNotFoundException e) {
            // Chrome is not installed
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(docsLink));
            mContextIT.startActivity(i);
        }
    }

}