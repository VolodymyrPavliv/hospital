package ua.mushroom.hospital.entities;

import java.sql.Date;

public class Record {
    private int id;
    private int patient_id;
    private int doctor_id;
    private int nurse_id;
    private Date entry_date;
    private Date discharge_date;
    private String initial_diagnosis;
    private String final_diagnosis;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public int getNurse_id() {
        return nurse_id;
    }

    public void setNurse_id(int nurse_id) {
        this.nurse_id = nurse_id;
    }

    public Date getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(Date entry_date) {
        this.entry_date = entry_date;
    }

    public Date getDischarge_date() {
        return discharge_date;
    }

    public void setDischarge_date(Date discharge_date) {
        this.discharge_date = discharge_date;
    }

    public String getInitial_diagnosis() {
        return initial_diagnosis;
    }

    public void setInitial_diagnosis(String initial_diagnosis) {
        this.initial_diagnosis = initial_diagnosis;
    }

    public String getFinal_diagnosis() {
        return final_diagnosis;
    }

    public void setFinal_diagnosis(String final_diagnosis) {
        this.final_diagnosis = final_diagnosis;
    }
}
