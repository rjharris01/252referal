/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.awt.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import models.user.Secretary;
import models.user.User;

/**
 *
 * @author richa_bfe6tpy
 */
//stores the medicine class
public class Medicine implements Serializable,Observable {
    private int medId;
    private String name;
    private int stock;
    private boolean inStock = false;
    private ArrayList<User> users = new ArrayList<User>(); //stores secretarys when they need to be notified of a medicine that is low stock
    
    
    public int getMedId(){return medId;}
    public void setMedId(int newMedId){medId = newMedId;}
    
    public String getName() { return name;}
    public void setName(String newName){name = newName;}
    
    public int getStock(){return stock;}
    public void setStock(int newStock){stock = newStock;}
    
    public void setInStock(boolean inStock){
        this.inStock = inStock;
        notifyObservers();
    }
    
    public boolean getInstock(){return inStock;}
    
    
    //updates the medicine in the medicine file
    public void updateMedicine(){
       
        int index = 0;
        ArrayList<Medicine> medicines  = new ArrayList<>();
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
        
        
        for(int k = 0; k < medicines.size(); k++) {
        if(medicines.get(k).getMedId() == this.getMedId()) {
            index = k;
            }
        }
        medicines.set(index, this);
        
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
     
    }
    
    @Override
    public String toString() {
        return (this.getName());
    }
    
    //overiding the observable class methods

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
            temp.update(this);
        }
        
        
    }
}
