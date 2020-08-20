/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.user;

import controllers.RequestMaker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import models.Appointment;
import models.Perscription;
/**
 *
 * @author richa_bfe6tpy
 */
//stores the patient user class
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
    //adds a perscription to the users perscription list
    public void addPerscription(Perscription perscription)
    {
        this.Perscriptions.add(perscription);   
        this.updateUser();
    } 
    //deletes a perscription from a user
    public void removePerscription(Perscription perscription){
        ArrayList <Perscription> perscriptions = this.getPerscriptions();
        perscriptions.remove(perscription);
        this.updateUser();
    }
    
    //returns a list of all the users's appointments 
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
    
    //returns a list of all users pass appointments
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
    
    //returns a list of all patients future appointments
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
    
    //returns a list of all doctors 
    public ArrayList<Doctor> getAllDoctors()
    {
        ArrayList<User> tempUsers  = new ArrayList<>();
        ArrayList<Doctor> doctors  = new ArrayList<>();
        try {
                        FileInputStream fis = new FileInputStream("User.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
                        tempUsers = (ArrayList) ois.readObject();
			
			ois.close();
                        fis.close();
                        
            } catch (FileNotFoundException  e) {
			System.out.print("No file \n");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
        for(User u : tempUsers)
        {
            if(u instanceof Doctor)
                doctors.add((Doctor)u);
        }
        return doctors; 
    }
    
    //creates a request for account deletion
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
