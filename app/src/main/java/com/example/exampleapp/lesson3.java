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

public class lesson3 extends AppCompatActivity {
    TextView nextBtn2;
    EditText editText2;
    Button showContent;
    Editable content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson3);

        nextBtn2 = findViewById(R.id.nextBtn2);
        editText2 = findViewById(R.id.editText2);
        showContent = findViewById(R.id.showContent);
        content = editText2.getText();

        nextBtn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(lesson3.this,splash2.class);
                intent.putExtra("email","your email is "+content);
                startActivity(intent);
            }
        });

        showContent.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Toast.makeText(lesson3.this, "Your Email is "+content, Toast.LENGTH_SHORT).show();
            }
        });
    }
}