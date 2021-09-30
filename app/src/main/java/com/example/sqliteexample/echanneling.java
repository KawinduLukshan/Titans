package com.example.sqliteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class echanneling extends AppCompatActivity {
    
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_echanneling);
    }
    //Channel Doctor button
    //public void openpart1(View view){
      //  Intent intent_openpart1 = new Intent(this,MainActivity.class);
        //startActivity(intent_openpart1);
    }
    //User Management button
    //public void openpart2(View view){
      //  Intent intent_openpart1 = new Intent(this,MainActivity.class);
       // startActivity(intent_openpart1);
    //}
    
    //Pharmacy/Lab button
    //public void openpart1(View view){
      //  Intent intent_openpart3 = new Intent(this,MainActivity.class);
        //startActivity(intent_openpart1);
    }
    
    //Doctor Management button
    public void openMain11(View view){ startActivity(new Intent(this,DoctorManagement.class  )); }

}



