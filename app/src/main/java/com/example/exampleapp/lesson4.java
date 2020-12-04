package com.example.exampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class lesson4 extends AppCompatActivity {
    Button nextBtn3,showContent3;
    EditText editText3;
    Editable editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson4);

        nextBtn3 = findViewById(R.id.nextBtn3);
        editText3 = findViewById(R.id.editText3);
        showContent3 = findViewById(R.id.showContent3);
        editText=  editText3.getText();

        nextBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(lesson4.this,otherActivity.class);
               intent.putExtra("email","Your Email is "+editText);
               startActivity(intent);
            }
        });

        showContent3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(lesson4.this, "Your email is "+editText, Toast.LENGTH_SHORT).show();
            }
        });

    }
}