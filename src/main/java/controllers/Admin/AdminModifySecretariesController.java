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
                    Secretary secretary = theView.getSelectedUser();
                    theModel.deleteUser(secretary.getUserId());
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
        ArrayList<Secretary> Secretaries = theModel.getAllSecretaries();
        DefaultListModel<Secretary> model = new DefaultListModel();
        for(Secretary s: Secretaries)
            {
                model.addElement(s);
            }
        theView.setSecretaryList(model);
    }
    
}