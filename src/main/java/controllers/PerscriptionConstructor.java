/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;
import models.Medicine;
import models.Perscription;
import models.user.Doctor;
import models.user.Patient;

/**
 *
 * @author richa_bfe6tpy
 */
public class PerscriptionConstructor {
    public Perscription makePerscription(Doctor doctor, Patient patient, Medicine medicine)
    {
        Scanner userInput = new Scanner(System.in);
        
        Perscription tempPerscription;
        tempPerscription = new Perscription();
        
        tempPerscription.setPerscriptionId(getNextPerscriptionId());
        tempPerscription.setDoctor(doctor);
        tempPerscription.setPatient(patient);
        tempPerscription.setMedicine(medicine);
        tempPerscription.setNote(userInput.nextLine());
        tempPerscription.setDosage(userInput.nextLine());
        tempPerscription.setQuantity(Integer.parseInt(userInput.nextLine()));
        
        
        writePerscription(tempPerscription);
        return tempPerscription;
    }
    
    
    private int getNextPerscriptionId()
    {
        ArrayList<Perscription> tempPerscriptions;
        int perscriptionId;
        
        tempPerscriptions = getAllPerscriptions();
        perscriptionId = tempPerscriptions.size();
          
        return perscriptionId;
    }
    
    private void writePerscription(Perscription perscription)
    {
        
        ArrayList<Perscription> perscriptions;
        perscriptions = getAllPerscriptions();
         
        perscriptions.add(perscription);
         
         try
        {
            FileOutputStream fos = new FileOutputStream("Perscriptions.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(perscriptions);
            oos.close();
            fos.close();
        } 
         
         catch (IOException ioe) 
        {
            ioe.printStackTrace();
        }    
        
        
       
    }
    
    public ArrayList<Perscription>  getAllPerscriptions()
    {
        ArrayList<Perscription> perscriptions = new ArrayList<>();
        try {
                        FileInputStream fis = new FileInputStream("Perscriptions.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
                        perscriptions = (ArrayList) ois.readObject();
			
			ois.close();
                        fis.close();
                        
            } catch (FileNotFoundException  e) {
			System.out.print("No file \n");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
        return perscriptions; 
    }
    
    
    public void outputPerscription(int perscriptionId)
    {
        ArrayList<Perscription> perscriptions;
        perscriptions = getAllPerscriptions();
        
        for (Perscription perscription : perscriptions)
        {
            if (perscription.getPerscriptionId() == perscriptionId)
            {
                String doctorAddress = perscription.getDoctor().getAddress();
                String doctorAddressLine1 = "";
                String doctorAddressLine2 = "";
                
                String patientAddress = perscription.getPatient().getAddress();
                String patientAddressLine1 = "";
                String patientAddressLine2 = "";
                
                if (doctorAddress.length() > 43)
                {
                    doctorAddressLine1 = doctorAddress.substring(0, 43);
                    doctorAddressLine2 = doctorAddress.substring(43, doctorAddress.length());
                }
                else {
                    doctorAddressLine1 = doctorAddress;
                }
                
                 if (patientAddress.length() > 48)
                {
                    patientAddressLine1 = patientAddress.substring(0, 48);
                    patientAddressLine2 = patientAddress.substring(48, patientAddress.length());
                }
                else {
                    patientAddressLine1 = patientAddress;
                }
                
               
                    
               
                try {
                    FileWriter fw = new FileWriter(new File("perscription" + perscriptionId + ".txt"));
                    fw.write("+-----------------------------------------------------------------------------------------------+\n");
                    fw.write("| Patient.                                         | Doctor.                                    |\n");
                    fw.write("+--------------------------------------------------+--------------------------------------------+\n");
                    fw.write("| Name : " + String.format("%-42s",perscription.getDoctor().getName())+ "| Name : "+  String.format("%-36s",perscription.getPatient().getName()) + "|\n");
                    fw.write("| Address :                                        | Address :                                  |\n");
                    fw.write("| " + String.format("%-48s",patientAddressLine1) + " | " + String.format("%-43s",doctorAddressLine1) + "|\n");
                    fw.write("| " + String.format("%-48s",patientAddressLine2) + " | " + String.format("%-43s",doctorAddressLine2) + "|\n");
                    fw.write("| Sex :" + String.format("%44s",perscription.getPatient().getGender())+"|                                            |\n");
                    fw.write("| Age :" + String.format("%44s",Period.between(perscription.getPatient().getBirthday(),LocalDate.now()).getYears())+ "|                                            |\n");
                    fw.write("+--------------------------------------------------+--------------------------------------------+\n");
                    fw.write("Notes.\n");
                    fw.write(perscription.getNote());
                    fw.write("\n+-----------------------------------------------------------------------------------------------+\n");
                    fw.write("| Medicine        | Quantity | Dosage                                                           |\n");
                    fw.write("+-----------------+----------+------------------------------------------------------------------+\n");
                    fw.write("| " + String.format("%-15s",perscription.getMedicine().getName()) + " | " + String.format("%-9s",perscription.getQuantity()) + "|" +String.format("%-66s",perscription.getDosage()) + "|\n");
                    fw.write("+-----------------+----------+------------------------------------------------------------------+\n");        
                    
                    
                    fw.close();
        
                } catch (IOException e) {
                    System.out.print("No file \n");
                }
                    
                
                    
                
            }
        }
        
    }
    
    
}
