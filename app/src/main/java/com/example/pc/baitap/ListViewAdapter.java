package com.example.pc.baitap;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by PC on 9/30/2017.
 */

/**
 * Adapter for listview in fragment 1
 */

/*
get images and layout resource from activity and display it
 */
public class ListViewAdapter extends ArrayAdapter<String>{

/**
 * call back to communicate with activity
 */

    Listener listener;
    interface Listener{
        void sendData(String data);
    }

    String [] images;
    int resource;
    Context context;
    public ListViewAdapter(Context context, int resource, String[] objects) {
        super(context, resource, objects);
        images = objects;
        this.resource = resource;
        this.context = context;
        listener = (Listener)context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Nullable
    @Override
    public String getItem(int position) {
        return images[position];
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(resource,parent,false);
        }
        ImageView imageView = (ImageView)view.findViewById(R.id.img_item);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    listener.sendData(images[position]);
            }
        });


       Picasso.with(context).load(images[position]).resize(350,200).into(imageView);

        return view;
    }
}
