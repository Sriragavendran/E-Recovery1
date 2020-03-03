package com.example.e_recovery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class vehicleActivity extends AppCompatActivity {
    private EditText vehicleNo, Vehiclecolor, operatorName;
    private Button save;
    private DatabaseReference myref;
    // File myfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);
        operatorName = (EditText) findViewById(R.id.name);
        vehicleNo = (EditText) findViewById(R.id.vehicleNumber);
        Vehiclecolor = (EditText) findViewById(R.id.color);
        save = (Button) findViewById(R.id.save);
        final FirebaseDatabase database=FirebaseDatabase.getInstance();
            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(validate()) {
                        ArrayList<String> list = new ArrayList<>();
                        myref=database.getReference();
                        String filename = "User data:" + operatorName.getText().toString().trim();
                        String data = "Name :" + operatorName.getText().toString().trim() + "Vehicle Number :" + vehicleNo.getText().toString().trim() + " Vehicle color: " + Vehiclecolor.getText().toString().trim();
                        list.add(data);
                        Toast.makeText(vehicleActivity.this, "Data saved!!!", Toast.LENGTH_SHORT).show();

                    }
                    else{
                        Toast.makeText(vehicleActivity.this,"Please enter the details...",Toast.LENGTH_SHORT).show();
                    }
                }


            });



    }
    public  boolean validate(){
        boolean result=true;
        String name=operatorName.getText().toString().trim();
        String no=vehicleNo.getText().toString().trim();
        String color=Vehiclecolor.getText().toString().trim();
        if(name.isEmpty()&&no.isEmpty()&&color.isEmpty()){
            result=false;
        }

        return  result;
    }
}
