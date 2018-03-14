package com.example.android.project05_nd_tourguideme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class IntroActivity extends AppCompatActivity {

    Button mButton;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_layout);

            getSupportActionBar().hide();

            mButton = findViewById(R.id.buttonStart);

        mButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(IntroActivity.this, Run1stActivity.class);
                IntroActivity.this.startActivity(myIntent);

            }});}}
