/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Doctor;

import Views.Doctor.DoctorView;
import Views.Doctor.DoctorViewAppointmentsView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.SwingConstants;
import models.Appointment;
import models.user.Doctor;

/**
 *
 * @author richa_bfe6tpy
 */
public class DoctorViewAppointmentsController {
    private DoctorViewAppointmentsView theView;
    private Doctor theModel;
    
    public DoctorViewAppointmentsController(DoctorViewAppointmentsView theView,Doctor theModel)
            {
                this.theView = theView;
                this.theModel = theModel;
                
                setAppointments();
                
                this.theView.addBackListener(new BackListener());
            }
    
    public void setAppointments()
    {
        ArrayList<Appointment> appointments = theModel.getAllAppointments();
        DefaultListModel<Appointment> model = new DefaultListModel();
        
        for(Appointment a : appointments)
        {
            model.addElement(a);
        }
        
        theView.setDoctorViewAppointmentsList(model);
    }
    
    class BackListener implements ActionListener
    {
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
