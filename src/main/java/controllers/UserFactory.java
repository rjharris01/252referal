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


import java.time.LocalDate;
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
//Class used to handle all new account creation
public class UserFactory {
    
    
    public User makeNewUser(String userType,String accountName, String accountPassword, String accountAddress, String gender, LocalDate tempDate) 
    {
        
        String userId;
        String tempInput;
        
        tempInput = null;
        User tempUser = null;

        //create new patient 
        if(userType.equals("Patient"))
        {
            Patient tempPatient;
            tempPatient = new Patient();
            tempPatient.setName(accountName);
            tempPatient.setPassword(accountPassword);
            tempPatient.setAddress(accountAddress);
            tempPatient.setGender(gender);
            tempPatient.setBirthday(tempDate);
            tempPatient.setRegisterDate(tempDate.now());
            userId = getNextUserId("P");
            tempPatient.setUserId(userId);

            RequestMaker newRequestMaker = new RequestMaker();
            newRequestMaker.newAccountRequest(tempPatient);
            
            tempUser = tempPatient;

        }
        
        //create new doctor
        else if (userType.equals("Doctor"))
        {
            Doctor tempDoctor;
            tempDoctor = new Doctor();
            tempDoctor.setName(accountName);
            tempDoctor.setPassword(accountPassword);
            tempDoctor.setAddress(accountAddress);
            userId = getNextUserId("D");
            tempDoctor.setUserId(userId);
            
            writeNewUser(tempDoctor);
            tempUser = tempDoctor;
        }
        
        //create new secretary
         else if (userType.equals("Secretary"))
        {
            Secretary tempSecretary;
            tempSecretary = new Secretary();
            tempSecretary.setName(accountName);
            tempSecretary.setPassword(accountPassword);
            tempSecretary.setAddress(accountAddress);
            
            userId = getNextUserId("S");
            tempSecretary.setUserId(userId);
            
            writeNewUser(tempSecretary);
            tempUser = tempSecretary;
            
        }
        //create new admin 
         else if (userType.equals("Administrator"))
        {
            
            Administrator tempAdministrator;
            tempAdministrator = new Administrator();
            tempAdministrator.setName(accountName);
            tempAdministrator.setPassword(accountPassword);
            tempAdministrator.setAddress(tempInput);
            
            userId = getNextUserId("A");
            tempAdministrator.setUserId(userId);
            
            writeNewUser(tempAdministrator);
            tempUser = tempAdministrator;
            
        }
        
        return tempUser;
    }
    //gets the next free user id of given type
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
    
    //writes the user to the user file
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
     
     //returns a list of all 
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
