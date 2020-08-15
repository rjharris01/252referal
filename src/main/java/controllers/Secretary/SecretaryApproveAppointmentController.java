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
import models.AppointmentRequest;
import models.NewAppointmentRequest;
import models.Request;
import models.user.Secretary;

/**
 *
 * @author richa_bfe6tpy
 */
public class SecretaryApproveAppointmentController {
    private SecretaryApproveAppointmentView theView;
    private Secretary theModel;
    
    
    public SecretaryApproveAppointmentController(SecretaryApproveAppointmentView theView, Secretary theModel){
        
        this.theView = theView;
        this.theModel = theModel;
       
        setAppointmentList();
        
        this.theView.addAcceptListener(new SubmitListener());
        this.theView.addBackListener(new BackListener());
        this.theView.addDeclineListener(new DeclineListener());
    }
    
    public void setAppointmentList(){
        ArrayList<NewAppointmentRequest> newAppointmentRequest = theModel.getAllNewAppointmentRequest();
        DefaultListModel<NewAppointmentRequest> tempModel = new DefaultListModel<>();

        for (NewAppointmentRequest request: newAppointmentRequest)
        {
            tempModel.addElement(request);
        }        
        
        this.theView.setAppointmentsRequests(tempModel);
    }
    
    class SubmitListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            NewAppointmentRequest newAppointment = theView.getSelectedAppointmentRequest();
            theModel.approveAppointmentRequest(newAppointment);
            theModel.deleteRequest((Request)newAppointment);
            setAppointmentList();
        }
        
    }
    
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
