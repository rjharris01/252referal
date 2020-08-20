/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author richa_bfe6tpy
 */
//stores the medicine class
public class Medicine implements Serializable {
    private int medId;
    private String name;
    private int stock;
    
    
    
    public int getMedId(){return medId;}
    public void setMedId(int newMedId){medId = newMedId;}
    
    public String getName() { return name;}
    public void setName(String newName){name = newName;}
    
    public int getStock(){return stock;}
    public void setStock(int newStock){stock = newStock;}
    
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
    
    
    
}
