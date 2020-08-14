/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Patient;

import Views.Patient.PatientView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.user.Patient;

/**
 *
 * @author richa_bfe6tpy
 */
public class PatientController {
    private PatientView theView;
    private Patient theModel;
    
    public PatientController(PatientView theView,Patient theModel)
    {
        this.theView = theView;
        this.theModel = theModel;
        
        this.theView.addPatientRequestAccountDeletionListener(new PatientRequestAccountDeletionListener());
        this.theView.addPatientViewAppointmentListener(new PatientViewAppointmentListener());
        this.theView.addPatientViewPerscriptionListener(new PatientViewPerscriptionListener());
        this.theView.addPatientViewHistoryListener(new PatientViewHistoryListener());
        this.theView.addPatientFeedbackListener(new PatientFeedbackListener());
        this.theView.addPatientAppointmentListener(new PatientAppointmentListener());
        this.theView.addPatientLogoutListener(new PatientLogoutListener());
    }
    
     class PatientRequestAccountDeletionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
         
     }
     
     class PatientViewAppointmentListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
         
     }
     
     
     class PatientViewPerscriptionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
         
     }
     
     class PatientViewHistoryListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
         
     }
     
     class PatientFeedbackListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
         
     }
     
     class PatientAppointmentListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
         
     }
     
     class PatientLogoutListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
         
     }
}
