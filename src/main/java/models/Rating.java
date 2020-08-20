/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import models.user.Patient;
import models.user.Doctor;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Richard Harris
 */
//stores the rating class
public class Rating implements Serializable {
    private Patient patient;
    private Doctor doctor;
    private Appointment appointment;
    private int rating;
    private String comment;
    
    public Patient getPatient() { return patient;}
    public void setPatient(Patient newPatient){patient = newPatient;}
    
    public Doctor getDoctor() { return doctor;}
    public void setDoctor(Doctor newDoctor){doctor = newDoctor;}
    
    public Appointment getAppointment() { return appointment;}
    public void setAppointment(Appointment newAppointment){appointment = newAppointment;} 
    
    public int getRating() { return rating;}
    public void setRating(int newRating){rating = newRating;}
    
    public String getComments() { return comment;}
    public void setComments(String newComment){comment = newComment;}
  
    @Override
    public String toString() {
        return ("DR." + this.getDoctor().getName() + "  Rating:" + this.getRating() + "  Comment:" + this.getComments());
    }
}
