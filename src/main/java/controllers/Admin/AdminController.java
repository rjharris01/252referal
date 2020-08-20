/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Admin;

import Views.Admin.AdminCreateAccountView;
import Views.Admin.AdminDoctorFeedBackView;
import Views.Admin.AdminModifyDoctorsView;
import Views.Admin.AdminModifySecretariesView;
import Views.Admin.AdminView;
import Views.Admin.AdminViewRatingsView;
import Views.LoginView;
import controllers.LoginController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import models.user.Administrator;
import models.user.User;

/**
 *
 * @author richa_bfe6tpy
 */
//Controller for the Admin control panel view 
public class AdminController {
    private AdminView theView;
    private Administrator theModel;
    
    public AdminController(AdminView theView,Administrator theModel)
    {
        //Construct the controller
        this.theView = theView;
        this.theModel = theModel;
        //Connect buttons
        this.theView.addAdminCreateAccountListener(new AdminCreateAccountListener());
        this.theView.addAdminModifyDoctorsListener(new AdminModifyDoctorsListener());
        this.theView.addAdminViewRatingsListener(new AdminViewRatingsListener());
        this.theView.addAdminModifySecretariesListener(new AdminModifySecretariesListener());
        this.theView.addAdminLogoutListener(new AdminLogoutListener());
        this.theView.addDoctorFeedbackListener(new AdminDoctorFeedbackListener());
    }
    
    //Switch to admin create account view and controller on button press
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
    
    //Switch to admin modifiy doctors view and controller on button press
    class AdminModifyDoctorsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
                AdminModifyDoctorsView newView = new AdminModifyDoctorsView();
                
                
                AdminModifyDoctorsController theController = new AdminModifyDoctorsController(newView, theModel);
                theView.setVisible(false);
                newView.setVisible(true);
                theView.getParent().add(newView,SwingConstants.CENTER);
        }
        
    }
    
    //Switch to admin generate doctor feedback view and controller on button press
    class AdminDoctorFeedbackListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
                AdminDoctorFeedBackView newView = new AdminDoctorFeedBackView();
                
                
                AdminDoctorFeedBackController theController = new AdminDoctorFeedBackController(newView, theModel);
                theView.setVisible(false);
                newView.setVisible(true);
                theView.getParent().add(newView,SwingConstants.CENTER);
        }
        
    }
    
    //Switch to admin view ratings and controller on button press
    class AdminViewRatingsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            AdminViewRatingsView newView = new AdminViewRatingsView();
            AdminViewRatingsController theController = new AdminViewRatingsController(newView, theModel);
            theView.setVisible(false);
            newView.setVisible(true);
            theView.getParent().add(newView,SwingConstants.CENTER);
        }
        
    }
    
    //Switch to login and set account login status to false view and controller on button press
    class AdminLogoutListener implements ActionListener {

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
    
    //Switch to admin modify secretaries view and controller on button press
    class AdminModifySecretariesListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
                AdminModifySecretariesView newView = new AdminModifySecretariesView();
                
                
                AdminModifySecretariesController theController = new AdminModifySecretariesController(newView, theModel);
                theView.setVisible(false);
                newView.setVisible(true);
                theView.getParent().add(newView,SwingConstants.CENTER);
        }
        
    }
}
