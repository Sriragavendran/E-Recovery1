package com.example.e_recovery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class f2 extends AppCompatActivity {
    private Button login, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f2);
        login = (Button) findViewById(R.id.login);
        register = (Button) findViewById(R.id.register);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(f2.this, FunctionActivity.class));
            }
        });
        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent(f2.this, registerActivity.class));
                } catch (Exception e) {
                    Toast.makeText(f2.this, "Registration failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
