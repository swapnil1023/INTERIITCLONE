package com.example.android.interiit;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


public class MapFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_map, container, false);
        WebView myWebView = rootView.findViewById(R.id.webview);
        myWebView.loadUrl("https://www.google.com/maps/@20.1481339,85.6707391,16z");
        myWebView.getSettings().setJavaScriptEnabled(true);

        return rootView;
    }

}