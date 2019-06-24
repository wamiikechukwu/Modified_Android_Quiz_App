package com.wamiikechukwukanu.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class score extends AppCompatActivity {

    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        textview = findViewById(R.id.textview);

        ImageView imageView = findViewById(R.id.image);

        String data = getIntent().getStringExtra("nextLayout");

        textview.setText(data);

        Glide.with(this)
                .load(R.drawable.trophy)
                .into(imageView);

        //Referencing the aadId from admob and initialing it
        MobileAds.initialize(this, "ca-app-pub-9646388292265496/4392647445");

        AdView adView0 = findViewById(R.id.overviewAd0);
        AdView adView1 = findViewById(R.id.overviewAd1);

        AdRequest adRequest = new AdRequest.Builder().build();

        adView0.loadAd(adRequest);
        adView1.loadAd(adRequest);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public void tryAgain(View view) {
        Intent intent = new Intent(this, overView.class);
        startActivity(intent);
    }
}