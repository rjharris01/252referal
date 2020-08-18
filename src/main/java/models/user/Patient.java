/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.user;

import controllers.RequestMaker;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import models.Rating;
import models.Appointment;
import models.Perscription;
/**
 *
 * @author richa_bfe6tpy
 */
public class Patient extends User {
    
    private String gender;
    private LocalDate birthday;
    private ArrayList<Perscription> Perscriptions = new ArrayList();
    
    public ArrayList<Perscription> getPerscriptions(){return Perscriptions;}
    public void setPerscriptions(ArrayList<Perscription> newPerscription){Perscriptions = newPerscription;}
    
    public String getGender() { return gender;}
    public void setGender(String newGender){gender = newGender;}
    
    public LocalDate getBirthday() { return birthday;}
    public void setBirthday(LocalDate newBirthday){birthday = newBirthday;}
    
    public void addPerscription(Perscription perscription)
    {
        this.Perscriptions.add(perscription);   
        this.updateUser();
    } 
    
    public ArrayList<Appointment>  getAllAppointments()
    {
        ArrayList<Appointment> appointments = new ArrayList<>();
        try {
                        FileInputStream fis = new FileInputStream("Appointments.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
                        appointments = (ArrayList) ois.readObject();
			
			ois.close();
                        fis.close();
                        
                        for (Appointment appointment : appointments){
                            if (!appointment.getPatient().getUserId().equals(this.getUserId()))
                            {
                                appointments.remove(appointment);
                            }
                        }
                        
            } catch (FileNotFoundException  e) {
			System.out.print("No file \n");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
        return appointments; 
    }
    
    public ArrayList<Appointment>  getAllPastAppointments()
    {
        ArrayList<Appointment> appointments = new ArrayList<>();
        ArrayList<Appointment> toRemove = new ArrayList<>();
        try {
                        FileInputStream fis = new FileInputStream("Appointments.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
                        appointments = (ArrayList) ois.readObject();
			
			ois.close();
                        fis.close();
                        
                        for (Appointment appointment : appointments){
                            if (!appointment.getPatient().getUserId().equals(this.getUserId()))
                            {
                                toRemove.add(appointment);
                            }
                            else if (appointment.getAppointmentDate().isAfter(LocalDateTime.now()))
                            {
                                toRemove.add(appointment);
                            }
                        }
                        appointments.removeAll(toRemove);
                        
            } catch (FileNotFoundException  e) {
			System.out.print("No file \n");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
        return appointments; 
    }
    
    public ArrayList<Appointment>  getAllFutureAppointments()
    {
        ArrayList<Appointment> appointments = new ArrayList<>();
        ArrayList<Appointment> toRemove = new ArrayList<>();
        try {
                        FileInputStream fis = new FileInputStream("Appointments.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
                        appointments = (ArrayList) ois.readObject();
			
			ois.close();
                        fis.close();
                        
                        for (Appointment appointment : appointments){
                            if (!appointment.getPatient().getUserId().equals(this.getUserId()))
                            {
                                toRemove.add(appointment);
                            }
                            else if (appointment.getAppointmentDate().isBefore(LocalDateTime.now()))
                            {
                                toRemove.add(appointment);
                            }
                        }
                        appointments.removeAll(toRemove);
                        
            } catch (FileNotFoundException  e) {
			System.out.print("No file \n");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
        return appointments; 
    }
    
    
    public void requestAccountTermination()
    {
         RequestMaker rm = new RequestMaker();
         rm.accountTerminationRequest(this);
    
    }
    
    @Override
    public String toString() {
        return ("Name: " + this.getName() + " ID:" + this.getUserId());
    }
}
