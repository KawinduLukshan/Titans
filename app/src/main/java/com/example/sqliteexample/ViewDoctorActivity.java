package com.example.doctormanagement;



import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class ViewDoctorActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_doctor);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        DatabaseHelperConnectClass databaseHelperClass = new DatabaseHelperConnectClass(this);
        List<DoctorModelClass> doctorModelClasses = databaseHelperClass.getDoctorList();

        if (doctorModelClasses.size() > 0){
            DoctorAdapterClass doctoradapterclass = new DoctorAdapterClass(doctorModelClasses, ViewDoctorActivity.this);
            recyclerView.setAdapter(doctoradapterclass);
        }else {
            Toast.makeText(this, "There is no doctor in the database", Toast.LENGTH_SHORT).show();
        }


    }
    public void openMain9(View view){
        startActivity(new Intent(this,Doctor_Home_Page.class  ));
    }

}


