/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Doctor;
import Views.Doctor.DoctorView;
import Views.Doctor.DoctorCreateNewMedicineView;
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
public class DoctorController {
    private DoctorView theView;
    private Doctor theModel;
    
    public DoctorController(DoctorView theView,Doctor theModel)
    {
        this.theView = theView;
        this.theModel = theModel;
        
        this.theView.addStartAppointmentListener(new StartAppointmentListener());
        this.theView.addViewAppointmentListener(new ViewAppointmentListener());
        this.theView.addViewPatientHistoryListener(new ViewPatientHistoryListener());
        this.theView.addCreateNewMedicineListener(new CreateNewMedicineListener());
        this.theView.addLogoutListener(new LogoutListener());
    }
    
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
    
    class ViewPatientHistoryListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
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
