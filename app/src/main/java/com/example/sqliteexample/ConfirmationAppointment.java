package com.example.sqliteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sqliteexample.DataBase.PA_DBHelper;

public class ConfirmationAppointment extends AppCompatActivity {

    EditText cpn_result,pa_result,pno_result,display_dresult,cpnic_result;
    TextView cadoctor_result,ahospital_result;
    String cpname,c_page,pphone,docc,hosp,seldate,nic_n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_appointment);
        getSupportActionBar().setTitle("Confirm the Appointment Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            cpn_result = (EditText) findViewById(R.id.cpn_result);
            Intent cpn_intent = getIntent();
            cpname = cpn_intent.getStringExtra("editv1");
            cpn_result.setText(cpname);

            pa_result= (EditText) findViewById(R.id.pa_result);
            Intent cpintent = getIntent();
            c_page = cpintent.getStringExtra("editv2");
            pa_result.setText(c_page);

            pno_result= (EditText) findViewById(R.id.pno_result);
            Intent pno_intent = getIntent();
            pphone = pno_intent.getStringExtra("editv4");
            pno_result.setText(pphone);

            cadoctor_result = (TextView) findViewById(R.id.cadoctor_result);
            Intent intent_d = getIntent();
            docc = intent_d.getStringExtra("spinnervalue4");
            cadoctor_result.setText(docc);

            ahospital_result = (TextView) findViewById(R.id.ahospital_result);
            Intent intent_h = getIntent();
            hosp = intent_h.getStringExtra("spinnervalue5");
            ahospital_result.setText(hosp);

            display_dresult = (EditText) findViewById(R.id.display_dresult);
            Intent intent_date = getIntent();
            seldate = intent_date.getStringExtra("date1");
            display_dresult.setText(seldate);

            cpnic_result = (EditText) findViewById(R.id.cpnic_result);
            Intent intent_nic = getIntent();
            nic_n = intent_nic.getStringExtra("editv3");
            cpnic_result.setText(nic_n);

        Button ca_okbtn = (Button)findViewById(R.id.ca_okbtn);
        ca_okbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppointmentPayment();
            }
        });
    }
    public void  AppointmentPayment(){
        Intent intent9 =new Intent(this, Payment.class);
        Toast.makeText(this,"Do your Payments now....",Toast.LENGTH_LONG).show();
        startActivity(intent9);
    }

    public void UpdatePAppointment(View view){
        PA_DBHelper paDbHelper = new PA_DBHelper(this);

        long val1 = paDbHelper.updateappointment(cpn_result.getText().toString(), pa_result.getText().toString(),
                cpnic_result.getText().toString(), pno_result.getText().toString(), display_dresult.getText().toString());

        String name = cpn_result.getText().toString();
        String age = pa_result.getText().toString();
        String nic =cpnic_result.getText().toString();
        String phone =pno_result.getText().toString();
        String date =display_dresult.getText().toString();

        if(TextUtils.isEmpty(name) && TextUtils.isEmpty(age) && TextUtils.isEmpty(nic) && TextUtils.isEmpty(phone) && TextUtils.isEmpty(date)){
           Toast.makeText(this,"Data not Updated",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"Data Updated Successfully",Toast.LENGTH_SHORT).show();
        }
    }

    public void DeletePAppointment(View view){
        PA_DBHelper pDbHelper = new PA_DBHelper(this);
        pDbHelper.deleteappointment(cpn_result.getText().toString());
        Toast.makeText(this,cpn_result.getText().toString()+ "Deleted successfully ", Toast.LENGTH_SHORT).show();

    }






}
