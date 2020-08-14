/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Views.AdminView;
import Views.LoginView;
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
import models.user.User;

/**
 *
 * @author richa_bfe6tpy
 */
public class LoginController {
    
    
    private LoginView theView;
    private User theModel;
    
    public LoginController(LoginView theView, User theModel){
        
        this.theView = theView;
        this.theModel = theModel;
        
        this.theView.addLoginListener(new LoginListener());
    }
    
    
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
                if (user.getUserId().equals(username))
                {
                    if(user.getPassword().equals(password))
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
    
    public void openCurrentPanel(User user)
    {
        String userId = user.getUserId();
        userId = userId.substring(0, 1);
        if (null != userId)
        switch (userId) {
            case "A":
                AdminView newView = new AdminView();
                Administrator newModel = (Administrator)user;
                
                
                AdminController newController = new AdminController(newView,newModel);
                this.theView.setVisible(false);
                newView.setVisible(true);
                this.theView.getParent().add(newView,SwingConstants.CENTER);
                
                
                break;
            case "D":
                //to do doctor
                break;
            case "P":
                //to do patient
                //UserWelcomeLabel.setText("Welcome " + user.getName() + ",");
                
                break;
            case "S":
                //to do sec
                break;
            default:
                break;
        }
    }
}


