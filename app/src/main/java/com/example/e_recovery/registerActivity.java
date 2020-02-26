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

public class registerActivity extends AppCompatActivity {
    private Button b1, b2;
    private EditText patientName, patientid, hospitalCode, password, repassword;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        b2 = (Button) findViewById(R.id.registerButton);
        b1 = (Button) findViewById(R.id.loginButton);
        register();
        firebaseAuth = FirebaseAuth.getInstance();
        b1.setOnClickListener(new View.OnClickListener() {
                                  public void onClick(View v) {
                                      startActivity(new Intent(registerActivity.this, FunctionActivity.class));
                                  }
                              }
        );
        b2.setOnClickListener(new View.OnClickListener() {
                                  public void onClick(View v) {
                                      if (validate()) {
                                          String id = patientid.getText().toString().trim();
                                          String pass = password.getText().toString().trim();
                                          firebaseAuth.createUserWithEmailAndPassword(id, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                              @Override
                                              public void onComplete(@NonNull Task<AuthResult> task) {
                                                  if (task.isSuccessful()) {
                                                      Toast.makeText(registerActivity.this, "Registration is Successful", Toast.LENGTH_SHORT).show();
                                                      startActivity(new Intent(registerActivity.this, FunctionActivity.class));
                                                  } else {
                                                      Toast.makeText(registerActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                                                  }
                                              }
                                          });
                                      }
                                  }
                              }
        );
    }

    private void register() {
        patientid = (EditText) findViewById(R.id.patientid);
        patientName = (EditText) findViewById(R.id.patientName);
        hospitalCode = (EditText) findViewById(R.id.hcode);
        password = (EditText) findViewById((R.id.password));
        repassword = (EditText) findViewById(R.id.repass);
    }

    private Boolean validate() {
        Boolean result = false;
        String Name = patientName.getText().toString().trim();
        String id = patientid.getText().toString().trim();
        String code = hospitalCode.getText().toString().trim();
        String pass = password.getText().toString().trim();
        String repasss = repassword.getText().toString().trim();
        if (Name.isEmpty() || id.isEmpty() || pass.isEmpty() || repasss.isEmpty() || !pass.equals(repasss) || code.isEmpty()) {
            Toast.makeText(this, "Please enter valid details", Toast.LENGTH_SHORT).show();
        } else {
            if (code.equals("HC2020") || code.equals("HC2019") || code.equals("HC2018")) {
                result = true;
            } else {
                Toast.makeText(this, "Please enter valid details", Toast.LENGTH_SHORT).show();
            }
        }
        return result;
    }
}
