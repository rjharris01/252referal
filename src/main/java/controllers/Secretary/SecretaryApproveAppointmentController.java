/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Secretary;

import Views.Secretary.SecretaryApproveAppointmentView;
import Views.Secretary.SecretaryView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.SwingConstants;
import models.NewAppointmentRequest;
import models.Request;
import models.user.Secretary;

/**
 *
 * @author richa_bfe6tpy
 */
//Controller for the secretary approve appointment view
public class SecretaryApproveAppointmentController {
    
    private SecretaryApproveAppointmentView theView;
    private Secretary theModel;
    
    
    public SecretaryApproveAppointmentController(SecretaryApproveAppointmentView theView, Secretary theModel){
        //Construct the controller
        this.theView = theView;
        this.theModel = theModel;
        //set appointment list on load
        setAppointmentList();
        //Connect buttons
        this.theView.addAcceptListener(new SubmitListener());
        this.theView.addBackListener(new BackListener());
        this.theView.addDeclineListener(new DeclineListener());
    }
    
    //appointment request list loaded and set in the the view list 
    public void setAppointmentList(){
        ArrayList<NewAppointmentRequest> newAppointmentRequest = theModel.getAllNewAppointmentRequest();
        DefaultListModel<NewAppointmentRequest> tempModel = new DefaultListModel<>();

        for (NewAppointmentRequest request: newAppointmentRequest)
        {
            tempModel.addElement(request);
        }        
        
        this.theView.setAppointmentsRequests(tempModel);
    }
    
    //on submit get request and approve it 
    class SubmitListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            NewAppointmentRequest newAppointment = theView.getSelectedAppointmentRequest(); //get request
            theModel.approveAppointmentRequest(newAppointment);//approve request
            theModel.deleteRequest((Request)newAppointment);//remove it from requests
            setAppointmentList();//reset the appointment request list
            theModel.updateUser();
        }
        
    }
    
    //return to secretary control panel on button press
    class BackListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            SecretaryView secretaryView = new SecretaryView();
            SecretaryController secretaryController = new SecretaryController(secretaryView,theModel);
            theView.setVisible(false);
            secretaryView.setVisible(true);
            theView.getParent().add(secretaryView,SwingConstants.CENTER);
        }
        
    }
    
    //on submit get request and delete it 
    class DeclineListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            NewAppointmentRequest newAppointment = theView.getSelectedAppointmentRequest();
            theModel.deleteRequest((Request)newAppointment);
            setAppointmentList();
        }
        
    }
}
