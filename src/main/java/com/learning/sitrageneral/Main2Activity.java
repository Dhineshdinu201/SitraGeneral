package com.learning.sitrageneral;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.learning.sitrageneral.ui.main.SectionsPagerAdapter;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final int[] ICONS = new int[]{
                R.drawable.prodticon,
                R.drawable.generalicon,
                R.drawable.qwicon};
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(viewPager, true);
//        TabLayout tabs = findViewById(R.id.tabs);
//        tabs.setupWithViewPager(viewPager);
//        tabs.getTabAt(0).setIcon(ICONS[0]);
//        tabs.getTabAt(1).setIcon(ICONS[1]);
//        tabs.getTabAt(2).setIcon(ICONS[2]);

    }
}