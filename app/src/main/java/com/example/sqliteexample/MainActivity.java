package com.example.echanneling_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button apt_btn1;
    private Button apt_btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Do your Appointment");

        apt_btn1 = findViewById(R.id.apt_btn1);
        apt_btn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openAppointment();
            }
        });

        apt_btn2 = findViewById(R.id.apt_btn2);
        apt_btn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openLabAppointment();
            }
        });
    }
    public void openAppointment(){
        Intent intent_op = new Intent(this,AppointmentToYourDoctor.class);
        startActivity(intent_op);
    }

    public void openLabAppointment(){
        Intent intent_ol = new Intent(this,AppointmentToYourLabTest.class);
        startActivity(intent_ol);
    }
}