package com.wamiikechukwukanu.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {

    TextView textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        textview = findViewById(R.id.textview);

        String data = getIntent().getStringExtra("nextLayout");

        textview.setText(data);
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