/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Patient;

import Views.Patient.PatientRequestAppointmentView;
import Views.Patient.PatientView;
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
public class PatientRequestAppointmentController {
    private PatientRequestAppointmentView theView;
    private Patient theModel;
    
    public PatientRequestAppointmentController(PatientRequestAppointmentView theView,Patient theModel)
    {
        this.theView = theView;
        this.theModel = theModel;
        this.theView.addBackListener(new BackListener());
        this.theView.addSubmitListener(new SubmitListener());
        setDoctors();
       
    }
    
    public void setDoctors(){
            ArrayList<User> users;
            DefaultComboBoxModel<Doctor> doctorModel = new DefaultComboBoxModel<>();
            
            users =  theModel.getAllUsers();
            for (User user: users)
            {
                if ("D".equals(String.valueOf(user.getUserId().charAt(0))))
                {
                    doctorModel.addElement((Doctor) user);
                }
            }
            this.theView.setDoctors(doctorModel);
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

                AppointmentRequest appointmentRequest = new AppointmentRequest();
                appointmentRequest.setAppointmentDate(appointmentDate);
                appointmentRequest.setDoctor(doctor);
                appointmentRequest.setPatient(patient);
                appointmentRequest.newAppointmentRequest(appointmentRequest);
                
                
                
            
                } catch(Exception ex)
                {


                }
        }
        
    }

       
        
        
        
}
