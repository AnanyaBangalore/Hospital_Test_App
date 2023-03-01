package com.example.test;

public class Patient {
    private String name;
    private int age;
    private String hospitalName;
    private int patientNumber;
    private int systolic;
    private int diastolic;

    public Patient() {
        // Required default constructor
    }

    public Patient(String name, int age, String hospitalName, int patientNumber,
                   int systolic, int diastolicS) {
        this.name = name;
        this.age = age;
        this.hospitalName = hospitalName;
        this.patientNumber = patientNumber;
        this.systolic = systolic;
        this.diastolic = diastolic;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public int getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(int patientNumber) {
        this.patientNumber = patientNumber;
    }


    public int getSystolic() {
        return systolic;
    }

    public void setSystolic(int systolic) {
        this.systolic = systolic;
    }

    public int getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(int diastolic) {
        this.diastolic = diastolic;
    }




}

