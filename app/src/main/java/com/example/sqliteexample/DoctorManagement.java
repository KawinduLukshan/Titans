package com.example.doctormanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DoctorManagement extends AppCompatActivity {

    private Object Doctor_Home_Page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_management);
        getSupportActionBar().setTitle("Doctor Management");
    }
    public void openMain2(View view){ startActivity(new Intent(this,SignIn.class  )); }
    public void openMain12(View view){ startActivity(new Intent(this,echanneling.class  )); }


}


