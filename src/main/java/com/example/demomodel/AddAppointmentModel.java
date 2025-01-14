package com.example.demomodel;

import com.patientAppointmentBookingSystem.entity.Doctor;
import com.patientAppointmentBookingSystem.entity.Patient;

import javax.validation.constraints.Size;
import java.util.Date;


public class AddAppointmentModel {
    private Date date;

    private long type;

    @Size(max = 256, message = "Invalid description length")
    private String description;

    private Patient patient;

    private Doctor doctor;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}