/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.user;

/**
 *
 * @author Richard Harris
 */

//store the abstract user class
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class User implements Serializable {
    private String userId;
    private String name;
    private String password;
    private String address;
    private LocalDate registerDate;
    private Boolean loginStatus;
    
    
    public String getUserId() { return userId;}
    public void setUserId(String newUserId){userId = newUserId;}
    
    public String getName() { return name;}
    public void setName(String newName){name = newName;}
    
    public String getPassword() { return password;}
    public void setPassword(String newPassword){password = newPassword;}
    
    public String getAddress() { return address;}
    public void setAddress(String newAddress){address = newAddress;}
    
    public LocalDate getRegisterDate() { return registerDate;}
    public void setRegisterDate(LocalDate newRegisterDate){registerDate = newRegisterDate;}
    
    public Boolean getLoginStatus() { return loginStatus;}
    public void setLoginStatus(Boolean newLoginStatus){loginStatus = newLoginStatus;}
    
    public Boolean verifyLogin(String enteredPassword){if (enteredPassword == password) {setLoginStatus(true); return true;} else{return false;} }
    
    //updates a user in user.ser
    public void updateUser()
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
    
    //returns a list of all users
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
