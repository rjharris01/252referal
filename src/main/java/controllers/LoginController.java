/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import controllers.Admin.AdminController;
import Views.Admin.AdminView;
import Views.Doctor.DoctorView;
import controllers.Doctor.DoctorController;
import Views.LoginView;
import Views.Patient.PatientView;
import Views.Secretary.SecretaryView;
import Views.SignupView;
import controllers.Patient.PatientController;
import controllers.Secretary.SecretaryController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import models.user.Administrator;
import models.user.Patient;
import models.user.Secretary;
import models.user.Doctor;
import models.user.User;

/**
 *
 * @author richa_bfe6tpy
 */
//Controller for the login view 
public class LoginController {
    
    //Variables declaration
    private LoginView theView;
    private User theModel;
    
    public LoginController(LoginView theView, User theModel){
        //Construct the controller
        this.theView = theView;
        this.theModel = theModel;
        //Connect buttons
        this.theView.addLoginListener(new LoginListener());
        this.theView.addSignupListener(new SignupListener());
    }
    
    //Switch to signup view and controller on button press
    class SignupListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            SignupView newView = new SignupView();
            User newModel = new User() {};    
            SignupController theController = new SignupController(newView, newModel);
            theView.setVisible(false);
            newView.setVisible(true);
            theView.getParent().add(newView,SwingConstants.CENTER);
            
            
        }
        
    }
    
    
    //check login details on button press
    class LoginListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
             String username; 
             String password;
             
             ArrayList<User> users = theModel.getAllUsers();
             try
                {
                    username = theView.getUserName();
                    password = Arrays.toString(theView.getPassword());
            for(User user : users)
            {
                if (user.getUserId().equals(username)) //check if username exists
                {
                    if(user.getPassword().equals(password))//check if password is correct
                    {
                        user.setLoginStatus(true);
                        theView.setVisible(false);
                        theModel = user;
                        openCurrentPanel(theModel);
                        
                    
                    }
                    
                    else{
                        JOptionPane.showMessageDialog(null, "Incorrect login details / User not found"); 
                    }
                }
                
                
            }
            
            if(theModel.getLoginStatus() == null)
            {
                
              JOptionPane.showMessageDialog(null, "Incorrect login details / User not found");
                    
            }
        }

        catch(Exception x)
        {
            System.out.print(x);
        }
             
             
        }
    
    }
    
    
    //Switch to correct user view and controller on button press
    public void openCurrentPanel(User user)
    {
        String userId = user.getUserId();
        userId = userId.substring(0, 1);
        if (null != userId)
        switch (userId) {
            case "A":
                //Admin
                AdminView adminView = new AdminView();
                Administrator adminModel = (Administrator)user;
                AdminController adminController = new AdminController(adminView,adminModel);
                this.theView.setVisible(false);
                adminView.setVisible(true);
                this.theView.getParent().add(adminView,SwingConstants.CENTER);
                
                
                break;
            case "D":
                //Doctor
                DoctorView docView = new DoctorView();
                Doctor docModel = (Doctor) user;
                DoctorController DoctorController = new DoctorController(docView,docModel);
                this.theView.setVisible(false);
                docView.setVisible(true);
                this.theView.getParent().add(docView,SwingConstants.CENTER);
                break;
                
            case "P":
                //Patient
                PatientView patView = new PatientView();
                Patient patModel = (Patient) user;
                PatientController patientController = new PatientController(patView,patModel);
                this.theView.setVisible(false);
                patView.setVisible(true);
                this.theView.getParent().add(patView,SwingConstants.CENTER);
                
                break;
            case "S":
                //Secretary
                SecretaryView secView = new SecretaryView();
                Secretary secModel = (Secretary)user;              
                SecretaryController secretaryController = new SecretaryController(secView,secModel);
                this.theView.setVisible(false);
                secView.setVisible(true);
                this.theView.getParent().add(secView,SwingConstants.CENTER);
                break;
            default:
                break;
        }
    }
 }



