package com.hidiki.afro.afro;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class WebView extends AppCompatActivity {


    private android.webkit.WebView Browser;
    private ImageButton BtnPrevious;
    private ImageButton BtnNext;
    private ImageButton BtnExit;
    private String PreviousUrl;
    private String NextUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);


        Browser = (android.webkit.WebView)findViewById(R.id.idBrowser);
        Browser.getSettings().setJavaScriptEnabled(true);
        BtnPrevious = (ImageButton)findViewById(R.id.BtnPrevious);
        BtnNext = (ImageButton)findViewById(R.id.BtnNext);
        BtnExit = (ImageButton)findViewById(R.id.BtnExit);

        final Activity activity = this;

        Browser.setWebViewClient(new WebViewClient() {
            public void onReceivedError(android.webkit.WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, description, Toast.LENGTH_SHORT).show();
            }
        });

        Browser.loadUrl("https://fstg-share.blogspot.com/");
        PreviousUrl = Browser.getUrl();

    }
    public void Previous(View Target){
        if(Browser.canGoBack()){
            Browser.goBack();
        }
    }
    public void Next(View Target){
        if(Browser.canGoForward()){
            Browser.goForward();
        }
    }
    public void Exit(View Target){
        finish();
        System.exit(0);
    }
}
