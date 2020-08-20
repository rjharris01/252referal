/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Doctor;
import Views.Doctor.DoctorView;
import Views.Doctor.DoctorCreateNewMedicineView;
import Views.Doctor.DoctorCreatePerscriptionView;
import Views.Doctor.DoctorStartAppointmentView;
import Views.Doctor.DoctorViewPatientView;
import Views.Doctor.DoctorViewAppointmentsView;
import Views.LoginView;
import controllers.LoginController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import models.user.Doctor;
import models.user.User;

/**
 *
 * @author richa_bfe6tpy
 */
//Controller for the doctor main control view 
public class DoctorController {
    //Variables declaration
    private DoctorView theView;
    private Doctor theModel;
    
    public DoctorController(DoctorView theView,Doctor theModel)
    {
        //Construct the controller
        this.theView = theView;
        this.theModel = theModel;
        //Connect buttons
        this.theView.addStartAppointmentListener(new StartAppointmentListener());
        this.theView.addCreatePerscriptionListener(new CreatePerscriptionListener());
        this.theView.addViewAppointmentListener(new ViewAppointmentListener());
        this.theView.addViewPatientHistoryListener(new ViewPatientHistoryListener());
        this.theView.addCreateNewMedicineListener(new CreateNewMedicineListener());
        this.theView.addLogoutListener(new LogoutListener());
    }
    
    //Switch to doctor start appointment view and controller on button press
    class StartAppointmentListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            DoctorStartAppointmentView newView = new DoctorStartAppointmentView();
            DoctorStartAppointmentController theController = new DoctorStartAppointmentController(newView,theModel);
            theView.setVisible(false);
            newView.setVisible(true);
            theView.getParent().add(newView,SwingConstants.CENTER);
        }
        
    }
    
    //Switch to doctor create perscription view and controller on button press
    class CreatePerscriptionListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            DoctorCreatePerscriptionView newView = new DoctorCreatePerscriptionView();
            DoctorCreatePerscriptionController theController = new DoctorCreatePerscriptionController(newView,theModel);
            theView.setVisible(false);
            newView.setVisible(true);
            theView.getParent().add(newView,SwingConstants.CENTER);
        }
        
    }
    
    //Switch to doctor view appointment view and controller on button press
    class ViewAppointmentListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            DoctorViewAppointmentsView newView = new DoctorViewAppointmentsView();
            DoctorViewAppointmentsController theController = new DoctorViewAppointmentsController(newView,theModel);
            theView.setVisible(false);
            newView.setVisible(true);
            theView.getParent().add(newView,SwingConstants.CENTER);
        }
        
    }
    
    //Switch to doctor view patient view and controller on button press
    class ViewPatientHistoryListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            DoctorViewPatientView newView = new DoctorViewPatientView();
            DoctorViewPatientController theController = new DoctorViewPatientController(newView,theModel);
            theView.setVisible(false);
            newView.setVisible(true);
            theView.getParent().add(newView,SwingConstants.CENTER);
        }
        
    }
    
    //Switch to doctor create new medicine view and controller on button press
    class CreateNewMedicineListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            DoctorCreateNewMedicineView newView = new DoctorCreateNewMedicineView();
            DoctorCreateNewMedicineController theController = new DoctorCreateNewMedicineController(newView,theModel);
            theView.setVisible(false);
            newView.setVisible(true);
            theView.getParent().add(newView,SwingConstants.CENTER);
        }
        
    }
    
    //return to sign-in view and controller on button press
    class LogoutListener implements ActionListener
    {

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
