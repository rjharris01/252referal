/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Admin;

import Views.Admin.AdminCreateAccountView;
import Views.Admin.AdminView;
import controllers.UserFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import models.user.Administrator;
import models.user.User;


/**
 *
 * @author richa_bfe6tpy
 */
public class AdminCreateAccountController {
    
    //Variables declaration
    private AdminCreateAccountView theView;
    private Administrator theModel;
    private Boolean first;
    
    
    public AdminCreateAccountController(AdminCreateAccountView theView, Administrator theModel, Boolean first){
        
        //Construct the controller
        this.theView = theView;
        this.theModel = theModel;
        this.first = first;
        
        //listen if the account is the first account created
        if (first)
        {
            theView.setFirstAccountType();
        }
        
        //Connect buttons
        this.theView.addSubmitListener(new SubmitListener());
        this.theView.addBackListener(new BackListener());
        
    }
    
     //Create account on button press
    class SubmitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try
            {
       
                
                UserFactory NewUserFactory = new UserFactory();
                User user = (User) NewUserFactory.makeNewUser(theView.getAccountType(), theView.getAccountName(), theView.getAccountPassword(),theView.getAccountAddress(),null,null); //new user factory that creates a new user
                JOptionPane.showMessageDialog(null, "Account\n"+ user.getUserId() + "\nCreated");// notify that the account has been created
                
                
                
            
            } catch(Exception ex)
            {
                
                
            }
            
        }
    
    }
    
    //return to admin pannel on button press
    class BackListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            AdminView adminView = new AdminView();
            AdminController adminController = new AdminController(adminView,theModel);
            theView.setVisible(false);
            adminView.setVisible(true);
            theView.getParent().add(adminView,SwingConstants.CENTER);
        }
        
    }
        
    
    
}
