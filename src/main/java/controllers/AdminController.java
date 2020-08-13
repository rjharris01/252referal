/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Views.AdminCreateAccountView;
import Views.AdminView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import models.user.Administrator;

/**
 *
 * @author richa_bfe6tpy
 */
public class AdminController {
    private AdminView theView;
    private Administrator theModel;
    
    public AdminController(AdminView theView,Administrator theModel)
    {
        this.theView = theView;
        this.theModel = theModel;
        
        this.theView.addAdminCreateAccountListener(new AdminCreateAccountListener());
        this.theView.addAdminModifyDoctorsListener(new AdminModifyDoctorsListener());
        this.theView.addAdminViewRatingsListener(new AdminViewRatingsListener());
        this.theView.addAdminModifySecretariesListener(new AdminModifySecretariesListener());
        this.theView.addAdminLogoutListener(new AdminLogoutListener());
    }
    
    class AdminCreateAccountListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
                AdminCreateAccountView newView = new AdminCreateAccountView();
                
                
                AdminCreateAccountController theController = new AdminCreateAccountController(newView, theModel, false);
                theView.setVisible(false);
                newView.setVisible(true);
                theView.getParent().add(newView,SwingConstants.CENTER);
        }
        
    }
    
    class AdminModifyDoctorsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
    class AdminViewRatingsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
    class AdminLogoutListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
    class AdminModifySecretariesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
}
