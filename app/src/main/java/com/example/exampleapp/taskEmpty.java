package com.example.exampleapp;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class taskEmpty extends AppCompatActivity {

    CheckBox checkbox_example;
    TextView checkboxValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_empty);
    }
}