package com.example.exampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class lesson2 extends AppCompatActivity {
    Button nextBtn,showTextFromInput;
    EditText input;
    TextView showHere;
    Editable email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson2);

        nextBtn = findViewById(R.id.nextBtn);
        input = findViewById(R.id.input);
        showTextFromInput = findViewById(R.id.showTextFromInput);
        showHere = findViewById(R.id.showHere);
         email = input.getText();

        nextBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(lesson2.this,MainActivity.class);
                intent.putExtra("email","your email is :"+input.getText());
                startActivity(intent);
            }
        });

        showTextFromInput.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
             showHere.setText(input.getText());
            }
        });


    }
}