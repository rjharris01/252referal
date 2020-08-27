/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Doctor;

import Views.Doctor.DoctorStartAppointmentView;
import Views.Doctor.DoctorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import models.Appointment;
import models.user.Doctor;

/**
 *
 * @author richa_bfe6tpy
 */
//Controller for the Doctor start appointment view 
public class DoctorStartAppointmentController {
    //Variables declaration
    private DoctorStartAppointmentView theView;
    private Doctor theModel;
    
    public DoctorStartAppointmentController(DoctorStartAppointmentView theView,Doctor theModel)
    {
        //Construct the controller
        this.theView = theView;
        this.theModel = theModel;
        //set appointments list
        setAppointments();
        
        //Connect buttons
        this.theView.addBackListener(new BackListener());
        this.theView.addSubmitListener(new SubmitListener());
    }
    
    //set appointments list model
    public void setAppointments()
    {
        ArrayList<Appointment> appointments = theModel.getAllAppointments();
        DefaultComboBoxModel<Appointment> model = new DefaultComboBoxModel();
        for(Appointment a: appointments){
            model.addElement(a);
        }
        theView.setAppointments(model);
    }
    
    //on button press set the seleceted appointments notes to the user field 
    class SubmitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Appointment tempAppointment = theView.getAppointment(); //selected user appointment 
            tempAppointment.setComments(theView.getAppointmentComments()); //set notes 
            tempAppointment.updateAppointment(); //write the update to file 
            theView.resetComments();//clear the comment section
            
            JOptionPane.showMessageDialog(null, "The Appointment has concluded and notes have been added");
            
            DoctorView doctorView = new DoctorView();
            DoctorController DoctorController = new DoctorController(doctorView,theModel);
            theView.setVisible(false);
            doctorView.setVisible(true);
            theView.getParent().add(doctorView,SwingConstants.CENTER);
        }
        
    }
    
    //return to the doctor main control panel
    class BackListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            DoctorView doctorView = new DoctorView();
            DoctorController DoctorController = new DoctorController(doctorView,theModel);
            theView.setVisible(false);
            doctorView.setVisible(true);
            theView.getParent().add(doctorView,SwingConstants.CENTER);
        }
        
    }
    
}
