/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Secretary;

import Views.Secretary.SecretaryDeleteUserRequestView;
import Views.Secretary.SecretaryView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.SwingConstants;
import models.AccountDeleteRequest;
import models.user.Secretary;
import models.user.User;

/**
 *
 * @author richa_bfe6tpy
 */
public class SecretaryDeleteUserRequestController {
    private SecretaryDeleteUserRequestView theView;
    private Secretary theModel;
    
    
    public SecretaryDeleteUserRequestController(SecretaryDeleteUserRequestView theView, Secretary theModel){
        
        this.theView = theView;
        this.theModel = theModel;
       
        this.theView.addBackListener(new BackListener());
        this.theView.addDeleteListener(new DeleteListener());
        
        setPatientList();
    }
    
    public void setPatientList(){
        DefaultListModel<AccountDeleteRequest> model = new DefaultListModel<>();
        theView.clearList();
        ArrayList<AccountDeleteRequest> allUsers = theModel.getAllAccountDeleteRequest();
         for (AccountDeleteRequest request: allUsers)
            {
                model.addElement(request);
            }
        theView.setAccountDeleteManualList(model);
    }
    
    class BackListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            SecretaryView secretaryView = new SecretaryView();
            SecretaryController secretarController = new SecretaryController(secretaryView,theModel);
            theView.setVisible(false);
            secretaryView.setVisible(true);
            theView.getParent().add(secretaryView,SwingConstants.CENTER);
        }
        
    }
    
    class DeleteListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                    AccountDeleteRequest user = theView.getSelectedUser();
                    theModel.deleteUser(user.getUserId());
                    theModel.deleteRequest(user);
                    setPatientList();
                 
                    
                   
                    
        }
         catch(java.lang.NullPointerException ex)
        {
            System.out.print("No Account selected");
        }
        }
        
    }
}
