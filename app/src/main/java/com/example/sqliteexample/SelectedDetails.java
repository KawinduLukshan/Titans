 package com.example.sqliteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

 public class SelectedDetails extends AppCompatActivity {
     TextView cdn_result;
     TextView csp_result;
     TextView ch_result;

     String cdn_r;
     String csp_r;
     String host_r ;
     Button channelbtn;
     @Override
    protected void onCreate(Bundle savedInstanceState) {

         super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_details);
        getSupportActionBar().setTitle("Selected Doctor Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cdn_result =(TextView)findViewById(R.id.cdn_result);
        Intent intent_cdn = getIntent();
        cdn_r = intent_cdn.getStringExtra("spinnervalue");
        cdn_result.setText(cdn_r);

        csp_result =(TextView)findViewById(R.id.csp_result);
        Intent intent_csp = getIntent();
        csp_r = intent_csp.getStringExtra("spinnervalue2");
        csp_result.setText(csp_r);

        ch_result =(TextView)findViewById(R.id.ch_result);
        Intent intenttvh = getIntent();
        host_r = intenttvh.getStringExtra("spinnervalue3");
        ch_result.setText(host_r);

        channelbtn = (Button)findViewById(R.id.channelbtn);
        channelbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChannel();

            }
        });
    }
    public void openChannel(){
        Intent intent4 =new Intent(this, ChannelYourDoctor.class);
        startActivity(intent4);
    }
}
