/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Patient;

import Views.Patient.PatientLeaveFeedbackForDoctorView;
import Views.Patient.PatientView;
import controllers.Secretary.SecretaryAppointmentController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import models.Appointment;
import models.Rating;
import models.user.Doctor;
import models.user.Patient;

/**
 *
 * @author richa_bfe6tpy
 */
public class PatientLeaveFeedbackForDoctorController {
    
    private PatientLeaveFeedbackForDoctorView theView;
    private Patient theModel;
    
    public PatientLeaveFeedbackForDoctorController(PatientLeaveFeedbackForDoctorView theView,Patient theModel)
    {
        this.theView = theView;
        this.theModel = theModel;
        
        this.theView.addSubmitListener(new SubmitListener());
        this.theView.addBackListener(new BackListener());
        setAppointments();
    }
    
    public void setAppointments(){
            
            ArrayList<Appointment> allAppointments;
                
            DefaultComboBoxModel<Appointment> appointments = new DefaultComboBoxModel<>();
            
            allAppointments =  theModel.getAllAppointments();
            for (Appointment appointment: allAppointments)
            {
                    appointments.addElement(appointment);
            }
            this.theView.setPatientFeedbackAppointmentBox(appointments);
    }
    
    class SubmitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                Appointment appointment = theView.getAppointment();
                Doctor doctor =  appointment.getDoctor();
                Patient patient = appointment.getPatient();
                Rating rating = new Rating();
                rating.setDoctor(doctor);
                rating.setPatient(patient);
                rating.setRating(theView.getRating());
                rating.setComments(theView.getComment());
                rating.setAppointment(appointment);
                
                doctor.addRating(rating);
                
                } catch(Exception ex)
                    
                {

                    System.out.print(ex);
                }
        }
    
    }
    
    class BackListener implements ActionListener{

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
