package com.example.echanneling_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.muddzdev.styleabletoast.StyleableToast;

public class AppointmentToYourLabTest extends AppCompatActivity {

    String Lab_Tests = "";
    int price_for_lab=0;
    CheckBox cBox,cBox2, cBox3, cBox4, cBox5, cBox6, cBox7, cBox8, cBox9, cBox10, cBox11, cBox12;
    Button click_bookbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_to_your_lab_test);
        getSupportActionBar().setTitle("Appointment To Your Labs");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cBox = findViewById(R.id.cBox);
        cBox2 = findViewById(R.id.cBox2);
        cBox3 = findViewById(R.id.cBox3);
        cBox4 = findViewById(R.id.cBox4);
        cBox5 = findViewById(R.id.cBox5);
        cBox6 = findViewById(R.id.cBox6);
        cBox7 = findViewById(R.id.cBox7);
        cBox8 = findViewById(R.id.cBox8);
        cBox9 = findViewById(R.id.cBox9);
        cBox10 = findViewById(R.id.cBox10);
        cBox11 = findViewById(R.id.cBox11);
        cBox12 = findViewById(R.id.cBox12);

        click_bookbtn = (Button) findViewById(R.id.click_bookbtn);
        click_bookbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPayment();
            }
        });
    }

    public void openPayment(){

        if(cBox.isChecked()){
            price_for_lab += 1000;
            Lab_Tests += cBox.getText().toString();
        }

        if(cBox2.isChecked()){
            price_for_lab += 1000;
            Lab_Tests += cBox2.getText().toString();
        }

        if(cBox3.isChecked()){
            price_for_lab += 1000;
            Lab_Tests += cBox3.getText().toString();
        }

        if(cBox4.isChecked()){
            price_for_lab += 1000;
            Lab_Tests += cBox4.getText().toString();
        }

        if(cBox5.isChecked()){
            price_for_lab += 1000;
            Lab_Tests += cBox5.getText().toString();
        }

        if(cBox6.isChecked()){
            price_for_lab += 1000;
            Lab_Tests += cBox6.getText().toString();
        }

        if(cBox7.isChecked()){
            price_for_lab += 1000;
            Lab_Tests += cBox7.getText().toString();
        }

        if(cBox8.isChecked()){
            price_for_lab += 1000;
            Lab_Tests += cBox8.getText().toString();
        }

        if(cBox9.isChecked()){
            price_for_lab += 1000;
            Lab_Tests += cBox9.getText().toString();
        }

        if(cBox10.isChecked()){
            price_for_lab += 1000;
            Lab_Tests += cBox10.getText().toString();
        }

        if(cBox11.isChecked()){
            price_for_lab += 1000;
            Lab_Tests += cBox11.getText().toString();
        }

        if(cBox12.isChecked()){
            price_for_lab += 1000;
            Lab_Tests += cBox12.getText().toString();
        }

        StyleableToast.makeText(getApplicationContext()," Total price for Selected Labs \n"+price_for_lab,Toast.LENGTH_SHORT,
                R.style.toaststyle).show();
        Toast.makeText(getApplicationContext(),"You selected \n"+Lab_Tests+"\n", Toast.LENGTH_LONG).show();
        Intent intent_lab1 = new Intent(AppointmentToYourLabTest.this,MainActivity.class);
        startActivity(intent_lab1);
    }
}

