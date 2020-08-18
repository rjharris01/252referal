/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Doctor;

import Views.Doctor.DoctorView;
import Views.Doctor.DoctorViewPatientView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.SwingConstants;
import models.Appointment;
import models.user.Doctor;
import models.user.Patient;

/**
 *
 * @author richa_bfe6tpy
 */
public class DoctorViewPatientController {
    private DoctorViewPatientView theView;
    private Doctor theModel;
    
    public DoctorViewPatientController(DoctorViewPatientView theView,Doctor theModel)
    {
        this.theView = theView;
        this.theModel = theModel;
        
        setPatients();
        
        this.theView.addBackListener(new BackListener());
        this.theView.addSelectListener(new SelectListener());
    }
    
    class SelectListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            Patient selectedPatient = theView.getDoctorViewPatientHistoryPatientBox();
            ArrayList<Appointment> appointments = selectedPatient.getAllAppointments();
            DefaultListModel<Appointment> model = new DefaultListModel();
            for(Appointment app : appointments)
            {
                model.addElement(app);
            }
            
            theView.setDoctorViewPatientHistoryList(model);
            
        }
        
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
    
    public void setPatients()
    {
        ArrayList<Patient> patients = theModel.getAllPatients();
        DefaultComboBoxModel<Patient> model = new DefaultComboBoxModel();
        for(Patient p: patients)
        {
            model.addElement(p);
        }
        theView.setDoctorViewPatientHistoryPatientBox(model);
    }
    
    
}
