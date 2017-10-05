package com.example.pc.baitap;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import static android.R.attr.data;

/**
 * Created by PC on 9/30/2017.
 */

public class Fragment_1 extends Fragment implements Observable{

    String data;
    ListViewAdapter adapter;

    public void setAdapter(ListViewAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void updateData(String data) {
        this.data = data;

        notifyObservers();

    }

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {

        for(Observer observer: observers)
        {
            observer.receiveData(data);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_1,container,false);
        ListView listView = (ListView)view.findViewById(R.id.items);
        listView.setAdapter(adapter);

        return view;
    }
}
