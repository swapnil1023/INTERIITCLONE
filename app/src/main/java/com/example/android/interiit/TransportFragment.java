package com.example.android.interiit;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;


public class TransportFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v=inflater.inflate(R.layout.fragment_transport, container, false);
        final WebView webView = (WebView) v.findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://docs.google.com/gview?embedded=true&url="+"https://www.iitbbs.ac.in/transportation-fle/transport_1572912511.pdf");
        webView.setVisibility(View.INVISIBLE);
        //webView.loadUrl("https://www.google.com");
        final ProgressBar pgb=v.findViewById(R.id.pgbr);
        pgb.setVisibility(View.VISIBLE);

        webView.setWebViewClient(new WebViewClient() {

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                pgb.setVisibility(View.GONE);
                webView.setVisibility(View.VISIBLE);
            }
        });
        return v;
    }



}
