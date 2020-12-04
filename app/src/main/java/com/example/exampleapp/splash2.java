package com.example.exampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class splash2 extends AppCompatActivity {
    TextView back2,splashContent;
    String intentContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);

        back2 = findViewById(R.id.back2);
        splashContent = findViewById(R.id.splashContent);
        intentContent = getIntent().getStringExtra("email");

        splashContent.setText(intentContent);

        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
}