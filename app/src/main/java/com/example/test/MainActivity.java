package com.example.test;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    Button admin;
    Button login;
    EditText docid;
    EditText doc_pass1;
    DatabaseReference ref1,ref2;
    String doc_idd, doc_passs;
    DatabaseReference doctorsRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        docid=(EditText) findViewById(R.id.Admin_id);
        doc_pass1=(EditText) findViewById(R.id.Admin_password);
        admin=findViewById(R.id.button);
        login=findViewById(R.id.button5);
        Toast.makeText(MainActivity.this,"Firebase success ",Toast.LENGTH_LONG).show();

        doctorsRef = FirebaseDatabase.getInstance().getReference("Doctor");


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String userId = docid.getText().toString().trim();
                String password = doc_pass1.getText().toString().trim();
                //Toast.makeText(MainActivity.this,password,Toast.LENGTH_LONG).show();



               doctorsRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        boolean isLoginSuccessful = false;

                        for (DataSnapshot doctorDetailsSnapshot : dataSnapshot.getChildren()) {
                            // Get the ID and password of the doctor details node
                            String id = doctorDetailsSnapshot.child("doc_name").getValue(String.class);
                            String doctorPassword = doctorDetailsSnapshot.child("doc_pass").getValue(String.class);
                           //Toast.makeText(MainActivity.this,id+":"+userId+":"+doctorPassword+":"+password,Toast.LENGTH_LONG).show();

                            // Check if the entered ID and password match the current doctor details node
                            if (userId.toString().equals(id.toString()) && password.toString().equals(doctorPassword.toString())) {
                                isLoginSuccessful = true;
                                break;
                            }
                        }

                        if (isLoginSuccessful) {
                            Intent intent = new Intent(MainActivity.this, Doctor_page.class);
                            startActivity(intent);
                        } else {
                            Intent intent = new Intent(MainActivity.this, Error.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Log.d("Firebase", "Database error: " + databaseError.getMessage());
                    }
                });
            }
        });

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,admin_page.class);
                startActivity(intent);
            }
        });
    }
}