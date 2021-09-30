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

import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.echanneling_system.DataBase.PA_DBHelper;

import java.util.Calendar;

public class Payment extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button visitandpay;
    EditText bankcardno,cvv_no;
    TextView date_picker_2;
    DatePickerDialog.OnDateSetListener setListener2;
    Spinner spinner_bnk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        getSupportActionBar().setTitle("Pay for the Appointment");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        spinner_bnk = findViewById(R.id.bank_spinner);
        ArrayAdapter<CharSequence> adapter_bnk = ArrayAdapter.createFromResource(this,R.array.banks,R.layout.myselected_item);
        adapter_bnk.setDropDownViewResource(R.layout.mydropdown_item);
        spinner_bnk.setAdapter(adapter_bnk);
        spinner_bnk.setOnItemSelectedListener(this);

        bankcardno = findViewById(R.id.bankcard_no);
        cvv_no = findViewById(R.id.cvv_no);
        date_picker_2=findViewById(R.id.date_picker_2);

        Calendar calendar=Calendar.getInstance();
        final int year =calendar.get(Calendar.YEAR);
        final int month =calendar.get(Calendar.MONTH);
        final int day =calendar.get(Calendar.DAY_OF_MONTH);

        date_picker_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog =new DatePickerDialog(Payment.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        setListener2,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListener2 =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month=month+1;
                String date_1=day+"/"+month+"/"+year;
                date_picker_2.setText(date_1);
            }
        };

        visitandpay = (Button)findViewById(R.id.visitandpay);
        visitandpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogMsg1();
            }
        });
    }

    public void openDialogMsg1(){
        DiologA dialogA =new DiologA();
        dialogA.show(getSupportFragmentManager(),"Alerts");
        Intent intent_dialogmsg =new Intent(this,MainActivity.class);
        startActivity(intent_dialogmsg);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text =parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) { }

    public void SavePayment(View view) {
        PA_DBHelper payhelper = new PA_DBHelper(this);
        payhelper.appointmentpayment(spinner_bnk.getItemAtPosition(spinner_bnk.getSelectedItemPosition()).toString(), bankcardno.getText().toString(), cvv_no.getText().toString(), date_picker_2.getText().toString());

        String cardno = bankcardno.getText().toString();
        String cvvno = cvv_no.getText().toString();

        if (TextUtils.isEmpty(cardno) && TextUtils.isEmpty(cvvno)) {
            Toast.makeText(this, "Data Successfully inserted",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Data Successfully inserted",Toast.LENGTH_SHORT).show();
            Intent intent_i = new Intent(Payment.this, MainActivity.class);
            startActivity(intent_i);
        }
    }
}
