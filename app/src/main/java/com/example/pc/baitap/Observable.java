package com.example.pc.baitap;

import java.util.ArrayList;

/**
 * Created by PC on 9/30/2017.
 */

public interface Observable {
    ArrayList<Observer> observers = new ArrayList<>();
    void updateData(String data);
    void register(Observer observer);
    void remove(Observer observer);
    void notifyObservers();

}
