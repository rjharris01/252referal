/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.user;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import models.Appointment;
import models.Medicine;
import models.Rating;

/**
 *
 * @author richa_bfe6tpy
 */
public class Doctor extends User {
    
    private ArrayList<Rating> ratings = new ArrayList();
    
    public ArrayList<Doctor>  getAllDoctors()
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
    
    public ArrayList<Patient> getAllPatients()
    {
        ArrayList<User> tempUsers  = new ArrayList<>();
        ArrayList<Patient> patients  = new ArrayList<>();
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
            if(u instanceof Patient)
                patients.add((Patient)u);
        }
        return patients; 
    }


    public ArrayList<Rating> getRatings() { return ratings;}
    public void setRatings(ArrayList<Rating> newRatings){ratings = newRatings;}
    
    public void addRating(Rating rating)
    {
        this.ratings.add(rating);   
        this.updateDoctor();
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
                            if (!appointment.getDoctor().getUserId().equals(this.getUserId()))
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
    
    public void updateDoctor()
    {
        int index = 0;
        ArrayList<User> tempUsers  = new ArrayList<>();
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
        
        
        for(int k = 0; k < tempUsers.size(); k++) {
        if(tempUsers.get(k).getUserId().equals(this.getUserId())) {
            index = k;
            }
        }
        tempUsers.set(index, this);
        
        try
        {
            FileOutputStream fos = new FileOutputStream("User.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(tempUsers);
            oos.close();
            fos.close();
        } 
         
         catch (IOException ioe) 
        {
            ioe.printStackTrace();
        }    
     }
    
    public ArrayList<Medicine>  getAllMedicine()
    {
        ArrayList<Medicine> medicines = new ArrayList<>();
        try {
                        FileInputStream fis = new FileInputStream("Medicines.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
                        medicines = (ArrayList) ois.readObject();
			
			ois.close();
                        fis.close();
                        
            } catch (FileNotFoundException  e) {
			System.out.print("No file \n");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
        return medicines; 
     }
    
    @Override
    public String toString() {
        return ("DR." + this.getName() + " ID:" + this.getUserId());
    }
    
}
