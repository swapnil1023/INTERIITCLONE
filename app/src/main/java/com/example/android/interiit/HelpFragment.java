package com.example.android.interiit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;


public class HelpFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_help, container, false);
        final WebView webView=rootView.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.iitbbs.ac.in/inter-iit-sports-meet-2019/assets/images/Helpline.jpg");

        webView.getSettings().setBuiltInZoomControls(true);
        webView.setVisibility(View.INVISIBLE);
        //webView.loadUrl("https://www.google.com");
        final ProgressBar pgb=rootView.findViewById(R.id.progress);
        pgb.setVisibility(View.VISIBLE);

        webView.setWebViewClient(new WebViewClient() {

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                pgb.setVisibility(View.GONE);
                webView.setVisibility(View.VISIBLE);
            }
        });

        /*CardView badminton_help = rootView.findViewById(R.id.badminton_help);
        CardView squash_help = rootView.findViewById(R.id.squash_help);
        CardView volleyball_help = rootView.findViewById(R.id.volleyball_help);
        CardView tt_help = rootView.findViewById(R.id.tt_help);

        badminton_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:8895289379"));
                startActivity(intent);
            }
        });
        squash_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:8897843498"));
                startActivity(intent);
            }
        });
        volleyball_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:9962939886"));
                startActivity(intent);
            }
        });
        tt_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:8233242012"));
                startActivity(intent);
            }
        });*/

        return rootView;
    }
}