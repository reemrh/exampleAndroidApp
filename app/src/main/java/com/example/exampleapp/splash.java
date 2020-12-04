package com.example.exampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class splash extends AppCompatActivity {

    Button btn;
    TextView text3;
    EditText text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        text3 = findViewById(R.id.text3);
        text2 = findViewById(R.id.text2);
        btn = findViewById(R.id.signup);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = getIntent().getStringExtra("title");
                Toast.makeText(splash.this, title , Toast.LENGTH_SHORT).show();

            }
        });
       }
    }
