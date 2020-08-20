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

/**
 *
 * @author richa_bfe6tpy
 */
//Controller for the delete user request view 
public class SecretaryDeleteUserRequestController {
    //Variables declaration
    private SecretaryDeleteUserRequestView theView;
    private Secretary theModel;
    
    
    public SecretaryDeleteUserRequestController(SecretaryDeleteUserRequestView theView, Secretary theModel){
        //Construct the controller
        this.theView = theView;
        this.theModel = theModel;
        //Connect buttons
        this.theView.addBackListener(new BackListener());
        this.theView.addDeleteListener(new DeleteListener());
        //set patient list on load
        setPatientList();
    }
    
    //set patient list based on account delete requests
    public void setPatientList(){
        DefaultListModel<AccountDeleteRequest> model = new DefaultListModel<>();
        theView.clearList();
        ArrayList<AccountDeleteRequest> allUsers = theModel.getAllAccountDeleteRequest(); //get accounts requested to be delete
         for (AccountDeleteRequest request: allUsers)
            {
                model.addElement(request);//set each request
            }
        theView.setAccountDeleteManualList(model);//set model
    }
    
    //return to secretary control panel
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
    
    //on button press delete selected user
    class DeleteListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                    AccountDeleteRequest user = theView.getSelectedUser();//get selected user
                    theModel.deleteUser(user.getUserId());//delete user
                    theModel.deleteRequest(user);//remove the request
                    setPatientList();//reset the patient list
                 
                    
                   
                    
        }
         catch(java.lang.NullPointerException ex)
        {
            System.out.print("No Account selected");
        }
        }
        
    }
}
