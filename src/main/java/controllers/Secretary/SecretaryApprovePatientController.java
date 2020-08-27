/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Secretary;

import Views.Secretary.SecretaryApprovePatientView;
import Views.Secretary.SecretaryView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import models.NewAccountRequest;
import models.user.Secretary;

/**
 *
 * @author richa_bfe6tpy
 */
//Controller for the secretary approve patient view 
public class SecretaryApprovePatientController {
    //Variables declaration
    private SecretaryApprovePatientView theView;
    private Secretary theModel;
    
    
    public SecretaryApprovePatientController(SecretaryApprovePatientView theView, Secretary theModel){
        //Construct the controller
        this.theView = theView;
        this.theModel = theModel;
        //set patient list on load
        setPatientList();
        //Connect buttons
        this.theView.addSubmitListener(new SubmitListener());
        this.theView.addBackListener(new BackListener());
        this.theView.addDeclineListener(new DeclineListener());
        
        
        
    }
    
    //set patient account request list from newaccount requests
    public void setPatientList(){
        
        ArrayList<NewAccountRequest> newAccountRequests = theModel.getAllNewAccountRequests();//get all new account requests
        DefaultListModel<NewAccountRequest> tempModel = new DefaultListModel<>();

        for (NewAccountRequest request: newAccountRequests)
        {
            tempModel.addElement(request);//add to list model
        }        
        
        this.theView.setUserRequests(tempModel);//set list model in view
        
    }
    
    
    //on button press delete new account request
    class DeclineListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            NewAccountRequest newAccount = theView.getSelectedUserRequest();
            theModel.declineAccountRequest(newAccount);
            setPatientList();
        }
        
    }
    
    //on button press return to secretary control panel
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
    
    //on button press create the new user based on seleceted request and output the new user id
    class SubmitListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            NewAccountRequest newAccount = theView.getSelectedUserRequest();//get selected request
            String userid = theModel.approveAccountRequest(newAccount);//create the new account 
            theModel.updateUser();
            JOptionPane.showMessageDialog(null, "Account\n"+ userid + "\nCreated");//return the user to the id
            setPatientList();//reset the patient request account list
            
        }
        
    }
}
