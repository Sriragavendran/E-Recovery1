package com.example.e_recovery;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import mailer.EMailSender;

public class operationActivity extends AppCompatActivity {
    private static final String mailId = "erecoveryapplication05@gmail.com";
    private static final String password = "recover@123";
    private Button vehicle, patientData, emergency,route;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation);
        vehicle = findViewById(R.id.vehicle);
        patientData = findViewById(R.id.pdata);
        emergency = findViewById(R.id.emergency);
        route=findViewById(R.id.route);
        vehicle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(operationActivity.this, vehicleActivity.class));
            }
        });
        patientData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(operationActivity.this, patientActivity.class));
            }
        });
        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
        route.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(operationActivity.this,signalActivity.class));
            }
        });

    }

    private void sendEmail() {
        final ProgressDialog dialog = new ProgressDialog(operationActivity.this);
        dialog.setTitle("Sending Email");
        dialog.setMessage("Please wait");
        dialog.show();
        Thread sender = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    EMailSender eMailSender = new EMailSender(mailId, password);
                    eMailSender.sendEmergencyMail();
                    dialog.dismiss();
                    Log.e("mylog", "mail sent");
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        sender.start();
    }
}
