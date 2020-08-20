/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Admin;

import Views.Admin.AdminModifySecretariesView;
import Views.Admin.AdminView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.SwingConstants;
import models.user.Administrator;
import models.user.Secretary;

/**
 *
 * @author richa_bfe6tpy
 */
//Controller for the login view
public class AdminModifySecretariesController {
    //Variables declaration
    private AdminModifySecretariesView theView;
    private Administrator theModel;
    
    
    public AdminModifySecretariesController(AdminModifySecretariesView theView, Administrator theModel){
         //Construct the controller
        this.theView = theView;
        this.theModel = theModel;
        //Connect buttons
        this.theView.addBackListener(new BackListener());
        this.theView.addDeleteListener(new DeleteListener());
        //Set the secretary list
        setSecretaryList();
    }
    
    //return to admin control panel on button press
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
    
    //delete selected user on button press
    class DeleteListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
             
             try{
                    Secretary secretary = theView.getSelectedUser();//gets selected user
                    theModel.deleteUser(secretary.getUserId());//delete user from user.ser file
                    setSecretaryList();//resets the list of users
                 
                    
                   
                    
        }
         catch(java.lang.NullPointerException ex)
        {
            System.out.print("No Account selected");
        }
                     
        }
    }
    
     //set the list model of Secretarys
    public void setSecretaryList()
    {
        theView.clearList();
        ArrayList<Secretary> Secretaries = theModel.getAllSecretaries();
        DefaultListModel<Secretary> model = new DefaultListModel();
        for(Secretary s: Secretaries)
            {
                model.addElement(s);
            }
        theView.setSecretaryList(model);
    }
    
}