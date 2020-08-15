/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Patient;

import Views.LoginView;
import Views.Patient.PatientLeaveFeedbackForDoctorView;
import Views.Patient.PatientRequestAppointmentView;
import Views.Patient.PatientView;
import Views.Patient.PatientViewAppointmentView;
import Views.Patient.PatientViewHistoryView;
import controllers.LoginController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import models.user.Patient;
import models.user.User;

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
            PatientViewAppointmentView newView = new PatientViewAppointmentView();
            PatientViewAppointmentController theController = new PatientViewAppointmentController(newView, theModel);
            theView.setVisible(false);
            newView.setVisible(true);
            theView.getParent().add(newView,SwingConstants.CENTER);
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
            PatientViewHistoryView newView = new PatientViewHistoryView();
            PatientViewHistoryController theController = new PatientViewHistoryController(newView, theModel);
            theView.setVisible(false);
            newView.setVisible(true);
            theView.getParent().add(newView,SwingConstants.CENTER);
        }
         
     }
     
     class PatientFeedbackListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            PatientLeaveFeedbackForDoctorView newView = new PatientLeaveFeedbackForDoctorView();
            
                
            PatientLeaveFeedbackForDoctorController theController = new PatientLeaveFeedbackForDoctorController(newView, theModel);
            theView.setVisible(false);
            newView.setVisible(true);
            theView.getParent().add(newView,SwingConstants.CENTER);
        }
         
     }
     
     class PatientAppointmentListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
      
            PatientRequestAppointmentView newView = new PatientRequestAppointmentView();
            
                
            PatientRequestAppointmentController theController = new PatientRequestAppointmentController(newView, theModel);
            theView.setVisible(false);
            newView.setVisible(true);
            theView.getParent().add(newView,SwingConstants.CENTER);
        }
         
     }
     
     class PatientLogoutListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            theModel.setLoginStatus(false);
            LoginView newView = new LoginView();
            User newModel = new User() {};    
                
            LoginController theController = new LoginController(newView, newModel);
            theView.setVisible(false);
            newView.setVisible(true);
            theView.getParent().add(newView,SwingConstants.CENTER);
        }
         
     }
}
