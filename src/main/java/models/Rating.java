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
    
    
    
     public ArrayList<Rating>  getAllRatings()
    {
        ArrayList<Rating> ratings = new ArrayList<>();
        try {
                        FileInputStream fis = new FileInputStream("Ratings.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
                        ratings = (ArrayList) ois.readObject();
			
			ois.close();
                        fis.close();
                        
            } catch (FileNotFoundException  e) {
			System.out.print("No file \n");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
        return ratings; 
    }
    
    public void writeNewRating(Rating rating)
    {
         ArrayList<Rating> ratings;
         ratings = getAllRatings();
         
         ratings.add(rating);
         
         try
        {
            FileOutputStream fos = new FileOutputStream("Ratings.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ratings);
            oos.close();
            fos.close();
        } 
         
         catch (IOException ioe) 
        {
            ioe.printStackTrace();
        }    
    }
    
}

