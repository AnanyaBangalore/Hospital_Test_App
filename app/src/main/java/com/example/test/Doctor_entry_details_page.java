package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Doctor_entry_details_page extends AppCompatActivity {
    EditText doc_name;
    EditText doc_hos_name;
    EditText doc_pass;
    Button savee;
    DatabaseReference reff;
    Doctor doctor;
    Button backk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_entry_details_page);
        doc_name=(EditText) findViewById(R.id.doctorname);
        doc_hos_name=(EditText) findViewById(R.id.hospitalname);
        doc_pass=(EditText) findViewById(R.id.doctorpass);
        savee=(Button) findViewById(R.id.savee12);
        backk=(Button)findViewById(R.id.backkkk);
        doctor=new Doctor();
        reff= FirebaseDatabase.getInstance().getReference().child("Doctor");
        savee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String doc_namee= doc_name.getText().toString();
                String doc_hos_namee=doc_hos_name.getText().toString();
                String doc_passs=doc_pass.getText().toString();
                doctor.setDoc_name(doc_namee);
                doctor.setDoc_hos_name(doc_hos_namee);
                doctor.setDoc_pass(doc_passs);

                reff.push().setValue(doctor);
                Toast.makeText(Doctor_entry_details_page.this, "Success-Hospital", Toast.LENGTH_SHORT).show();




            }
        });
        backk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iiiintent = new Intent(Doctor_entry_details_page.this, Admin_dashboard.class);
                startActivity(iiiintent);
            }
        });
    }
}