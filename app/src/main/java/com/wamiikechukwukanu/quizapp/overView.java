package com.wamiikechukwukanu.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class overView extends AppCompatActivity {

    //variable to store the referenced ID of the adView
    public AdView overviewAd1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
         This code will hide the app title and action bar
         */

        try {

            //Hide app's tile bar
            requestWindowFeature(Window.FEATURE_NO_TITLE);

            //Hide app's action bar
            ActionBar actionBar = getSupportActionBar();
            actionBar.hide();

        } catch (Exception e) {

            Toast.makeText(this, "Encountered an Error", Toast.LENGTH_SHORT).show();

        }

        //Allow android/java to set the layout
        setContentView(R.layout.activity_over_view);

        //Referencing the aadId from admob and initialing it
        MobileAds.initialize(this, "ca-app-pub-9646388292265496/4392647445");

        overviewAd1 = findViewById(R.id.overviewAd1);

        AdRequest adRequest = new AdRequest.Builder().build();
        overviewAd1.loadAd(adRequest);

    }

    //adding the menu to this activity
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menu1:
                Intent intent = new Intent(this, contactUs.class);
                startActivity(intent);
                return true;

            case R.id.menu2:
                String address = "wami7470@gmail.com";
                String subject = "Africa Quiz App";
                String text = "I wish to contact the developer of Africa Quiz App";
                Intent sendMessage = new Intent(Intent.ACTION_SEND_MULTIPLE);
                sendMessage.setType("*/*");
                sendMessage.putExtra(Intent.EXTRA_EMAIL, address);
                sendMessage.putExtra(Intent.EXTRA_SUBJECT, subject);
                sendMessage.putExtra(Intent.EXTRA_TEXT, text);
                if (sendMessage.resolveActivity(getPackageManager()) != null) {
                    startActivity(sendMessage);
                }
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void questionInto(View view) {
        Intent intent = new Intent(this, introStartQuiz.class);
        startActivity(intent);
    }

    public void didYouKnow(View view) {
        Intent intent = new Intent(this, didYouKnow.class);
        startActivity(intent);
    }

    public void africaNews(View view) {
        Intent intent = new Intent(this, africaNews.class);
        startActivity(intent);
    }

    public void misconAfrica(View view) {
        Intent intent = new Intent(this, misconAfrica.class);
        startActivity(intent);
    }


}

