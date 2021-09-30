package com.example.sqliteexample;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.doctormanagement.DoctorManagement;
import com.example.doctormanagement.R;

public class SignIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }
//button connecting
    public void openMain3(View view){
        startActivity(new Intent(this, DoctorManagement.class  ));
    }
    public void openMain4(View view){
        startActivity(new Intent(this, Doctor_Home_Page.class  ));
    }


}



