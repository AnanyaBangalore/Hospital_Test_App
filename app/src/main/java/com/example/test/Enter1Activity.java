package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Enter1Activity extends AppCompatActivity {

    private EditText patientNameEditText, patientAgeEditText, hospitalNameEditText,
            patientNumberEditText, heartRateEditText, patientIdEditText, heartRateSecEditText,
            systolicEditText, diastolicEditText, spo2EditText;
    private Button saveButton;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter1);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Patients");

        patientNameEditText = findViewById(R.id.patient_name_edittext);
        patientAgeEditText = findViewById(R.id.patient_age_edittext);
        hospitalNameEditText = findViewById(R.id.hospital_name_edittext);
        //patientNumberEditText = findViewById(R.id.patient_number_edittext);
        //systolicEditText = findViewById(R.id.systolic_measures_edittext);
        //diastolicEditText = findViewById(R.id.diastolic_measures_edittext);


        saveButton = findViewById(R.id.save_button123);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String patientName = patientNameEditText.getText().toString();
                int patientAge = Integer.parseInt(patientAgeEditText.getText().toString());
                String hospitalName = hospitalNameEditText.getText().toString();
                int patientNumber = Integer.parseInt(patientNumberEditText.getText().toString());

                int systolic = Integer.parseInt(systolicEditText.getText().toString());
                int diastolic = Integer.parseInt(diastolicEditText.getText().toString());


                Patient patient = new Patient(patientName, patientAge, hospitalName, patientNumber, systolic, diastolic);
                databaseReference.push().setValue(patient);
            }
        });
    }
}