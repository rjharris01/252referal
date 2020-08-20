package models;

/**
 *
 * @author richa_bfe6tpy
 */


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import models.user.Doctor;
import models.user.Patient;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

//stores the perscription class
public class Perscription implements Serializable{
    private int perscriptionId;
    private Medicine medicine;
    private Doctor doctor;
    private Patient patient;
    private String dosage;
    private String note;
    private int quantity;
    
    public int getPerscriptionId() { return perscriptionId;}
    public void setPerscriptionId(int newPerscriptionId){perscriptionId = newPerscriptionId;}
    
    public Medicine getMedicine() { return medicine;}
    public void setMedicine(Medicine newMedicine){medicine = newMedicine;}
    
    public Patient getPatient() { return patient;}
    public void setPatient(Patient newPatient){patient = newPatient;}
    
    public Doctor getDoctor() { return doctor;}
    public void setDoctor(Doctor newDoctor){doctor = newDoctor;}
    
    public String getDosage() { return dosage;}
    public void setDosage(String newDosage){dosage = newDosage;}
    
    public String getNote() { return note;}
    public void setNote(String newNote){note = newNote;}
    
    public int getQuantity() { return quantity;}
    public void setQuantity(int newQuantity){quantity = newQuantity;}
    
    //gets the next available peracription id
    public int getNextPerscriptionId()
    {
        ArrayList<Perscription> tempPerscriptions;
        int perscriptionId;
        
        
        if (patient.getPerscriptions().isEmpty())
                {
                    perscriptionId = 0;
                    return perscriptionId;
                }
        
        tempPerscriptions = patient.getPerscriptions();
        perscriptionId = tempPerscriptions.get((tempPerscriptions.size()-1)).getPerscriptionId() + 1;
          
        return perscriptionId;
    }
    
    //outputs the perscription
    public void outputPerscription()
    {

        
          
                String doctorAddress = this.getDoctor().getAddress();
                String doctorAddressLine1 = "";
                String doctorAddressLine2 = "";
                
                String patientAddress = this.getPatient().getAddress();
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
                    FileWriter fw = new FileWriter(new File("perscription_ID" + perscriptionId + ".txt"));
                    fw.write("+-----------------------------------------------------------------------------------------------+\n");
                    fw.write("| Patient.                                         | Doctor.                                    |\n");
                    fw.write("+--------------------------------------------------+--------------------------------------------+\n");
                    fw.write("| Name : " + String.format("%-42s",this.getDoctor().getName())+ "| Name : "+  String.format("%-36s",this.getPatient().getName()) + "|\n");
                    fw.write("| Address :                                        | Address :                                  |\n");
                    fw.write("| " + String.format("%-48s",patientAddressLine1) + " | " + String.format("%-43s",doctorAddressLine1) + "|\n");
                    fw.write("| " + String.format("%-48s",patientAddressLine2) + " | " + String.format("%-43s",doctorAddressLine2) + "|\n");
                    fw.write("| Sex :" + String.format("%44s",this.getPatient().getGender())+"|                                            |\n");
                    fw.write("| Age :" + String.format("%44s",Period.between(this.getPatient().getBirthday(),LocalDate.now()).getYears())+ "|                                            |\n");
                    fw.write("+--------------------------------------------------+--------------------------------------------+\n");
                    fw.write("Notes.\n");
                    fw.write(this.getNote());
                    fw.write("\n+-----------------------------------------------------------------------------------------------+\n");
                    fw.write("| Medicine        | Quantity | Dosage                                                           |\n");
                    fw.write("+-----------------+----------+------------------------------------------------------------------+\n");
                    fw.write("| " + String.format("%-15s",this.getMedicine().getName()) + " | " + String.format("%-9s",this.getQuantity()) + "|" +String.format("%-66s",this.getDosage()) + "|\n");
                    fw.write("+-----------------+----------+------------------------------------------------------------------+\n");        
                    
                    
                    fw.close();
        
                } catch (IOException e) {
                    System.out.print("No file \n");
                }
                    
            }  
}

