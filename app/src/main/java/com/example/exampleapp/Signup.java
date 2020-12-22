package com.example.exampleapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

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
                            Toast.makeText(Signup.this, "Done successfully", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}