package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Doctor_page extends AppCompatActivity {
    Button pat_details;
    Button ECG;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_page);
        pat_details=(Button)findViewById(R.id.pat_dett);
        ECG=(Button)findViewById(R.id.ecg) ;

        pat_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iiiintent = new Intent(Doctor_page.this, PatientDetails_page.class);
                startActivity(iiiintent);
            }
        });
        ECG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iiiintent = new Intent(Doctor_page.this, Enter_view_ecg.class);
                startActivity(iiiintent);

            }
        });


    }
}