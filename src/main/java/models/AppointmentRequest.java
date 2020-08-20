/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Richard Harris
 */
//stores the appointment request class
public class AppointmentRequest extends Appointment implements Serializable {
    private String type;
    public String getType() { return type;}
    public void setType(String newType){type = newType;}
    
    //method to approve an appointment request
    public void approveRequest(AppointmentRequest appointmentRequest) 
    {
         Appointment appointment = (Appointment)appointmentRequest; 
         writeNewAppointment(appointment);
         deleteRequest(appointmentRequest);
    }
    
    //method to decline an appointment request
    public void declineRequest(AppointmentRequest appointmentRequest)
    {
       deleteRequest(appointmentRequest);
    }
    
    //method to create a new appointment request
    public void newAppointmentRequest(AppointmentRequest appointmentRequest)
    {
            AppointmentRequest tempRequest;
            tempRequest = appointmentRequest;
            tempRequest.setType("newAppointmentRequest");
            tempRequest.setAppointmentId(getNextAppointmentId());
            
            addAppointmentRequest(tempRequest);
    }
    
    
    //method to add an appointment requests to appointment requests
    public void addAppointmentRequest(AppointmentRequest appointmentRequest)
    {
         ArrayList<AppointmentRequest> appointmentRequests;
         appointmentRequests = getAllAppointmentRequests();
         
         appointmentRequests.add(appointmentRequest);
         
         try
        {
            FileOutputStream fos = new FileOutputStream("AppointmentRequests.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(appointmentRequests);
            oos.close();
            fos.close();
        } 
         
         catch (IOException ioe) 
        {
        }   
    }
    
    //method to return all appointment requests currently stored
    public ArrayList<AppointmentRequest>  getAllAppointmentRequests()
    {
        ArrayList<AppointmentRequest> appointments = new ArrayList<>();
        try {
                        FileInputStream fis = new FileInputStream("AppointmentRequests.ser");
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
    
    //returns the next available appointment id
    public int getNextAppointmentId() {
        ArrayList<AppointmentRequest> tempAppointments;
        int appointmentId = 0;
        
        
        tempAppointments = getAllAppointmentRequests();
        
        try {
                AppointmentRequest e = tempAppointments.get(tempAppointments.size() - 1);
                appointmentId = e.getAppointmentId();
                appointmentId = appointmentId + 1;
            }
            
            catch  (IndexOutOfBoundsException e){
                    System.out.print("No enteries \n");  
            }
        return appointmentId;
    }
    
    //deletes appointment request from request file
    public void deleteRequest(AppointmentRequest appointmentRequest)
    {
        Iterator<AppointmentRequest> it = getAllAppointmentRequests().iterator();
        ArrayList<AppointmentRequest> appointmentRequests;
        appointmentRequests = new ArrayList();
        
        while (it.hasNext()) {
            AppointmentRequest tempAppointmentRequest = it.next();
            if (tempAppointmentRequest.getAppointmentId() != (appointmentRequest.getAppointmentId())) 
            {
                appointmentRequests.add(tempAppointmentRequest);
            }
        try
        {
            
            FileOutputStream fos = new FileOutputStream("AppointmentRequests.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(appointmentRequests);
            oos.close();
            fos.close();
        } 
         
         catch (IOException ioe) 
        {
            //
        }   
        }
        
        if (appointmentRequests.isEmpty())
        {
            File file = new File("AppointmentRequests.ser");
            file.delete();  
        }
    }
    
    @Override
    public String toString() {
        return ("Doctor: " + this.getDoctor() + " Patient:" + this.getPatient() + this.getAppointmentId());
    }
}
