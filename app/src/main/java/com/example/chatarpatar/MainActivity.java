package com.example.chatarpatar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private WebView mywebView;
    ProgressDialog progressDialog;
    ImageView home,gallery,products,contact;
    WebSettings webSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mywebView=(WebView)findViewById(R.id.webview);
        home=(ImageView)findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                mywebView.loadUrl("http://www.chatarpatar.in/");
            }
        });
        gallery=(ImageView)findViewById(R.id.gallery);
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mywebView.loadUrl("http://www.chatarpatar.in/gallery");
            }
        });
        products=(ImageView)findViewById(R.id.product);
        products.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mywebView.loadUrl("http://www.chatarpatar.in/product");
            }
        });
        contact=(ImageView)findViewById(R.id.contact);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mywebView.loadUrl("http://www.chatarpatar.in/contact");
            }
        });


        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Loading");
        webSettings = mywebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.getLoadsImagesAutomatically();
        webSettings.setAllowFileAccess(true);
        webSettings.getAllowContentAccess();
        mywebView.setWebViewClient(new WebViewClient());
        mywebView.loadUrl("http://www.chatarpatar.in");
        mywebView.setWebChromeClient(new WebChromeClient()
        {
            @Override
            public void onProgressChanged(WebView view,int newProgress)
            {
                progressDialog.show();
                if(newProgress==100)
                {
                    progressDialog.dismiss();
                }
                super.onProgressChanged(view,newProgress);
            }
        });



    }

    @Override
    public void onBackPressed() {
        if(mywebView.canGoBack())
        {
            mywebView.goBack();
        }
    }
}