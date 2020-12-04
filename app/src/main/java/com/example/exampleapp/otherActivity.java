package com.example.exampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class otherActivity extends AppCompatActivity {

    TextView backBtn,yourEmail3;
    String intentContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        backBtn = findViewById(R.id.backBtn);
        yourEmail3 = findViewById(R.id.yourEmail3);

        intentContent = getIntent().getStringExtra("email");
        yourEmail3.setText(intentContent);


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}