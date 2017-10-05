package com.example.pc.baitap;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by PC on 9/30/2017.
 */

public class Fragment_2 extends Fragment implements Observer {

    ImageView imageView;
    Context context;
   
    @Override
    public void receiveData(String img) {
        Picasso.with(context).load(img).resize(450,350).into(imageView);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_2,container,false);
        context = container.getContext();
        imageView =(ImageView) view.findViewById(R.id.img_fragment_2);


        return view;
    }
}
