/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.user;



import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import models.Rating;

/**
 *
 * @author Richard Harris
 */
public class Administrator extends User {
    public ArrayList<Rating> getDoctorRatings(Doctor doctor)
    {
        return doctor.getRatings();
    }
    
    public DefaultListModel<User> getAllDoctors()
    {
    DefaultListModel<User> model = new DefaultListModel<>();
      
        String UserId = "D";
        
        
        
        ArrayList<User> users = this.getAllUsers();
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
        for (User tempuser: users)
            {
                model.addElement(tempuser);
            }
        return model;
    }
    
     public DefaultListModel<User> getAllSecretaries()
    {
    DefaultListModel<User> model = new DefaultListModel<>();
      
        String UserId = "S";
        
        
        
        ArrayList<User> users = this.getAllUsers();
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
        for (User tempuser: users)
            {
                model.addElement(tempuser);
            }
        return model;
    }
    
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
}
