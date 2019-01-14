package com.example.firstappagain.Uttils;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.example.firstappagain.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.ArrayList;

public class GridAdapterRecycle extends BaseAdapter {

    ArrayList<String> stringArrayListURL;
    Context context;
    ImageLoader imageLoader;
    public GridAdapterRecycle(ArrayList<String> stringArrayListURL, Context context) {
        this.stringArrayListURL = stringArrayListURL;
        this.context = context;
        imageLoader = ImageLoader.getInstance();
    }


    @Override
    public int getCount() {
        return stringArrayListURL.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String modelURLimage = stringArrayListURL.get(position);
        View item_view = LayoutInflater.from(context).inflate(R.layout.item_layout_grid, parent, false);
        SquareImageView imageView=item_view.findViewById(R.id.id_imgViewGrid);
        imageLoader.displayImage(modelURLimage,imageView, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {

            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {

            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {

            }
        });
        return item_view;
    }


}

