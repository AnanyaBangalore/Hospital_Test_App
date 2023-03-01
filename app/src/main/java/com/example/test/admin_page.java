package com.example.test;

import static com.example.test.R.id.editTextAdmin_id;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class admin_page extends AppCompatActivity {
    Button admin_login ;
    EditText admin_id;
    EditText admin_password;
    Editable id;
    Editable password;
    String real_id;
    String real_password;
    TextView Res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);
        admin_id=(EditText) findViewById(R.id.Admin_id);
        admin_password =(EditText) findViewById(R.id.Admin_password);
        real_id="admin";
        real_password="admin123";
        admin_login= findViewById(R.id.button5);



            admin_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(admin_id.getText().toString().equals(real_id) && admin_password.getText().toString().equals(real_password) ) {

                        Intent iintent = new Intent(admin_page.this, Admin_dashboard.class);
                        startActivity(iintent);
                    }
                    else
                    {
                        Intent iintent = new Intent(admin_page.this, Error.class);
                        startActivity(iintent);
                   }


                }
            });





    }
}