package com.example.firstappagain.Uttils;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.firstappagain.R;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

public class UniversalImageLoader {
    Context mcontext;

    final int imgDefult= R.drawable.ic_launcher_background;
    public UniversalImageLoader(Context mcontext) {
        this.mcontext = mcontext;
    }
    public ImageLoaderConfiguration imageConfig(){

        DisplayImageOptions  imageOptions=new  DisplayImageOptions.Builder()
                .showImageForEmptyUri(imgDefult).showImageOnFail(imgDefult).showImageOnLoading(imgDefult)
                .cacheInMemory(true).cacheOnDisk(true).resetViewBeforeLoading(true)
                .imageScaleType(ImageScaleType.EXACTLY).displayer(new FadeInBitmapDisplayer(300))
                .build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(mcontext)
                .defaultDisplayImageOptions(imageOptions)
                .diskCacheSize(100*1024*1024).memoryCache(new WeakMemoryCache()).build();


        return config;
    }


    public void setImage(String imgUrl, ImageView imageView, final ProgressBar mprogressBar, String append){
        ImageLoader imageLoader=ImageLoader.getInstance();
        imageLoader.displayImage(append + imgUrl, imageView, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {

                if(mprogressBar!= null){
                    mprogressBar.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

                if(mprogressBar!= null){
                    mprogressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {

                if(mprogressBar!= null){
                    mprogressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

                if(mprogressBar!= null){
                    mprogressBar.setVisibility(View.GONE);
                }
            }
        });
    }
}
