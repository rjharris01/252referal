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
import javax.swing.SwingConstants;
import models.NewAccountRequest;
import models.user.Secretary;

/**
 *
 * @author richa_bfe6tpy
 */
public class SecretaryApprovePatientController {
    private SecretaryApprovePatientView theView;
    private Secretary theModel;
    
    
    public SecretaryApprovePatientController(SecretaryApprovePatientView theView, Secretary theModel){
        
        this.theView = theView;
        this.theModel = theModel;
       
        setPatientList();
        
        this.theView.addSubmitListener(new SubmitListener());
        this.theView.addBackListener(new BackListener());
        this.theView.addDeclineListener(new DeclineListener());
        
        
        
    }
    
    public void setPatientList(){
        
        ArrayList<NewAccountRequest> newAccountRequests = theModel.getAllNewAccountRequests();
        DefaultListModel<NewAccountRequest> tempModel = new DefaultListModel<>();

        for (NewAccountRequest request: newAccountRequests)
        {
            tempModel.addElement(request);
        }        
        
        this.theView.setUserRequests(tempModel);
        
    }
    
    class DeclineListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            NewAccountRequest newAccount = theView.getSelectedUserRequest();
            theModel.declineAccountRequest(newAccount);
            setPatientList();
        }
        
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
    
    class SubmitListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            NewAccountRequest newAccount = theView.getSelectedUserRequest();
            theModel.approveAccountRequest(newAccount);
            setPatientList();
        }
        
    }
}
