package com.example.e_recovery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class patientActivity extends AppCompatActivity {
    private EditText patientName, problem;
    private Button save;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
        patientName = (EditText) findViewById(R.id.name);
        problem = (EditText) findViewById(R.id.problem);
        save = (Button) findViewById(R.id.save);

            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(validate()) {
                        String data = "Name :" + patientName.getText().toString().trim() + "Vehicle Number :" + problem.getText().toString().trim();
                        Toast.makeText(patientActivity.this, "Data saved!!!", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(patientActivity.this,"Please enter the details...",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        


    }
    public Boolean validate(){
        boolean result=true;
        String name=patientName.getText().toString().trim();
        String prob=problem.getText().toString().trim();
        if(name.isEmpty()&&prob.isEmpty()){
            result=false;
        }
        return result;
    }
}
