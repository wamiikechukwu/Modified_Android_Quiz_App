package com.quizapp.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class cardViewSeven extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_seven);
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, didYouKnow.class);
        startActivity(intent);
    }
}
