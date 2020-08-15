/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Patient;

import Views.Patient.PatientView;
import Views.Patient.PatientViewAppointmentView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.SwingConstants;
import models.Appointment;
import models.user.Patient;

/**
 *
 * @author richa_bfe6tpy
 */
public class PatientViewAppointmentController {
    private PatientViewAppointmentView theView;
    private Patient theModel;
    
    public PatientViewAppointmentController(PatientViewAppointmentView theView,Patient theModel)
    {
        this.theView = theView;
        this.theModel = theModel;
        
        this.theView.addPatientViewAppointmentBackButton(new PatientViewAppointmentBackListener());
        setUpcoming();
        
    }
    
    public void setUpcoming(){
        ArrayList<Appointment> appointments = theModel.getAllFutureAppointments();
        DefaultListModel<Appointment> tempModel = new DefaultListModel<>();

        for (Appointment appointment: appointments)
        {
            tempModel.addElement(appointment);
        }        
        
        this.theView.setPatientHistory(tempModel);
    }
    
    class PatientViewAppointmentBackListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            PatientView patientView = new PatientView();
            PatientController patientController = new PatientController(patientView,theModel);
            theView.setVisible(false);
            patientView.setVisible(true);
            theView.getParent().add(patientView,SwingConstants.CENTER);
        }
        
    }
}
