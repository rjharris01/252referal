/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Patient;

import Views.Patient.PatientView;
import Views.Patient.PatientViewPerscriptionView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import models.Perscription;
import models.user.Patient;

/**
 *
 * @author richa_bfe6tpy
 */
//Controller for the patient view perscription view 
public class PatientViewPerscriptionController {
    //Variables declaration
    private PatientViewPerscriptionView theView;
    private Patient theModel;
    
    public PatientViewPerscriptionController(PatientViewPerscriptionView theView,Patient theModel)
    {
        //Construct the controller
        this.theView = theView;
        this.theModel = theModel;
        //Connect buttons
        this.theView.addPatientBackButton(new PatientBackListener());
        this.theView.addPatientPerscriptionPrintButton(new PatientPrintListener());
        //set perscriptions list on load
        setPerscriptions();
    }
    
    //return to patient control panel on button press
    class PatientBackListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            PatientView patientView = new PatientView();
            PatientController patientController = new PatientController(patientView,theModel);
            theView.setVisible(false);
            patientView.setVisible(true);
            theView.getParent().add(patientView,SwingConstants.CENTER);
        }
        
    }
    
    
    //on button press create local file of perscription in format
    class PatientPrintListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Perscription toPrint = theView.getPerscriptionToPrint();
            toPrint.outputPerscription();//perscription print method
            JOptionPane.showMessageDialog(null, "Perscription has been\nprinted to a file locally");
        }
        
    }
    
    
    //set list of perscriptions based on user logged in
    public void setPerscriptions(){
       ArrayList<Perscription> perscriptions = theModel.getPerscriptions();
       DefaultListModel<Perscription> model = new DefaultListModel();
       for(Perscription p : perscriptions)
       {
           model.addElement(p);
       }
       
       theView.setPerscription(model);
       
    }
    
}
