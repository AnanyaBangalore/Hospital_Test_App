package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.AsyncTask;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class ECGDataFetcher extends AsyncTask<Void, Void, Void> {
    private static final String TAG = "ECGDataFetcher";

    private String bootstrapServers;
    private String topicName;
    private ECGDataFetcherListener listener;

    public ECGDataFetcher(String bootstrapServers, String topicName, ECGDataFetcherListener listener) {
        this.bootstrapServers = bootstrapServers;
        this.topicName = topicName;
        this.listener = listener;
    }

    @Override
    protected Void doInBackground(Void... params) {
        // Set Kafka producer properties
        Properties props = new Properties();
        props.put("bootstrap.servers", bootstrapServers);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // Create Kafka producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        try {
            // Read ECG data from CSV file and send to Kafka topic
            URL url = new URL("https://physionet.org/files/mitdb/1.0.0/100.csv");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                // Skip header row
                if (line.startsWith("#")) {
                    continue;
                }
                // Split comma-separated values
                String[] values = line.split(",");
                // Extract ECG signal value and timestamp
                String ecgValue = values[1];
                String timestamp = values[0];
                // Create Kafka producer record
                ProducerRecord<String, String> record = new ProducerRecord<>(topicName, timestamp, ecgValue);
                // Send record to Kafka topic
                producer.send(record);
            }
            in.close();
        } catch (IOException e) {
            Log.e(TAG, "Error fetching ECG data", e);
        } finally {
            producer.close();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        if (listener != null) {
            listener.onECGDataFetched();
        }
    }

    public interface ECGDataFetcherListener {
        void onECGDataFetched();
    }
}
