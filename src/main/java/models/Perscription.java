/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author richa_bfe6tpy
 */


import models.user.Doctor;
import java.io.Serializable;
import models.user.Patient;

import java.io.Serializable;

public class Perscription implements Serializable{
    private int perscriptionId;
    private Medicine medicine;
    private Doctor doctor;
    private Patient patient;
    private String dosage;
    private String note;
    private int quantity;
    
    public int getPerscriptionId() { return perscriptionId;}
    public void setPerscriptionId(int newPerscriptionId){perscriptionId = newPerscriptionId;}
    
    public Medicine getMedicine() { return medicine;}
    public void setMedicine(Medicine newMedicine){medicine = newMedicine;}
    
    public Patient getPatient() { return patient;}
    public void setPatient(Patient newPatient){patient = newPatient;}
    
    public Doctor getDoctor() { return doctor;}
    public void setDoctor(Doctor newDoctor){doctor = newDoctor;}
    
    public String getDosage() { return dosage;}
    public void setDosage(String newDosage){dosage = newDosage;}
    
    public String getNote() { return note;}
    public void setNote(String newNote){note = newNote;}
    
    public int getQuantity() { return quantity;}
    public void setQuantity(int newQuantity){quantity = newQuantity;}
   
    
}

