package com.example.test;

import android.widget.EditText;

public class Hospital {



    private String hos_name;
     private String hos_add;
     private String hos_em_contact_nos;
    public Hospital() {
    }

    public String getHos_name() {
        return hos_name;
    }

    public void setHos_name(String hos_name) {
        this.hos_name = hos_name;
    }

    public String getHos_add() {
        return hos_add;
    }

    public void setHos_add(String hos_add) {
        this.hos_add = hos_add;
    }

    public String getHos_em_contact_nos() {
        return hos_em_contact_nos;
    }

    public void  setHos_em_contact_nos(String hos_em_contact_nos) {
        this.hos_em_contact_nos = hos_em_contact_nos;
    }
}
