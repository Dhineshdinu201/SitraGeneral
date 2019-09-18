package com.learning.sitrageneral;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;

public class Conversions extends AppCompatActivity {
    private TextView mTextMessage;
    Fragment fragment_fac=null;
    String id="";
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_gps:
                    fragment_fac = new Fragment_gps();
                    loadFragment(fragment_fac);
                    return true;
                case R.id.nav_ukg:
                    fragment_fac = new Fragment_ukg();
                    loadFragment(fragment_fac);
                    return true;
                case R.id.nav_unit:
                    fragment_fac = new fragment_unit();
                    loadFragment(fragment_fac);
                    return true;
                case R.id.nav_count:
                    fragment_fac = new Fragment_count();
                    loadFragment(fragment_fac);
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversions);
        String value="";

        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);

        try {
            value=getIntent().getStringExtra("value");
            id=getIntent().getStringExtra("id");
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        if(value.equals("1")){
            navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
            navView.setSelectedItemId(R.id.nav_gps);
            fragment_fac = new Fragment_gps();
            loadFragment(fragment_fac);
        }else  if(value.equals("2")){
            navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
            navView.setSelectedItemId(R.id.nav_ukg);
            fragment_fac = new Fragment_ukg();
            loadFragment(fragment_fac);
        }
        else  if(value.equals("3")){
            navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
            navView.setSelectedItemId(R.id.nav_count);
            fragment_fac = new Fragment_count();
            loadFragment(fragment_fac);
        }
        else  if(value.equals("4")){
            navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
            navView.setSelectedItemId(R.id.nav_unit);
            fragment_fac = new fragment_unit();
            loadFragment(fragment_fac);
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(Conversions.this,MainActivity.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }

    private void loadFragment(Fragment fragment){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.frag_con,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
