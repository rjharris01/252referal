/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Secretary;

import Views.Admin.AdminView;
import Views.Secretary.SecretaryView;
import controllers.Admin.AdminController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.user.Administrator;
import models.user.Secretary;

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
       
        
        this.theView.addSecratryApprovePatientListener(new SecratryApprovePatientListener());
        this.theView.addSecratryCreateAppointmentListener(new SecratryCreateAppointmentListener());
        this.theView.addSecratryOrderMedicineListener(new SecratryOrderMedicineListener());
        this.theView.addSecratryRemovePatientListener(new SecratryRemovePatientListener());
        this.theView.addSecratryRemovePatientRequestListener(new SecratryRemovePatientRequestListener());
        this.theView.addSecratryCompletePerscriptionListener(new SecratryCompletePerscriptionListener());
        this.theView.addLogoutListener(new LogoutListener());
        this.theView.addSecretaryApproveAppointmentListener(new SecretaryApproveAppointmentListener());
        
        
    }
    
    class SecratryApprovePatientListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
    class SecratryCreateAppointmentListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
    class SecratryOrderMedicineListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
    class SecratryRemovePatientListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
    class SecratryRemovePatientRequestListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
    class SecratryCompletePerscriptionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
    class LogoutListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
    class SecretaryApproveAppointmentListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
    
}
