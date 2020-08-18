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
                                                       
    public String getNextUserId(String UserType) {
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
    
     public void writeNewUser(User this)
     {
         ArrayList<User> users;
         users = getAllUsers();
         
         users.add(this);
         
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
}
