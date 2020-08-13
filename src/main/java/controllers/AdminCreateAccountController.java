/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Views.AdminCreateAccountView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import models.user.Administrator;
import models.user.User;


/**
 *
 * @author richa_bfe6tpy
 */
public class AdminCreateAccountController {
    private AdminCreateAccountView theView;
    private Administrator theModel;
    private Boolean first;
    
    
    public AdminCreateAccountController(AdminCreateAccountView theView, Administrator theModel, Boolean first){
        
        this.theView = theView;
        this.theModel = theModel;
        this.first = first;
        
        if (first)
        {
            theView.setFirstAccountType();
        }
        
        this.theView.addSubmitListener(new SubmitListener());
        
    }
    
    class SubmitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try
            {
       
                
                userFactory NewUserFactory = new userFactory();
                User user = (User) NewUserFactory.makeNewUser(theView.getAccountType(), theView.getAccountName(), theView.getAccountPassword(),theView.getAccountAddress());
                JOptionPane.showMessageDialog(null, "Account\n"+ user.getUserId() + "\nCreated");
                
                
                
            
            } catch(Exception ex)
            {
                
                
            }
            
        }
    
    }
        
    
    
}
