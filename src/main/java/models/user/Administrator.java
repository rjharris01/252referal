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
import java.util.Iterator;
import models.Rating;

/**
 *
 * @author Richard Harris
 */
//stores the administrator user class
public class Administrator extends User {
    //returns doctors ratings
    public ArrayList<Rating> getDoctorRatings(Doctor doctor)
    {
        return doctor.getRatings();
    }
    //retunrs a list of all doctors
    public ArrayList<Doctor> getAllDoctors()
    {
       
      
        String UserId = "D";
        
        
        
        ArrayList<User> users = this.getAllUsers();
        ArrayList<Doctor> doctors = new  ArrayList();
        Iterator itr = users.iterator();
        while (itr.hasNext()) 
        {
            User user = (User)itr.next();
            String userId = user.getUserId();
            if(UserId.charAt(0) != userId.charAt(0))
            {
                itr.remove();    
            }
        }
        
        for(User user: users){
            doctors.add((Doctor)user);
        }
       
        return doctors;
    }
    //returns a list of all secretaries 
     public ArrayList<Secretary> getAllSecretaries()
    {
      
        String UserId = "S";
        
        ArrayList<User> users = this.getAllUsers();
        ArrayList<Secretary> secretaries = new  ArrayList();
        Iterator itr = users.iterator();
        while (itr.hasNext()) 
        {
            User user = (User)itr.next();
            String userId = user.getUserId();
            if(UserId.charAt(0) != userId.charAt(0))
            {
                itr.remove();    
            }

        }
        for(User u: users){
            secretaries.add((Secretary)u);
            }
            
     
        return secretaries;
    }
    //deletes a user
    public void deleteUser(String userID)
     {
         ArrayList<User> users = this.getAllUsers();
         Iterator itr = users.iterator();
         while (itr.hasNext()) 
            {
            User tempUser = (User)itr.next();
            if (tempUser.getUserId().equals(userID))
            {
                itr.remove();
            }
            }
        
          
         try
        {
            FileOutputStream fos = new FileOutputStream("User.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
            oos.close();
            fos.close();
        } 
         
         catch (IOException ioe) 
        {
            ioe.printStackTrace();
        }    
     }
    //gets a list of all users
    
}
