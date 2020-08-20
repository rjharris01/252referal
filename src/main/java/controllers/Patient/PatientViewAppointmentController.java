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
//Controller for the patient view appointment view
public class PatientViewAppointmentController {
    //Variables declaration
    private PatientViewAppointmentView theView;
    private Patient theModel;
    
    public PatientViewAppointmentController(PatientViewAppointmentView theView,Patient theModel)
    {
        //Construct the controller
        this.theView = theView;
        this.theModel = theModel;
        //Connect buttons
        this.theView.addPatientViewAppointmentBackButton(new PatientViewAppointmentBackListener());
        //set upcoming appoinments list on load
        setUpcoming();
        
    }
    
    //set upcoming appointments list based on user logged in
    public void setUpcoming(){
        ArrayList<Appointment> appointments = theModel.getAllFutureAppointments();//get users appoinments list
        DefaultListModel<Appointment> tempModel = new DefaultListModel<>();

        for (Appointment appointment: appointments)
        {
            tempModel.addElement(appointment);
        }        
        
        this.theView.setPatientHistory(tempModel);//set appointment list
    }
    
    //return to patient control panel 
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
