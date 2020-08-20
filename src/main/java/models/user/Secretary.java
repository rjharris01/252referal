/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.user;

import controllers.UserFactory;
import models.Medicine;
import models.NewAccountRequest;
import models.Request;
import models.NewAppointmentRequest;
import models.AppointmentRequest;
import models.AccountDeleteRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Richard Harris
 */
//stores the secretary user class
public class Secretary extends User {
    
    //returns a list of all requests
    public ArrayList<Request> getAllRequests()
    {
       
        ArrayList<Request> requests = new ArrayList<>();
        try {
                        FileInputStream fis = new FileInputStream("Requests.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
                        requests = (ArrayList) ois.readObject();
			
			ois.close();
                        fis.close();
                        
            } catch (FileNotFoundException  e) {
			System.out.print("No file \n");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
        return requests; 
    }
   
    
    //returns a list of all new account requests
   public ArrayList<NewAccountRequest> getAllNewAccountRequests()
   {
      ArrayList<NewAccountRequest> requests = new ArrayList<>();
      ArrayList<Request> allRequests = getAllRequests();
      for (Request request : allRequests)
      {
          if ("newAccountRequest".equals(request.getType()))
          {
              requests.add((NewAccountRequest) request);
          }
      }
      return requests;
   }
   
   
   //returns a list of all appointment requests
    public ArrayList<NewAppointmentRequest> getAllNewAppointmentRequest()
   {
      ArrayList<NewAppointmentRequest> requests = new ArrayList<>();
      ArrayList<Request> allRequests = getAllRequests();
      for (Request request : allRequests)
      {
          if ("newAppointmentRequest".equals(request.getType()))
          {
              requests.add((NewAppointmentRequest)request);
          }
      }
      return requests;
   }
    
    //returns a list of all delete account requests
    public ArrayList<AccountDeleteRequest> getAllAccountDeleteRequest()
   {
      ArrayList<AccountDeleteRequest> requests = new ArrayList<>();
      ArrayList<Request> allRequests = getAllRequests();
      for (Request request : allRequests)
      {
          if ("accountDeleteRequest".equals(request.getType()))
          {
              requests.add((AccountDeleteRequest)request);
          }
      }
      return requests;
   }
    
    //method for secretary to order more medicine
    public ArrayList<Medicine> orderMedicine(int medicineId, int orderAmount) //void later
    {
        ArrayList<Medicine> medicines;
        medicines = getAllMedicine();
        for (Medicine medicine : medicines)
        {
            if (medicine.getMedId() == medicineId)
            {
                medicine.setStock((medicine.getStock()+ orderAmount));
            }
        }
        
        try
        {
            FileOutputStream fos = new FileOutputStream("Medicines.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(medicines);
            oos.close();
            fos.close();
        } 
         
         catch (IOException ioe) 
        {
            ioe.printStackTrace();
        }    
        
        return medicines;
    }
   
    //returns a list of all medicines
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
    
    
    //method to approve a account request and returns user id string
    public String approveAccountRequest(NewAccountRequest accountRequest)
    {
        try{
            
             UserFactory uf = new UserFactory();
             Patient tempUser = (Patient) accountRequest.getUser();
        
             
        tempUser = (Patient) uf.makeNewUser("Patient", tempUser.getName(), tempUser.getPassword(), tempUser.getAddress(), tempUser.getGender(), tempUser.getRegisterDate());
        ArrayList<Request> requests = this.getAllRequests();
        Iterator<Request> iter = requests.iterator();
        while (iter.hasNext())
        {
            Request request = iter.next();
            if(request.getRequestId() == accountRequest.getRequestId())
            {
                iter.remove();
                updateRequests(requests);
            }
        }
        return tempUser.getUserId();
        
       } 
        
        catch (java.lang.NullPointerException e)
             {
                 return ("No User requests");
             }
    }
    
    
    //method to decline a new account request
    public void declineAccountRequest(NewAccountRequest accountRequest)
    {
        try{
            
        User tempUser = accountRequest.getUser();
        ArrayList<Request> requests = this.getAllRequests();
        Iterator<Request> iter = requests.iterator();
        while (iter.hasNext())
        {
            Request request = iter.next();
            if(request.getRequestId() == accountRequest.getRequestId())
            {
                iter.remove();
                updateRequests(requests);
            }
        }
        
       } 
        
        catch (java.lang.NullPointerException e)
             {
                 System.out.print("No Use requests");
             }
    }
    
    //method to approve a new appointment request
    public void approveAppointmentRequest(NewAppointmentRequest appointmentRequest)
    {
        appointmentRequest.getAppointmentRequest().approveRequest(appointmentRequest.getAppointmentRequest());
    }
    
    //method to delete any request
    public void deleteRequest(Request request)
    {
        ArrayList<Request> requests;
        ArrayList<Request> toRemove = new ArrayList();
        requests = request.getAllRequests();
        
        for(Request r: requests)
        {
            if(r.getRequestId() == request.getRequestId())
            {
                toRemove.add(r);
            }
        }
        
        requests.removeAll(toRemove);
        updateRequests(requests);
    }
    
    
    //method to delete user
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
     
    //method to update requests file
    public void updateRequests(ArrayList<Request> requests)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream("Requests.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(requests);
            oos.close();
            fos.close();
        } 
         
         catch (IOException ioe) 
        {
            ioe.printStackTrace();
        }    
        
        if (requests.isEmpty())
        {
            File file = new File("Requests.ser");
            file.delete();  
        }
        
    }
    
    //method returns all appointment requests
     public ArrayList<AppointmentRequest>  getAllAppointmentRequests()
    {
        ArrayList<AppointmentRequest> appointments = null;
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
     
    //method returns all patients 
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
     
     @Override
    public String toString() {
        return ("Name: " + this.getName() + " ID:" + this.getUserId());
    }
}

