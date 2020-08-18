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
public class SecretaryCompletePerscriptionController {
    private SecretaryCompletePerscriptionView theView;
    private Secretary theModel;
    
    public SecretaryCompletePerscriptionController(SecretaryCompletePerscriptionView theView, Secretary theModel ){
        this.theView = theView;
        this.theModel = theModel;
        
        setPatientList();
   
        
         this.theView.addBackListener(new BackListener());
         this.theView.addPatientSelectListener(new PatientSelectListener());
         this.theView.addSubmitListener(new SubmitListener());
         
        
    }
    
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
    
    class SubmitListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            Perscription selectPerscription = theView.getPerscription();
            Patient patient = theView.getPatient();
            Medicine medicine = selectPerscription.getMedicine();
            Integer Quantity = selectPerscription.getQuantity();
            
            patient.removePerscription(selectPerscription);
            medicine.setStock(medicine.getStock() - Quantity);
            medicine.updateMedicine();
            
            setPerscriptionList();
            JOptionPane.showMessageDialog(null, "Persciption Completed");
            
            
        }
        
    }
    
    class PatientSelectListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            setPerscriptionList();
            
        }
        
    }
    
    public void setPerscriptionList(){
            Patient patient = theView.getPatient();
            
            ArrayList<Perscription> perscriptions = patient.getPerscriptions();
            DefaultListModel<Perscription> model = new DefaultListModel();
            for(Perscription p : perscriptions)
            {
                model.addElement(p);
            }
            
            theView.setPerscriptionList(model);
            
    }
    
    
    public void setPatientList(){
        ArrayList<Patient> patients = this.theModel.getAllPatients();
        DefaultComboBoxModel<Patient> model = new DefaultComboBoxModel();
        
        
        
        for(Patient p : patients)
        {
            model.addElement(p);
        }
        
        this.theView.setPatientList(model);
    }
}
