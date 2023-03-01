package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin_dashboard extends AppCompatActivity {
    Button doctor_details_entry ;
    Button hospital_details_entry;
    Button back1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
        doctor_details_entry= findViewById(R.id.button6);
        hospital_details_entry=findViewById(R.id.button7);
        back1=(Button)findViewById(R.id.button9);
        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iiiintent = new Intent(Admin_dashboard.this,MainActivity.class);
                startActivity(iiiintent);

            }
        });
        doctor_details_entry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iiintent = new Intent(Admin_dashboard.this, Doctor_entry_details_page.class);
                startActivity(iiintent);
            }
        });
        hospital_details_entry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iiiintent = new Intent(Admin_dashboard.this, Hospital_entry_details_page.class);
                startActivity(iiiintent);

            }
        });

    }
}