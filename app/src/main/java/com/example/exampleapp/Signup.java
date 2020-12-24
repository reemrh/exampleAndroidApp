package com.example.exampleapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Signup extends AppCompatActivity {
    ImageView closebtn;
    TextView signtv;
    EditText emailet1,passet1;
    Button signupbtn;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth= FirebaseAuth.getInstance();
//        FirebaseUser user = mAuth.getCurrentUser();
//        if ( user !=null)
//        {
//            Intent intent = new Intent(Signup.this , MainActivity.class);
//            startActivity(intent);
//        }

        closebtn = findViewById(R.id.closebtn);
        signtv = findViewById(R.id.signtv);
        emailet1 = findViewById(R.id.emailet1);
        passet1 = findViewById(R.id.passet1);
        signupbtn = findViewById(R.id.signupbtn);
        signtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signup.this, login.class);
                startActivity(intent);
            }
        });
        closebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Signup.this, splash.class);
                startActivity(intent);
            }
        });

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Signup.this.doSignUp(emailet1.getText().toString(), passet1.getText().toString());
            }
        });

    }

    private void doSignUp(String email, String password) {

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull final Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            String uid = user.getUid();

                            // Write a message to the database
//                            FirebaseDatabase database = FirebaseDatabase.getInstance();
//                            DatabaseReference myRef = database.getReference("User");
//                             myRef.setValue("Hello, World!");
                            Map<String,Object> data = new HashMap<>();
                            data.put("uid",uid);
                            FirebaseDatabase.getInstance().getReference("Users").child(uid).setValue(data)
                                    .addOnFailureListener(new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            Toast.makeText(Signup.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                            Log.d("error",e.getLocalizedMessage());
                                        }
                                    })
                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                                        @Override
                                        public void onSuccess(Void aVoid) {
                                            Intent intent = new Intent(Signup.this, login.class);
                                            startActivity(intent);
                                        }
                                    });
                        }

                    }
                });
        }
}