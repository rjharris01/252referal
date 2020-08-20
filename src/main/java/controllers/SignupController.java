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
//Controller for the signup view 
public class SignupController {
    
    //Variables declaration
    private SignupView theView;
    private User theModel;
    
    public SignupController(SignupView theView,User theModel)
    {
        //Construct the controller
        this.theView = theView;
        this.theModel = theModel;
        //Connect buttons
        this.theView.addSubmitListener(new SubmitListener());
        this.theView.addBackListener(new BackListener());
        
    }
    
    //Create a new account request and Switch to login view and controller on button press
    class SubmitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try
            {
                
                LocalDate tempDate = LocalDate.of(theView.getSignupDateYear(), theView.getSignupDateMonth(), theView.getSignupDateDay()); //set temp date from view ints 
                
                UserFactory NewUserFactory = new UserFactory(); //new user factory instance
                User user = (User) NewUserFactory.makeNewUser("Patient", theView.getSignupName(), theView.getSignupPasswordField(),theView.getSignupAddressName(),theView.getSignupGenderSelector(),tempDate); //pass values to create new account request
               
                //display pop to user
                JOptionPane.showMessageDialog(null, "Account Requested Created");
                
                
                //return to the login view
                theModel.setLoginStatus(false);
                LoginView newView = new LoginView();
                User newModel = new User() {};    
                
                LoginController theController = new LoginController(newView, newModel);
                theView.setVisible(false);
                newView.setVisible(true);
                theView.getParent().add(newView,SwingConstants.CENTER);
                
            
            } catch(Exception ex)
                    {
                
                
                     }
            
            }
    }
    
    
    //Switch to login view and controller on button press
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
