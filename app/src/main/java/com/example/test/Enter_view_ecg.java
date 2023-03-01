package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import java.util.Properties;


public class Enter_view_ecg extends AppCompatActivity {
    Button enterecg;
    Button viewecg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_view_ecg);
        enterecg=(Button) findViewById(R.id.enterecg);
        enterecg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iiiintent = new Intent(Enter_view_ecg.this, ECGDataFetcher.class);
                startActivity(iiiintent);
            }
        });
    }
}