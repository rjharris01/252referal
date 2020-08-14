/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Secretary;

import Views.Secretary.SecretaryAppointmentView;
import Views.Secretary.SecretaryView;
import controllers.Admin.AdminCreateAccountController;
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
import models.user.Secretary;
import models.user.User;

/**
 *
 * @author richa_bfe6tpy
 */
public class SecretaryAppointmentController {
        private SecretaryAppointmentView theView;
        private Secretary theModel;


        public SecretaryAppointmentController(SecretaryAppointmentView theView, Secretary theModel){

            this.theView = theView;
            this.theModel = theModel;
            
            setDoctorsPatients();
            
             this.theView.addSubmitListener(new SecretaryAppointmentController.SubmitListener());
             this.theView.addBackListener(new SecretaryAppointmentController.BackListener());
            
           

        }
        
        public void setDoctorsPatients(){
            ArrayList<User> users;
            DefaultComboBoxModel<Patient> patientModel = new DefaultComboBoxModel<>();
            DefaultComboBoxModel<Doctor> doctorModel = new DefaultComboBoxModel<>();
            
            users =  theModel.getAllUsers();
            for (User user: users)
            {
                if ("D".equals(String.valueOf(user.getUserId().charAt(0))))
                {
                    doctorModel.addElement((Doctor) user);

                }

                else if ("P".equals(String.valueOf(user.getUserId().charAt(0))))
                {
                    patientModel.addElement((Patient) user);
                }
            }
            
            setDoctors(doctorModel);
            setPatients(patientModel);
            
        }
        
        
        public void   setDoctors (DefaultComboBoxModel<Doctor> Doctors){
            this.theView.setDoctors(Doctors);
        }
        
        public void   setPatients (DefaultComboBoxModel<Patient> Patients){
            this.theView.setPatients(Patients);
        }
        
        
        class SubmitListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                Doctor doctor =  theView.getDoctor();
                Patient patient = theView.getPatient();
        
                String day,month,year,hour,minute;

                day = (theView.getSecretaryAppointmentDay());
                month = (theView.getSecretaryAppointmentMonthBox());
                year = (theView.getSecretaryAppointmentYearBox());
                hour = (theView.getSecretaryAppointmentHourBox()); 
                minute = (theView.getSecretaryAppointmentMinuteBox());


                String str = (year +"-"+ month +"-"+day+" "+hour+":"+minute);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime appointmentDate = LocalDateTime.parse(str, formatter);

                AppointmentRequest appointmentRequest = new AppointmentRequest();
                appointmentRequest.setAppointmentDate(appointmentDate);
                appointmentRequest.setDoctor(doctor);
                appointmentRequest.setPatient(patient);
                appointmentRequest.newAppointmentRequest(appointmentRequest);
                appointmentRequest.approveRequest(appointmentRequest);
                
                
            
                } catch(Exception ex)
                {


                }
            }
    
        }
        
        class BackListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            SecretaryView secretaryView = new SecretaryView();
            SecretaryController secretarController = new SecretaryController(secretaryView,theModel);
            theView.setVisible(false);
            secretaryView.setVisible(true);
            theView.getParent().add(secretaryView,SwingConstants.CENTER);
        }
        
    }
        
        
}



