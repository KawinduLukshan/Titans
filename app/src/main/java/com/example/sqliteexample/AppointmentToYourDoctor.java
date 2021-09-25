package com.example.echanneling_system;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class AppointmentToYourDoctor extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button search_abtn;
    TextView datepicker1;
    DatePickerDialog.OnDateSetListener setListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment_to_your_doctor);
        getSupportActionBar().setTitle("Appointment To Your Doctor");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Spinner spinner = findViewById(R.id.docspinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.dname,R.layout.myselected_item);
        adapter.setDropDownViewResource(R.layout.mydropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Spinner spinner2 = findViewById(R.id.specializationspinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.specialization,R.layout.myselected_item);
        adapter2.setDropDownViewResource(R.layout.mydropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        Spinner spinner3 = findViewById(R.id.hospitalspinner);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,R.array.hospital,R.layout.myselected_item);
        adapter3.setDropDownViewResource(R.layout.mydropdown_item);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(this);

        datepicker1=findViewById(R.id.datepicker1);

        Calendar calendar=Calendar.getInstance();
        final int year =calendar.get(Calendar.YEAR);
        final int month =calendar.get(Calendar.MONTH);
        final int day =calendar.get(Calendar.DAY_OF_MONTH);

        datepicker1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog =new DatePickerDialog(AppointmentToYourDoctor.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListener =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month+1;
                String date=day+"/"+month+"/"+year;
                datepicker1.setText(date);
            }
        };


        search_abtn = (Button)findViewById(R.id.search_abtn);
        search_abtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 =new Intent(AppointmentToYourDoctor.this,SelectedDetails.class);
                intent3.putExtra("spinnervalue",spinner.getSelectedItem().toString());
                intent3.putExtra("spinnervalue2",spinner2.getSelectedItem().toString());
                intent3.putExtra("spinnervalue3",spinner3.getSelectedItem().toString());
                startActivity(intent3);
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text =parent.getItemAtPosition(position).toString();
       // Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) { }
}