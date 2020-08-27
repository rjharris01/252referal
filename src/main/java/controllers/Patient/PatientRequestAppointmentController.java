/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Patient;

import Views.Patient.PatientRequestAppointmentView;
import Views.Patient.PatientView;
import controllers.RequestMaker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import models.AppointmentRequest;
import models.user.Doctor;
import models.user.Patient;
import models.user.User;

/**
 *
 * @author richa_bfe6tpy
 */
//Controller for the patient request appointment view 
public class PatientRequestAppointmentController {
    //Variables declaration
    private PatientRequestAppointmentView theView;
    private Patient theModel;
    
    public PatientRequestAppointmentController(PatientRequestAppointmentView theView,Patient theModel)
    {
        //Construct the controller
        this.theView = theView;
        this.theModel = theModel;
        //Connect buttons
        this.theView.addBackListener(new BackListener());
        this.theView.addSubmitListener(new SubmitListener());
        //set doctors list on load
        setDoctors();
       
    }
    
    //set doctors combo list box
    public void setDoctors(){
            ArrayList<Doctor> doctors;
            DefaultComboBoxModel<Doctor> doctorModel = new DefaultComboBoxModel<>();
            
            doctors =  theModel.getAllDoctors();
            for (Doctor d: doctors)
            {
               doctorModel.addElement(d);  
            }
            this.theView.setDoctors(doctorModel);
        }
    
    //return to patient control panel on button press
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
    
    //on button press create a request for a new appointment
    class SubmitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                Doctor doctor =  theView.getDoctor();
                Patient patient = theModel;
        
                String day,month,year,hour,minute;

                day = (theView.getPatientAppointmentDay());
                month = (theView.getPatientAppointmentMonthBox());
                year = (theView.getPatientAppointmentYearBox());
                hour = (theView.getPatientAppointmentHourBox()); 
                minute = (theView.getPatientAppointmentMinuteBox());


                String str = (year +"-"+ month +"-"+day+" "+hour+":"+minute);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime appointmentDate = LocalDateTime.parse(str, formatter);

                AppointmentRequest appointmentRequest = new AppointmentRequest(); //create new request object
                appointmentRequest.setAppointmentDate(appointmentDate);//set request object data
                appointmentRequest.setDoctor(doctor);
                appointmentRequest.setPatient(patient);
                
                
                RequestMaker rm = new RequestMaker(); //create request maker instance 
                rm.appointmentRequest(appointmentRequest); // generate request
                
                
                
            
                } catch(Exception ex)
                {


                }
        }
        
    }

       
        
        
        
}
