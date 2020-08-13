/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Views.SignupView;
import Views.soft252ReferalView;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import models.user.Administrator;
import models.user.Doctor;
import models.user.Patient;
import models.user.Secretary;
import models.user.User;

/**
 *
 * @author Richard Harris
 */
public class userFactory {
    
    
    public User makeNewAdmin(String userType,String accountName, String accountPassword, String accountAddress)
    {
        User tempUser = null;
        String userId;
        
        Administrator tempAdministrator;
         
        tempAdministrator = new Administrator();
         
        tempAdministrator.setName(accountName);
        tempAdministrator.setPassword(accountPassword);
        tempAdministrator.setAddress(accountAddress);
            
        userId = getNextUserId("A");
        tempAdministrator.setUserId(userId);
            
        writeNewUser(tempAdministrator);
        tempUser = tempAdministrator;
        
        return tempUser;
        
        
    }
    
    public User makeNewUser(String userType, soft252ReferalView ui) 
    {
        
        String userId;
        String tempInput;
        
        tempInput = null;
        User tempUser = null;
        
        
        LocalDate tempDate = null;
        
        
        
        
      
        if(userType.equals("Patient"))
        {
            Patient tempPatient;
            tempPatient = new Patient();
            
            System.out.print("Please enter the patients name: ");
            
            tempPatient.setName(tempInput);
            
            System.out.print("Please enter a password: ");
           
            tempPatient.setPassword(tempInput);
            
            System.out.print("Please enter the patients address: ");
            
            tempPatient.setAddress(tempInput);
            
            
            System.out.print("Please enter the patients gender: ");
          
            tempPatient.setGender(tempInput);
            
            System.out.print("Please enter the patients birthday in format dd/mm/yyyy: ");
           
            DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            tempDate = LocalDate.parse(tempInput, dt);
            tempPatient.setBirthday(tempDate);
            
            
            tempPatient.setRegisterDate(tempDate.now());
            
            userId = getNextUserId("P");
            tempPatient.setUserId(userId);
     
            System.out.println("\n Patient Requested");
            
            
            RequestMaker newRequestMaker = new RequestMaker();
            newRequestMaker.newAccountRequest(tempPatient);
            
            tempUser = tempPatient;

        }
        
        
        else if (userType.equals("Doctor"))
        {
            Doctor tempDoctor;
            tempDoctor = new Doctor();
            System.out.print("Please enter the Doctors name: ");
            
            tempDoctor.setName(tempInput);
            
            System.out.print("Please enter a password: ");
          
            tempDoctor.setPassword(tempInput);
            
            System.out.print("Please enter the Doctors address: ");
          
            tempDoctor.setAddress(tempInput);
            
            userId = getNextUserId("D");
            tempDoctor.setUserId(userId);
            
            writeNewUser(tempDoctor);
            tempUser = tempDoctor;
        }
        
        
         else if (userType.equals("Secretary"))
        {
            
            
            Secretary tempSecretary;
            tempSecretary = new Secretary();
            System.out.print("Please enter the Secretarys name: ");
           
            tempSecretary.setName(tempInput);
            
            System.out.print("Please enter a password: ");
        
            tempSecretary.setPassword(tempInput);
            
            System.out.print("Please enter the Secretary address: ");
           
            tempSecretary.setAddress(tempInput);
            
            userId = getNextUserId("S");
            tempSecretary.setUserId(userId);
            
            writeNewUser(tempSecretary);
            tempUser = tempSecretary;
            
        }
        
         else if (userType.equals("Administrator"))
        {
            
            Administrator tempAdministrator;
            tempAdministrator = new Administrator();
            System.out.print("Please enter the Admins name: ");
          
            tempAdministrator.setName(tempInput);
            
            System.out.print("Please enter a password: ");
           
            tempAdministrator.setPassword(tempInput);
            
            System.out.print("Please enter the Admins address: ");
           
            tempAdministrator.setAddress(tempInput);
            
            userId = getNextUserId("A");
            tempAdministrator.setUserId(userId);
            
            writeNewUser(tempAdministrator);
            tempUser = tempAdministrator;
            
        }
        
        return tempUser;
    }
    
    private String getNextUserId(String UserType) {
        ArrayList<User> users = new ArrayList<> ();
        ArrayList<User> tempUsers;
        String userId = "z9999";
        int userIdNumber;
        
        tempUsers = getAllUsers();
        for (User user : tempUsers)
        {
            if ((user.getUserId()).charAt(0) == UserType.charAt(0))
            {
                users.add(user);
            }
        }
        
        try {
                User e = users.get(users.size() - 1);
                userId = e.getUserId();
                userId = userId.substring(1);
                userIdNumber = Integer.parseInt(userId);
                userIdNumber = userIdNumber + 1;
                userId = UserType;
                userId = userId + String.format("%04d",userIdNumber);    //catch need for string format error
            }
            
            catch  (IndexOutOfBoundsException e){
                    System.out.print("No enteries \n");
                    userId = UserType;;
                    userId = userId + "0000";
                    
            }
        return userId;
    }
    
     private void writeNewUser(User user)
     {
         ArrayList<User> users;
         users = getAllUsers();
         
         users.add(user);
         
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
     
     public ArrayList<User>  getAllUsers()
     {
        ArrayList<User> users = new ArrayList<>();
        try {
                        FileInputStream fis = new FileInputStream("User.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
                        users = (ArrayList) ois.readObject();
			
			ois.close();
                        fis.close();
                        
            } catch (FileNotFoundException  e) {
			System.out.print("No file \n");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
        return users; 
     }
     
    
}
