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
import javax.swing.SwingConstants;
import models.user.Administrator;
import models.user.User;

/**
 *
 * @author richa_bfe6tpy
 */
public class AdminModifySecretariesController {
    private AdminModifySecretariesView theView;
    private Administrator theModel;
    
    
    public AdminModifySecretariesController(AdminModifySecretariesView theView, Administrator theModel){
        
        this.theView = theView;
        this.theModel = theModel;
        
        
        this.theView.addBackListener(new BackListener());
        this.theView.addDeleteListener(new DeleteListener());
        
        setSecretaryList();
    }
    
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
    
    class DeleteListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
             
             try{
                    User user = theView.getSelectedUser();
                    theModel.deleteUser(user.getUserId());
                    setSecretaryList();
                 
                    
                   
                    
        }
         catch(java.lang.NullPointerException ex)
        {
            System.out.print("No Account selected");
        }
                     
        }
    }
    
    public void setSecretaryList()
    {
        theView.clearList();
        theView.setSecretaryList(theModel.getAllSecretaries());
    }
    
}