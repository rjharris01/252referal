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
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import models.Medicine;
import models.Request;
import models.user.Secretary;
import models.user.User;

/**
 *
 * @author richa_bfe6tpy
 */
//Controller for the secretary main control panel view 
public class SecretaryController {
    //Variables declaration
    private SecretaryView theView;
    private Secretary theModel;
    
    public SecretaryController(SecretaryView theView,Secretary theModel)
    {
        //Construct the controller
        this.theView = theView;
        this.theModel = theModel;
       
        //Connect buttons
        this.theView.addSecratryApprovePatientListener(new SecretaryApprovePatientListener());
        this.theView.addSecratryCreateAppointmentListener(new SecretaryCreateAppointmentListener());
        this.theView.addSecratryOrderMedicineListener(new SecretaryOrderMedicineListener());
        this.theView.addSecratryRemovePatientListener(new SecretaryDeleteUserListener());
        this.theView.addSecratryRemovePatientRequestListener(new SecretaryDeletePatientRequestListener());
        this.theView.addSecratryCompletePerscriptionListener(new SecretaryCompletePerscriptionListener());
        this.theView.addLogoutListener(new LogoutListener());
        this.theView.addSecretaryApproveAppointmentListener(new SecretaryApproveAppointmentListener());
        
        
        if (!theModel.getMedicineOutOfStock().isEmpty()){SecretaryMedicineRequest();};
        if (!theModel.getAllRequests().isEmpty()){requestsDialog();};
    }
    
    //Switch to Secretary Approve Patient view and controller on button press
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
    
    //Switch to Secretary create appointment view and controller on button press
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
    
    //Switch to Secretary order medicine view and controller on button press
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
    
    //Switch to Secretary delete patient request view and controller on button press
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
    
    //Switch to Secretary delete patient manual view and controller on button press
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
    
    //Switch to Secretary complete perscription view and controller on button press
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
    
    
    //return to login view and controller on button press
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
    
    
    //Switch to Secretary approve appointment request view and controller on button press
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
    
    public void SecretaryMedicineRequest(){
        
        //Creates a new thread to improve flow of program
        Thread t = new Thread(new Runnable(){
            public void run(){
                String message = "";
                for (Medicine m : theModel.getMedicineOutOfStock())
                {
                    message = message.concat(m + "\n"); //displays all medicines out of stock
                }
                JOptionPane.showMessageDialog(null, message, "These medicines are out of stock:", JOptionPane.PLAIN_MESSAGE);
            }
            });
        
        t.start();
        
        
    }
    
    public void requestsDialog(){
        //Creates a new thread to improve flow of program
        Thread t = new Thread(new Runnable(){
            public void run(){
                String message = "";
                for (Request m : theModel.getAllRequests())
                {
                    if(!m.getCompleted())
                    {  
                    message = message.concat("Type:" + m.getType() +"\nDetails:\n"+m.toString()+"\n\n"); //displays all medicines out of stock
                    }
                }
                if (!"".equals(message)){
                    JOptionPane.showMessageDialog(null, message, "Current Requests:", JOptionPane.PLAIN_MESSAGE);
                    }
            }
            });
        
        t.start();
    }
    
    
    
    
}
