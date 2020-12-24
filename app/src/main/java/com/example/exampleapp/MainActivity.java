package com.example.exampleapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView back,yourEmail;
    String emailFromIntent;
    RecyclerView tasks_rv;
    TaskAdapterEx taskAdapter;
    EditText NewTaskName;
    Button addNewTask;
    FirebaseAuth mAuth;
    static List<TaskItem> tasksList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        back = findViewById(R.id.back);
        yourEmail = findViewById(R.id.yourEmail);
        addNewTask = findViewById(R.id.addNewTask);
        NewTaskName = findViewById(R.id.NewTaskName);


        emailFromIntent = getIntent().getStringExtra("email");
        yourEmail.setText(emailFromIntent);

        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.logout).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(MainActivity.this,"signed out", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, login.class);
                startActivity(intent);

            }
        });

        addNewTask.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                mAuth = FirebaseAuth.getInstance();
                FirebaseUser user = mAuth.getCurrentUser();
                String uid = user.getUid();
                TaskItem newTask= new TaskItem();
                newTask.setTitle(NewTaskName.getText().toString());
                newTask.setIsChecked(false);
                String taskId=FirebaseDatabase.getInstance().getReference("Users").child(uid).child("tasks").push().getKey();
                newTask.setId(taskId);
                FirebaseDatabase.getInstance().getReference("Users").child(uid).child("tasks").child(taskId).setValue(newTask);
                Toast.makeText(MainActivity.this,"task has been added successfully", Toast.LENGTH_SHORT).show();
                NewTaskName.setText(" ");
            }

        });

// add task items to the list
//        tasksList.add(new TaskItem("1","Study Programming",false));
//        tasksList.add(new TaskItem("2","Study",true));
//        tasksList.add(new TaskItem("3","Programming",true));

        mAuth= FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        String uid = user.getUid();
        FirebaseDatabase.getInstance().getReference("Users").child(uid).child("tasks")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        tasksList.clear();
                        for(DataSnapshot snapshot: dataSnapshot.getChildren() ){
                            TaskItem task =  snapshot.getValue(TaskItem.class);
                            tasksList.add(task);
                        }
                        taskAdapter.notifyDataSetChanged();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });


        tasks_rv = findViewById(R.id.tasks_rv);
        tasks_rv.setLayoutManager(new LinearLayoutManager(this));
        taskAdapter = new TaskAdapterEx(this ,tasksList );
        tasks_rv.setAdapter(taskAdapter);

    }
}