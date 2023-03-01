package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Hospital_entry_details_page extends AppCompatActivity {
    EditText hos_name;
    EditText hos_add;
    EditText hos_em_contact_nos;
    Button save;
    DatabaseReference ref;
    Hospital hospital;
    Button back;



    @SuppressLint("WrongViewCast")
    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_entry_details_page);
        hos_name=(EditText) findViewById(R.id.hos_name);
        hos_add=(EditText) findViewById(R.id.hospitaladdress);
        hos_em_contact_nos=(EditText) findViewById(R.id.hoscontact);
        save=(Button) findViewById(R.id.save);
        back=(Button)findViewById(R.id.back);
        hospital=new Hospital();
        ref=FirebaseDatabase.getInstance().getReference().child("Hospital");
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hos_namee= hos_name.getText().toString();
                String hos_addd=hos_add.getText().toString();
                String hos_em_contact_noss=hos_em_contact_nos.getText().toString();
                hospital.setHos_name(hos_namee);
                hospital.setHos_add(hos_addd);
                hospital.setHos_em_contact_nos(hos_em_contact_noss);
                ref.push().setValue(hospital);
                Toast.makeText(Hospital_entry_details_page.this, "Success-Hospital", Toast.LENGTH_SHORT).show();




            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iiiintent = new Intent(Hospital_entry_details_page.this, Admin_dashboard.class);
                startActivity(iiiintent);
            }
        });














    }
}