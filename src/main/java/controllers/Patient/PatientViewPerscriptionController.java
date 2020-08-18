/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Patient;

import Views.Patient.PatientView;
import Views.Patient.PatientViewPerscriptionView;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import models.Appointment;
import models.Perscription;
import models.user.Patient;

/**
 *
 * @author richa_bfe6tpy
 */
public class PatientViewPerscriptionController {
    private PatientViewPerscriptionView theView;
    private Patient theModel;
    
    public PatientViewPerscriptionController(PatientViewPerscriptionView theView,Patient theModel)
    {
        this.theView = theView;
        this.theModel = theModel;
        
        this.theView.addPatientBackButton(new PatientBackListener());
        this.theView.addPatientPerscriptionPrintButton(new PatientPrintListener());
        setPerscriptions();
    }
    
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
    
    class PatientPrintListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Perscription toPrint = theView.getPerscriptionToPrint();
            toPrint.outputPerscription();
            JOptionPane.showMessageDialog(null, "Perscription has been\nprinted to a file locally");
        }
        
    }
    
    
    
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
