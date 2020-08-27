/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Secretary;

import Views.Secretary.SecretaryAppointmentView;
import Views.Secretary.SecretaryView;
import controllers.RequestMaker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import models.AppointmentRequest;
import models.NewAppointmentRequest;
import models.Request;
import models.user.Doctor;
import models.user.Patient;
import models.user.Secretary;
import models.user.User;

/**
 *
 * @author richa_bfe6tpy
 */
//Controller for the Secretary Appointment view 
public class SecretaryAppointmentController {
        //Variables declaration
        private SecretaryAppointmentView theView;
        private Secretary theModel;


        public SecretaryAppointmentController(SecretaryAppointmentView theView, Secretary theModel){
            //Construct the controller
            this.theView = theView;
            this.theModel = theModel;
            
            //Set Doctors and patients lists on load
            setDoctorsPatients();
            

            //Connect buttons
            this.theView.addSubmitListener(new SecretaryAppointmentController.SubmitListener());
            this.theView.addBackListener(new SecretaryAppointmentController.BackListener());
            
           

        }
        
        
        //set all doctors and patients in to correct list boxes
        public void setDoctorsPatients(){
            ArrayList<User> users;
            DefaultComboBoxModel<Patient> patientModel = new DefaultComboBoxModel<>(); 
            DefaultComboBoxModel<Doctor> doctorModel = new DefaultComboBoxModel<>();
            
            users =  theModel.getAllUsers();
            for (User user: users)
            {
                if ("D".equals(String.valueOf(user.getUserId().charAt(0))))
                {
                    doctorModel.addElement((Doctor) user); //create list of doctors 

                }

                else if ("P".equals(String.valueOf(user.getUserId().charAt(0))))
                {
                    patientModel.addElement((Patient) user); //create list of patients 
                }
            }
            setPatients(patientModel); // set list model
            setDoctors(doctorModel); //set list model
           
            
        }
        
        //set model in view
        public void   setDoctors (DefaultComboBoxModel<Doctor> Doctors){
            this.theView.setDoctors(Doctors);
        }
        
        //set model in view
        public void   setPatients (DefaultComboBoxModel<Patient> Patients){
            this.theView.setPatients(Patients);
        }
        
        //on submit create appointment between patient and doctor on a given date
        class SubmitListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                Doctor doctor =  theView.getDoctor(); //the patient 
                Patient patient = theView.getPatient();//the doctor 
        
                String day,month,year,hour,minute;

                day = (theView.getSecretaryAppointmentDay());
                month = (theView.getSecretaryAppointmentMonthBox());
                year = (theView.getSecretaryAppointmentYearBox());
                hour = (theView.getSecretaryAppointmentHourBox()); 
                minute = (theView.getSecretaryAppointmentMinuteBox());


                String str = (year +"-"+ month +"-"+day+" "+hour+":"+minute);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                LocalDateTime appointmentDate = LocalDateTime.parse(str, formatter); //the date

                NewAppointmentRequest appointmentRequest = new NewAppointmentRequest();//new appointment request
                appointmentRequest.getAppointmentRequest().setAppointmentDate(appointmentDate);//set appointment request
                appointmentRequest.getAppointmentRequest().setDoctor(doctor);
                appointmentRequest.getAppointmentRequest().setPatient(patient);
                RequestMaker rm = new RequestMaker(); //create request maker instance 
                rm.newAppointmentRequest(appointmentRequest); // generate request
                theModel.approveAppointmentRequest(appointmentRequest);
                theModel.updateUser();
                
                JOptionPane.showMessageDialog(null, "Appointment Created:" + appointmentRequest);
            
                } catch(Exception ex)
                {


                }
            }
    
        }
        
        //return to secretary control panel view on button press
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



