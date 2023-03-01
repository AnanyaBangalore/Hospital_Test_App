package com.example.test;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ECGKafkaProducer {
    public static void main(String[] args) {
        String filePath = "/path/to/mit-bih-arrhythmia-database-1.0.0/csv/100.csv";
        String bootstrapServers = "localhost:9092";
        String topicName = "ecg_data";

        // Set Kafka producer properties
        Properties props = new Properties();
        props.put("bootstrap.servers", bootstrapServers);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        // Create Kafka producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);

        // Read ECG data from CSV file and send to Kafka topic
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
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
            System.out.println("ECG data sent to Kafka topic");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }
    }
}
