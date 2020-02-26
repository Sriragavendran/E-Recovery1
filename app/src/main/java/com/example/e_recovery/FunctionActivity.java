package com.example.e_recovery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class FunctionActivity extends AppCompatActivity {
    private Button b1, b2;
    private EditText id, password;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuction);
        b1 = (Button) findViewById(R.id.loginenter);
        b2 = (Button) findViewById(R.id.register);
        id = (EditText) findViewById(R.id.emailcheck);
        password = (EditText) findViewById(R.id.passwordcheck);
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null) {
            finish();
            startActivity(new Intent(FunctionActivity.this, operationActivity.class));
        }
        b1.setOnClickListener(new View.OnClickListener() {
                                  public void onClick(View v) {
                                      validate(id.getText().toString().trim(), password.getText().toString().trim());

                                  }
                              }
        );
        b2.setOnClickListener(new View.OnClickListener() {
                                  public void onClick(View v) {
                                      startActivity(new Intent(FunctionActivity.this, registerActivity.class));
                                  }
                              }
        );
    }

    private void validate(String id, String password) {
        boolean result = false;
        firebaseAuth.signInWithEmailAndPassword(id, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    startActivity(new Intent(FunctionActivity.this, operationActivity.class));
                } else {
                    Toast.makeText(FunctionActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
