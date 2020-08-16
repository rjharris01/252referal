/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import models.Medicine;

/**
 *
 * @author richa_bfe6tpy
 */
public class MedicineFactory {
    public Medicine makeNewMedicine(String MedicineName)
    {
        Medicine tempMedicine;
        tempMedicine = new Medicine();
        tempMedicine.setMedId(getNextMedicineId());
        tempMedicine.setName(MedicineName);
        tempMedicine.setStock(0);
        
        writeNewMedicine(tempMedicine);
        
        return tempMedicine;
    }
    
    private ArrayList<Medicine>  getAllMedicine()
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
    
    
    private void writeNewMedicine(Medicine medicine)
    {
         ArrayList<Medicine> medicines;
         medicines = getAllMedicine();
         
         medicines.add(medicine);
         
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
    
    
    private  int getNextMedicineId() 
    {
        ArrayList<Medicine> tempMedicines;
        int medicineId;
        
        tempMedicines = getAllMedicine();
        medicineId = tempMedicines.size();
          
        return medicineId;
    }
}
