/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Patient;

import Views.Patient.PatientLeaveFeedbackForDoctorView;
import Views.Patient.PatientView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import models.Appointment;
import models.Rating;
import models.user.Doctor;
import models.user.Patient;

/**
 *
 * @author richa_bfe6tpy
 */
//Controller for the patient leave feedback view 
public class PatientLeaveFeedbackForDoctorController {
    
    private PatientLeaveFeedbackForDoctorView theView;
    private Patient theModel;
    
    public PatientLeaveFeedbackForDoctorController(PatientLeaveFeedbackForDoctorView theView,Patient theModel)
    {
        //Construct the controller
        this.theView = theView;
        this.theModel = theModel;
        //Connect buttons
        this.theView.addSubmitListener(new SubmitListener());
        this.theView.addBackListener(new BackListener());
        //set appointments list on load
        setAppointments();
    }
    
    //set appointments list based on the logged in user
    public void setAppointments(){
            
            ArrayList<Appointment> allAppointments;
                
            DefaultComboBoxModel<Appointment> appointments = new DefaultComboBoxModel<>();
            
            allAppointments =  theModel.getAllAppointments();//users appointments loaded
            for (Appointment appointment: allAppointments)
            {
                    appointments.addElement(appointment);
            }
            this.theView.setPatientFeedbackAppointmentBox(appointments);
    }
    
    //on button press create new rating for doctor
    class SubmitListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                Appointment appointment = (Appointment)theView.getAppointment(); //get the appointment
                Doctor doctor = theView.getAppointment().getDoctor();
                
                ArrayList<Doctor> doctors = doctor.getAllDoctors(); 
                for(Doctor d : doctors)
                {
                    if(doctor.getUserId() == appointment.getDoctor().getUserId())
                    {
                        doctor = d; //get the doctor
                    }
                }
                    
                Patient patient = appointment.getPatient();
                Rating rating = new Rating(); //create the new rating 
                rating.setDoctor(doctor);//set the rating 
                rating.setPatient(patient);
                rating.setRating(theView.getRating());
                rating.setComments(theView.getComment());
                rating.setAppointment(appointment);
                
                doctor.addRating(rating);//add rating to doctor
                doctor.updateDoctor();//update the doctor to write to file
                
                JOptionPane.showMessageDialog(null, "The Doctor rating has been added");
                
                PatientView patientView = new PatientView();
                PatientController patientController = new PatientController(patientView,theModel);
                theView.setVisible(false);
                patientView.setVisible(true);
                theView.getParent().add(patientView,SwingConstants.CENTER);
                
                
                } catch(Exception ex)
                    
                {

                    System.out.print(ex);
                }
        }
    
    }
    
    //return to the patient control panel
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
