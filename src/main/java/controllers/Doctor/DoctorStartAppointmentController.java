/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Doctor;

import Views.Doctor.DoctorStartAppointmentView;
import Views.Doctor.DoctorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import models.Appointment;
import models.user.Doctor;

/**
 *
 * @author richa_bfe6tpy
 */
public class DoctorStartAppointmentController {
    private DoctorStartAppointmentView theView;
    private Doctor theModel;
    
    public DoctorStartAppointmentController(DoctorStartAppointmentView theView,Doctor theModel)
    {
        this.theView = theView;
        this.theModel = theModel;
        
        setAppointments();
        
        this.theView.addBackListener(new BackListener());
        this.theView.addSubmitListener(new SubmitListener());
    }
    
    public void setAppointments()
    {
        ArrayList<Appointment> appointments = theModel.getAllAppointments();
        DefaultComboBoxModel<Appointment> model = new DefaultComboBoxModel();
        for(Appointment a: appointments){
            model.addElement(a);
        }
        theView.setAppointments(model);
    }
    
    class SubmitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Appointment tempAppointment = theView.getAppointment();
            tempAppointment.setComments(theView.getAppointmentComments());
            tempAppointment.updateAppointment();
            theView.resetComments();
        }
        
    }
    
    class BackListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            DoctorView doctorView = new DoctorView();
            DoctorController DoctorController = new DoctorController(doctorView,theModel);
            theView.setVisible(false);
            doctorView.setVisible(true);
            theView.getParent().add(doctorView,SwingConstants.CENTER);
        }
        
    }
    
}
