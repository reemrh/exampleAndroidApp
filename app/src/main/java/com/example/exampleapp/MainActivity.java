package com.example.exampleapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView back,yourEmail;
    String emailFromIntent;

    RecyclerView tasks_rv;
    TaskAdapterEx taskAdapter;
    static List<TaskItem> tasksList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        tasksList.add(new TaskItem("Study Programming","false"));
        tasksList.add(new TaskItem("Study","false"));
        tasksList.add(new TaskItem("Programming","true"));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        back = findViewById(R.id.back);
        yourEmail = findViewById(R.id.yourEmail);

        emailFromIntent = getIntent().getStringExtra("email");
        yourEmail.setText(emailFromIntent);

        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        tasks_rv = findViewById(R.id.tasks_rv);
        tasks_rv.setLayoutManager(new LinearLayoutManager(this));
        taskAdapter = new TaskAdapterEx(this ,tasksList );
        tasks_rv.setAdapter(taskAdapter);

    }
}