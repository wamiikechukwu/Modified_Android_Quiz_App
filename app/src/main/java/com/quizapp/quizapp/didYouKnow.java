package com.quizapp.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class didYouKnow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_did_you_know);
    }


    public void cardViewZero(View view) {
        Intent intent = new Intent(this, cardViewZero.class);
        startActivity(intent);
    }

    public void cardViewOne(View view) {

    }
}
