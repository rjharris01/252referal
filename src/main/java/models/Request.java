/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author richa_bfe6tpy
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import models.user.Secretary;
import models.user.User;

/**
 *
 * @author Richard Harris
 */
//stores the request abstract class
public abstract class Request implements Observable, Serializable {
    
    private String type;
   // private int requestId;
    private boolean completed = false;
    
    private ArrayList<User> users = new ArrayList();
    
    
    public boolean getCompleted(){return completed;}
    public void setCompleted(boolean completed){this.completed = completed;
    notifyObservers();
    }
    
    
    public String getType() { return type;}
    public void setType(String newType){type = newType;}
    
    public ArrayList<Request>  getAllRequests()
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
    
    
     @Override
    public void addObserver(User u) {
        users.add((User)u);
    }

    @Override
    public void removeObserver(User u) {
        users.remove((User)u);
    }

    @Override
    public void notifyObservers()
    {
        Secretary temp = new Secretary();
        for(User user:users){
            temp = (Secretary)user;
            temp.updateAllRequests(this);
        }
        
        
    }
    
    
}
