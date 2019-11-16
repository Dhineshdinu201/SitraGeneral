package com.learning.sitrageneral;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.sitra.general.R;

public class TestingChemistry extends AppCompatActivity {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_lists:
                    showDialog("list");
                    return true;
                case R.id.nav_size:
                    showDialog("size");
                    return true;
                case R.id.nav_tests:
                    showDialog("tests");
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing_chemistry);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        String name=getIntent().getStringExtra("name");
        WebView webView;
        webView = (WebView) findViewById(R.id.web);
        webView.setBackgroundColor(Color.TRANSPARENT);
        // displaying content in WebView from html file that stored in assets folder
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/testing_chemistry.html");
    }
    public void showDialog(String name){

        Activity activity = null;
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        Button close;

        final AlertDialog alertDialog = dialogBuilder.create();
        LayoutInflater factory = LayoutInflater.from(this);
        final View vi = factory.inflate(R.layout.alert_zoom, null);
       ImageView Zoomimage;
       Zoomimage=(ImageView)vi.findViewById(R.id.zomm_image);
       if(name=="list") {
           Zoomimage.setImageResource(R.drawable.chem_test_lists);
       }
        if(name=="size") {
            Zoomimage.setImageResource(R.drawable.chem_sam_size);
        }
        if(name=="tests") {
            Zoomimage.setImageResource(R.drawable.chem_test_stan);
        }




        alertDialog.setView(vi);
        alertDialog.show();
        alertDialog.setCancelable(true);

    }
}
