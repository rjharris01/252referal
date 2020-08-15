/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.user;

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
public class Secretary extends User {
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
   
    public ArrayList<AppointmentRequest> getAllNewAppointmentRequest()
   {
      ArrayList<AppointmentRequest> requests = new ArrayList<>();
      ArrayList<AppointmentRequest> allRequests = getAllAppointmentRequests();
      for (AppointmentRequest request : allRequests)
      {
          if ("newAppointmentRequest".equals(request.getType()))
          {
              requests.add(request);
          }
      }
      return requests;
   }
    
    
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
    
    public void approveAccountRequest(NewAccountRequest accountRequest)
    {
        try{
             User tempUser = accountRequest.getUser();
        
             
        
        tempUser.setUserId(tempUser.getNextUserId("P"));
        tempUser.writeNewUser();
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
    
    public void declineAccountRequest(NewAccountRequest accountRequest)
    {
        try{
            
        User tempUser = accountRequest.getUser();
        
             
        
        tempUser.setUserId(tempUser.getNextUserId("P"));
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
    
    public void approveAppointmentRequest(NewAppointmentRequest appointmentRequest)
    {
        appointmentRequest.getAppointmentRequest().approveRequest(appointmentRequest.getAppointmentRequest());
    }
    
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
}

