package com.example.sqliteexample;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DoctorMainActivity extends AppCompatActivity {

    EditText editText_name,editText_email,editText_hospital,editText_specialization,editText_contactnumber;
    Button button_add,button_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor_activity_main);

        editText_name = findViewById(R.id.edittext_name);
        editText_email = findViewById(R.id.edittext_email);
        editText_hospital = findViewById(R.id.edittext_hospital);
        editText_specialization = findViewById(R.id.edittext_specialization);
        editText_contactnumber = findViewById(R.id.edittext_contactnumber);



        button_add = findViewById(R.id.button_add);
        button_view = findViewById(R.id.button_view);


        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringName = editText_name.getText().toString();
                String stringEmail = editText_email.getText().toString();
                String stringHospital = editText_hospital.getText().toString();
                String stringSpecialization = editText_specialization.getText().toString();
                String stringContactnumber = editText_contactnumber.getText().toString();





                if (stringName.length() <=0 || stringEmail.length() <=0 ||stringHospital.length() <=0 || stringSpecialization.length() <=0 || stringContactnumber.length() <=0){
                    Toast.makeText(DoctorMainActivity.this, "Enter All Data", Toast.LENGTH_SHORT).show();
                }else {
                    DatabaseHelperConnectClass databaseHelperClass = new DatabaseHelperConnectClass(DoctorMainActivity.this);
                    DoctorModelClass doctorModelClass = new DoctorModelClass(stringName,stringEmail,stringHospital,stringSpecialization,stringContactnumber);
                    databaseHelperClass.addDoctor(doctorModelClass);
                    Toast.makeText(DoctorMainActivity.this, "Add Doctor Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });


        button_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DoctorMainActivity.this, ViewDoctorActivity.class);
                startActivity(intent);
            }
        });




    }
    public void openMain2(View view){
        startActivity(new Intent(this,Doctor_Home_Page.class  ));
    }
    public void openMain18(View view){
        startActivity(new Intent(this,Doctor_Home_Page.class  ));
    }




}
