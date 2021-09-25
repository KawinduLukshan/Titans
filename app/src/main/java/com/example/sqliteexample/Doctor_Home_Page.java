package com.example.doctormanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Doctor_Home_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_home_page);
        getSupportActionBar().setTitle("Doctor Home Page");
    }

    public void openMain5(View view){
        startActivity(new Intent(this,SignIn.class  ));
    }
    public void openMain6(View view){ startActivity(new Intent(this,DoctorMainActivity.class  ));}
    public void openMain15(View view){ startActivity(new Intent(this,LevelsOfDoctors.class  ));}
    public void openMain31(View view){ startActivity(new Intent(this,DoctorSchedule.class  )); }


}



