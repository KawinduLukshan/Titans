package com.example.sqliteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.example.echanneling_system.DataBase.PA_DBHelper;

import java.util.Calendar;

public class ChannelYourDoctor extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView sel_date3;
    EditText sel_pname,sel_age,sel_nic,sel_contactno;
    DatePickerDialog.OnDateSetListener setListener3;
    Spinner sel_doctorname,sel_hospital;
    ArrayAdapter<CharSequence> adapter_4,adapter_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_channel_your_doctor);
        getSupportActionBar().setTitle("Channel Your Doctor");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        sel_pname =findViewById(R.id.sel_pname);
        sel_age =findViewById(R.id.sel_age);
        sel_nic =findViewById(R.id.sel_nic);
        sel_contactno =findViewById(R.id.sel_contactno);

        sel_doctorname = findViewById(R.id.sel_doctorname);
        adapter_4 = ArrayAdapter.createFromResource(this,R.array.dname,R.layout.myselected_item2);
        adapter_4.setDropDownViewResource(R.layout.mydropdown_item);
        sel_doctorname.setAdapter(adapter_4);
        sel_doctorname.setOnItemSelectedListener(this);

        sel_hospital = findViewById(R.id.sel_hospital);
        adapter_5 = ArrayAdapter.createFromResource(this,R.array.hospital,R.layout.myselected_item2);
        adapter_5.setDropDownViewResource(R.layout.mydropdown_item);
        sel_hospital.setAdapter(adapter_5);
        sel_hospital.setOnItemSelectedListener(this);

        sel_date3=findViewById(R.id.sel_date3);

        Calendar calendar=Calendar.getInstance();
        final int year =calendar.get(Calendar.YEAR);
        final int month =calendar.get(Calendar.MONTH);
        final int day =calendar.get(Calendar.DAY_OF_MONTH);

        sel_date3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog =new DatePickerDialog(ChannelYourDoctor.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        setListener3,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListener3 =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month+1;
                String date=day+"/"+month+"/"+year;
                sel_date3.setText(date);
            }
        };
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text =parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) { }

    public void SavePAppointment(View view){
        PA_DBHelper paDbHelper = new PA_DBHelper(this);
        paDbHelper.addappointment(sel_pname.getText().toString(), sel_age.getText().toString(), sel_nic.getText().toString(),
                sel_contactno.getText().toString(), sel_date3.getText().toString(), sel_doctorname.getItemAtPosition(sel_doctorname.getSelectedItemPosition()).toString(), sel_hospital.getItemAtPosition(sel_hospital.getSelectedItemPosition()).toString());

        String c_name = sel_pname.getText().toString();
        String c_age = sel_age.getText().toString();
        String c_nic =sel_nic.getText().toString();
        String c_phone =sel_contactno.getText().toString();

        if(TextUtils.isEmpty(c_name) && TextUtils.isEmpty(c_age) && TextUtils.isEmpty(c_nic) && TextUtils.isEmpty(c_phone)){
            Toast.makeText(this,"Not inserted successfully",Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(this,"Data Successfully inserted",Toast.LENGTH_SHORT).show();
            Intent intent5 =new Intent(ChannelYourDoctor.this,ConfirmationAppointment.class);
            intent5.putExtra("spinnervalue5",sel_hospital.getSelectedItem().toString());
            intent5.putExtra("spinnervalue4",sel_doctorname.getSelectedItem().toString());
            intent5.putExtra("date1",sel_date3.getText().toString());
            intent5.putExtra("editv1",sel_pname.getText().toString());
            intent5.putExtra("editv2",sel_age.getText().toString());
            intent5.putExtra("editv3",sel_nic.getText().toString());
            intent5.putExtra("editv4",sel_contactno.getText().toString());
            startActivity(intent5);
        }
    }
}
