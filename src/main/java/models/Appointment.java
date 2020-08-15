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
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import models.user.Doctor;
import models.user.Patient;

/**
 *
 * @author richa_bfe6tpy
 */
public class Appointment implements Serializable {
    private Patient patient;
    private Doctor doctor;
    private LocalDateTime appointmentDate;
    private int appointmentId;
    private String Comments;
    
    
    public Patient getPatient() { return patient;}
    public void setPatient(Patient newPatient){patient = newPatient;}
    
    public Doctor getDoctor() { return doctor;}
    public void setDoctor(Doctor newDoctor){doctor = newDoctor;}
    
    public LocalDateTime getAppointmentDate() { return appointmentDate;}
    public void setAppointmentDate(LocalDateTime newAppointmentDate){appointmentDate = newAppointmentDate;}
    
    public int getAppointmentId() { return appointmentId;}
    public void setAppointmentId(int newAppointmentId){appointmentId = newAppointmentId;}
    
    public String getComments() { return Comments;}
    public void setComments(String newComments){Comments = newComments;}
    
    
    
    
    
    
    public ArrayList<Appointment>  getAllAppointments()
    {
        ArrayList<Appointment> appointments = new ArrayList<>();
        try {
                        FileInputStream fis = new FileInputStream("Appointments.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
                        appointments = (ArrayList) ois.readObject();
			
			ois.close();
                        fis.close();
                        
            } catch (FileNotFoundException  e) {
			System.out.print("No file \n");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
        return appointments; 
    }
    
    public void writeNewAppointment(Appointment appointment)
    {
         ArrayList<Appointment> appointments;
         appointments = getAllAppointments();
         
         appointments.add(appointment);
         
         try
        {
            FileOutputStream fos = new FileOutputStream("Appointments.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(appointments);
            oos.close();
            fos.close();
        } 
         
         catch (IOException ioe) 
        {
            ioe.printStackTrace();
        }    
    }
}
