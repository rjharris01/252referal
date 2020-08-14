/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import models.user.Patient;
import models.user.Doctor;
import java.io.Serializable;

/**
 *
 * @author Richard Harris
 */
public class Rating implements Serializable {
    private Patient patient;
    private Doctor doctor;
    private Appointment appointment;
    private String rating;
    
    public Patient getPatient() { return patient;}
    public void setPatient(Patient newPatient){patient = newPatient;}
    
    public Doctor getDoctor() { return doctor;}
    public void setDoctor(Doctor newDoctor){doctor = newDoctor;}
    
    public Appointment getAppointment() { return appointment;}
    public void setAppointment(Appointment newAppointment){appointment = newAppointment;} 
    
    public String getRating() { return rating;}
    public void setRating(String newRating){rating = newRating;}
    
}
