/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Views.LoginView;
import Views.SignupView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import models.user.User;


/**
 *
 * @author richa_bfe6tpy
 */
public class SignupController {
    
    private SignupView theView;
    private User theModel;
    
    public SignupController(SignupView theView,User theModel)
    {
        this.theView = theView;
        this.theModel = theModel;
        
        this.theView.addSubmitListener(new SubmitListener());
        this.theView.addBackListener(new BackListener());
        
    }
    
    class SubmitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try
            {
                
                LocalDate tempDate = LocalDate.of(theView.getSignupDateYear(), theView.getSignupDateMonth(), theView.getSignupDateDay());
                
                userFactory NewUserFactory = new userFactory();
                User user = (User) NewUserFactory.makeNewUser("Patient", theView.getSignupName(), theView.getSignupPasswordField(),theView.getSignupAddressName(),theView.getSignupGenderSelector(),tempDate);
                JOptionPane.showMessageDialog(null, "Account\n"+ user.getUserId() + "\nCreated");
                
                
                
            
            } catch(Exception ex)
                    {
                
                
                     }
            
            }
    }
    
    class BackListener implements ActionListener{

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
