package com.learning.sitrageneral;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.sitra.general.R;

public class Employment extends AppCompatActivity {
    WebView webn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employment);
        String url=getIntent().getStringExtra("link");
        webn=(WebView)findViewById(R.id.webview_help);
        webn.loadUrl(url);
        webn.setWebViewClient(new WebViewClient());
        WebSettings webSettings=webn.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}
