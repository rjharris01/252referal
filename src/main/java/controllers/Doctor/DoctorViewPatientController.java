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
//Controller for the doctor view patient view
public class DoctorViewPatientController {
    //Variables declaration
    private DoctorViewPatientView theView;
    private Doctor theModel;
    
    public DoctorViewPatientController(DoctorViewPatientView theView,Doctor theModel)
    {
        //Construct the controller
        this.theView = theView;
        this.theModel = theModel;
        //set patients list on load
        setPatients();
        //Connect buttons
        this.theView.addBackListener(new BackListener());
        this.theView.addSelectListener(new SelectListener());
    }
    
    //on button set the list to all of the selected users appointments 
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
    //return to doctor control panel on button press
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
    
    //set the patients list 
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
