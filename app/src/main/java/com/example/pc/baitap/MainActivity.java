package com.example.pc.baitap;

import android.os.AsyncTask;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import static android.R.attr.fragment;
import static com.example.pc.baitap.R.layout.fragment_1;

public class MainActivity extends AppCompatActivity implements ListViewAdapter.Listener{


    String images [] = {"https://www.w3schools.com/css/img_fjords.jpg",
                        "https://www.w3schools.com/css/img_lights.jpg",
                        "https://www.smashingmagazine.com/wp-content/uploads/2015/06/10-dithering-opt.jpg"};
    ArrayList<Fragment> fragments = new ArrayList<>();
    Fragment_1 fragment_1;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment_1 = new Fragment_1();
        Fragment_2 fragment_2 = new Fragment_2();
        fragment_1.register(fragment_2);
        ListViewAdapter listViewAdapter = new ListViewAdapter(this,R.layout.item,images);
        fragment_1.setAdapter(listViewAdapter);
        fragments.add(fragment_1);
        fragments.add(fragment_2);

        PageAdapter adapter = new PageAdapter(getSupportFragmentManager());
        adapter.setFragments(fragments);

        viewPager= (ViewPager)findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setText("1");
        tabLayout.getTabAt(1).setText("2");



    }



    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 1)
        {
            viewPager.setCurrentItem(0,true);
        }
        else
             super.onBackPressed();
    }

    @Override
    public void sendData(String data) {
        fragment_1.updateData(data);
        viewPager.setCurrentItem(1,true);

    }

}
