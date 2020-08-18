/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Secretary;

import Views.LoginView;
import Views.Secretary.SecretaryDeleteUserManualView;
import Views.Secretary.SecretaryAppointmentView;
import Views.Secretary.SecretaryApproveAppointmentView;
import Views.Secretary.SecretaryApprovePatientView;
import Views.Secretary.SecretaryCompletePerscriptionView;
import Views.Secretary.SecretaryDeleteUserRequestView;
import Views.Secretary.SecretaryOrderMedicineView;
import Views.Secretary.SecretaryView;
import controllers.LoginController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import models.user.Secretary;
import models.user.User;

/**
 *
 * @author richa_bfe6tpy
 */
public class SecretaryController {
    private SecretaryView theView;
    private Secretary theModel;
    
    public SecretaryController(SecretaryView theView,Secretary theModel)
    {
        this.theView = theView;
        this.theModel = theModel;
       
        
        this.theView.addSecratryApprovePatientListener(new SecretaryApprovePatientListener());
        this.theView.addSecratryCreateAppointmentListener(new SecretaryCreateAppointmentListener());
        this.theView.addSecratryOrderMedicineListener(new SecretaryOrderMedicineListener());
        this.theView.addSecratryRemovePatientListener(new SecretaryDeleteUserListener());
        this.theView.addSecratryRemovePatientRequestListener(new SecretaryDeletePatientRequestListener());
        this.theView.addSecratryCompletePerscriptionListener(new SecretaryCompletePerscriptionListener());
        this.theView.addLogoutListener(new LogoutListener());
        this.theView.addSecretaryApproveAppointmentListener(new SecretaryApproveAppointmentListener());
        
        
    }
    
    class SecretaryApprovePatientListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            SecretaryApprovePatientView newView = new SecretaryApprovePatientView();
  
              
            SecretaryApprovePatientController theController = new SecretaryApprovePatientController(newView, theModel);
            theView.setVisible(false);
            newView.setVisible(true);
            theView.getParent().add(newView,SwingConstants.CENTER);
        }
        
    }
    
    class SecretaryCreateAppointmentListener implements ActionListener {

       @Override
        public void actionPerformed(ActionEvent e) {
            SecretaryAppointmentView newView = new SecretaryAppointmentView();
  
              
            SecretaryAppointmentController theController = new SecretaryAppointmentController(newView, theModel);
            theView.setVisible(false);
            newView.setVisible(true);
            theView.getParent().add(newView,SwingConstants.CENTER);
        }
        
    }
    
    class SecretaryOrderMedicineListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            SecretaryOrderMedicineView newView = new SecretaryOrderMedicineView();
  
              
            SecretaryOrderMedicineController theController = new SecretaryOrderMedicineController(newView, theModel);
            theView.setVisible(false);
            newView.setVisible(true);
            theView.getParent().add(newView,SwingConstants.CENTER);
        }
        
    }
    
    class SecretaryDeletePatientRequestListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            SecretaryDeleteUserRequestView newView = new SecretaryDeleteUserRequestView();
  
              
            SecretaryDeleteUserRequestController theController = new SecretaryDeleteUserRequestController(newView, theModel);
            theView.setVisible(false);
            newView.setVisible(true);
            theView.getParent().add(newView,SwingConstants.CENTER);
        }
    }
    
    class SecretaryDeleteUserListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            SecretaryDeleteUserManualView newView = new SecretaryDeleteUserManualView();
  
              
            SecretaryDeleteUserManualController theController = new SecretaryDeleteUserManualController(newView, theModel);
            theView.setVisible(false);
            newView.setVisible(true);
            theView.getParent().add(newView,SwingConstants.CENTER);
        }
        
    }
    
    class SecretaryCompletePerscriptionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            SecretaryCompletePerscriptionView newView = new SecretaryCompletePerscriptionView();
  
              
            SecretaryCompletePerscriptionController theController = new SecretaryCompletePerscriptionController(newView, theModel);
            theView.setVisible(false);
            newView.setVisible(true);
            theView.getParent().add(newView,SwingConstants.CENTER);
        }
        
    }
    
    
    
    class LogoutListener implements ActionListener {

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
    
    class SecretaryApproveAppointmentListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            SecretaryApproveAppointmentView newView = new SecretaryApproveAppointmentView();
  
              
            SecretaryApproveAppointmentController theController = new SecretaryApproveAppointmentController(newView, theModel);
            theView.setVisible(false);
            newView.setVisible(true);
            theView.getParent().add(newView,SwingConstants.CENTER);
        }
        
    }
    
    
}
