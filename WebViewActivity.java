package com.example.roy.studentportal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.URL;

public class WebViewActivity extends AppCompatActivity {


    WebView webView;
    String portalUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = findViewById(R.id.webView);

        //get the URL from the main activity
        portalUrl = getIntent().getStringExtra("URL");

        webView.setWebViewClient(new Browser());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(portalUrl);

    }
    private class Browser extends WebViewClient {
        public boolean shoulOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

    }

}
