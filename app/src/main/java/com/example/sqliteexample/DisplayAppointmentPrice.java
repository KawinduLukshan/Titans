package com.example.echanneling_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class DisplayAppointmentPrice extends AppCompatActivity {

    EditText labnames1, totalpriceresult;

    String labnames_1;
    int totalpriceresult_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_appointment_price);
        getSupportActionBar().setTitle("Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        labnames1 = (EditText)findViewById(R.id.labnames1);
        totalpriceresult = (EditText)findViewById(R.id.totalpriceresult);

        Intent intent_l = getIntent();
        labnames_1 = intent_l.getStringExtra("yourselectedlabs");
        labnames1.setText(labnames_1);

        Intent intent_lprice = getIntent();
        totalpriceresult_1 = intent_lprice.getIntExtra("totpricelab",0);
        totalpriceresult.setText(totalpriceresult_1);


    }
}