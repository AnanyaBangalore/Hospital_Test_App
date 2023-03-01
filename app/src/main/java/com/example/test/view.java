package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class view extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        // Assume that you have a reference to the Firebase Realtime Database
        DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference();

// Assume that you have a patient ID for the patient whose data you want to display
        String patientId = "patient123";

// Assume that you have a TextView for each patient information field
        TextView patientNameTextView = findViewById(R.id.patient_name_text_view);
        TextView patientAgeTextView = findViewById(R.id.patient_age_text_view);
        TextView hospitalNameTextView = findViewById(R.id.hospital_name_text_view);
        TextView patientNumberTextView = findViewById(R.id.patient_number_text_view);
        TextView systolicTextView = findViewById(R.id.systolic_text_view);
        TextView diastolicTextView = findViewById(R.id.diastolic_text_view);

// Create a DatabaseReference for the patient's data in the database
        DatabaseReference patientRef = databaseRef.child("patients").child(patientId);

// Attach a ValueEventListener to the patientRef to read the patient's data from the database
        patientRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get the Patient object from the snapshot
                Patient patient = dataSnapshot.getValue(Patient.class);

                // Set the TextViews to display the patient information
                patientNameTextView.setText(patient.getName());
                patientAgeTextView.setText(patient.getAge());
                hospitalNameTextView.setText(patient.getHospitalName());
                patientNumberTextView.setText(patient.getPatientNumber());
                systolicTextView.setText(patient.getSystolic());
                diastolicTextView.setText(patient.getDiastolic());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle the error
            }
        });

    }
}