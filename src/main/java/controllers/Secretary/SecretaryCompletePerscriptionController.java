/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Secretary;

import Views.Secretary.SecretaryCompletePerscriptionView;
import Views.Secretary.SecretaryView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import models.Medicine;
import models.Perscription;
import models.user.Patient;
import models.user.Secretary;

/**
 *
 * @author richa_bfe6tpy
 */
//Controller for the secretary complete perscription view
public class SecretaryCompletePerscriptionController {
    //Variables declaration
    private SecretaryCompletePerscriptionView theView;
    private Secretary theModel;
    
    public SecretaryCompletePerscriptionController(SecretaryCompletePerscriptionView theView, Secretary theModel ){
        //Construct the controller
        this.theView = theView;
        this.theModel = theModel;
        
        //set patient list on load
        setPatientList();
   
        //Connect buttons
        this.theView.addBackListener(new BackListener());
        this.theView.addPatientSelectListener(new PatientSelectListener());
        this.theView.addSubmitListener(new SubmitListener());
         
        
    }
    
    //return to secretary main control panel
    class BackListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            SecretaryView secretaryView = new SecretaryView();
            SecretaryController secretarController = new SecretaryController(secretaryView,theModel);
            theView.setVisible(false);
            secretaryView.setVisible(true);
            theView.getParent().add(secretaryView,SwingConstants.CENTER);
        }
        
    }
    
    
    //on button press get selected perscription and reduce stock accordingly
    class SubmitListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            Perscription selectPerscription = theView.getPerscription(); //get selected perscription
            Patient patient = theView.getPatient(); //get selected patient
            Medicine medicine = selectPerscription.getMedicine();//get medicine
            Integer Quantity = selectPerscription.getQuantity();//get quantity
            
            patient.removePerscription(selectPerscription);//remove the perscription from the patient
            medicine.setStock(medicine.getStock() - Quantity);//update the medicine stock
            medicine.updateMedicine();//save 
            
            setPerscriptionList();//reset the patient perscription list
            JOptionPane.showMessageDialog(null, "Persciption Completed");
            
            
        }
        
    }
    
    
    //listen for change in patient and reset perscription list
    class PatientSelectListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            setPerscriptionList();
            
        }
        
    }
    
    //set perscription list based on user selected
    public void setPerscriptionList(){
            Patient patient = theView.getPatient(); //selected user
            
            ArrayList<Perscription> perscriptions = patient.getPerscriptions(); //all perscriptions for user
            DefaultListModel<Perscription> model = new DefaultListModel();
            for(Perscription p : perscriptions)
            {
                model.addElement(p);//add perscriptions to model
            }
            
            theView.setPerscriptionList(model);//update model
            
    }
    
    //set patient list
    public void setPatientList(){
        ArrayList<Patient> patients = this.theModel.getAllPatients();//get all patients
        DefaultComboBoxModel<Patient> model = new DefaultComboBoxModel();
        
        
        
        for(Patient p : patients)//loop patients
        {
            model.addElement(p);//add patient to model
        }
        
        this.theView.setPatientList(model);//update model
    }
}
