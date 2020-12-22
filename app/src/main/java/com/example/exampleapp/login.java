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

public class login extends AppCompatActivity {

    ImageView closebtn2;
    TextView signuptv;
    EditText emailet2,passet2;
    Button loginbtn;
    TextView forgotet;
    FirebaseAuth mAuth ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

     //   FirebaseUser user = mAuth.getCurrentUser();
//        if (user!=null)
//        {
//            Intent intent = new Intent(login.this , MainActivity.class);
//            startActivity(intent);
//        }

        closebtn2 = findViewById(R.id.closebtn2);
        forgotet = findViewById(R.id.forgotet);
        signuptv = findViewById(R.id.signuptv);
        emailet2 = findViewById(R.id.emailet2);
        passet2= findViewById(R.id.passet2);
        loginbtn = findViewById(R.id.loginbtn);

        closebtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, splash.class);
                startActivity(intent);
            }
        });

        signuptv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this,Signup.class);
                startActivity(intent);
            }
        });

//        forgotet.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(login.this, forgotpassword.class);
//                startActivity(intent);
//            }
//        });
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login.this.doSignIn(emailet2.getText().toString(), passet2.getText().toString());
            }
        });

    }
    private void doSignIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull final Task<AuthResult> task) {


                        if (task.isSuccessful()) {

                            Intent intent = new Intent(login.this, MainActivity.class);
                            startActivity(intent);
//
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(login.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }
}