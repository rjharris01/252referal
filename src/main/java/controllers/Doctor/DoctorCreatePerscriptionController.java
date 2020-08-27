/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Doctor;

import Views.Doctor.DoctorCreatePerscriptionView;
import Views.Doctor.DoctorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import models.Appointment;
import models.Medicine;
import models.Perscription;
import models.user.Doctor;
import models.user.Patient;

/**
 *
 * @author richa_bfe6tpy
 */
//Controller for the Doctor Create perscription view 
public class DoctorCreatePerscriptionController {
    //Variables declaration
    DoctorCreatePerscriptionView theView;
    Doctor theModel;
   
    public DoctorCreatePerscriptionController(DoctorCreatePerscriptionView theView, Doctor theModel)
    {
        //Construct the controller
        this.theView = theView;
        this.theModel = theModel;
        
        //set patients list
        setPatients();
        //set medicine list
        setMedicine();
        
        //Connect buttons
        this.theView.addBackListener(new BackListener());
        this.theView.addChangePatientListener(new ChangePatientListener());
        this.theView.addSubmitListner(new SubmitListner());
        
    }
    
    //set the patient combo box model
    public void setPatients()
    {
        ArrayList<Patient> patients = theModel.getAllPatients();
        DefaultComboBoxModel<Patient> model = new DefaultComboBoxModel();
        
        for (Patient p : patients)
        {
            model.addElement(p);
        }
        
        theView.setPatientList(model);
        
        
    }
    
    //set appointments combo box model
    public void setAppointments()
    {
        ArrayList<Appointment> appointments = theView.getSelectedPatient().getAllAppointments();
        DefaultComboBoxModel<Appointment> model = new DefaultComboBoxModel();
        
        for (Appointment a : appointments)
        {
            model.addElement(a);
        }
        
        theView.setAppointmentsList(model);
    }
    
    //set medicine combo box model
    public void setMedicine()
    {
        ArrayList<Medicine> medicines = theModel.getAllMedicine();
        DefaultComboBoxModel<Medicine> model = new DefaultComboBoxModel();
        
        for (Medicine m : medicines)
        {
            model.addElement(m);
        }
        
        theView.setMedicineList(model);
        
    }
    
    
    //on button click create a new perscription
    class SubmitListner implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            Patient selected = theView.getSelectedPatient();
            
            Perscription perscription = new Perscription(); //create a temp perscription
            perscription.setDoctor(theModel);//set the perscription fields
            perscription.setMedicine(theView.getSelectedMedicine());
            perscription.setPatient(selected);
            perscription.setDosage(theView.getPerscriptionDosage());
            if(theView.getSelectedAppointment() != null && theView.getSelectedAppointment().getComments() != null ){
            perscription.setNote(theView.getSelectedAppointment().getComments());
            }
            else {perscription.setNote("");}
            perscription.setQuantity(theView.getPerscriptionQuantity());
            perscription.setPerscriptionId(perscription.getNextPerscriptionId());
            
            selected.addPerscription(perscription); //add perscription to user
            
            theView.reset(); // update view
            
            JOptionPane.showMessageDialog(null, "The Perscription has been created sucessfully");
            
            DoctorView doctorView = new DoctorView();
            DoctorController DoctorController = new DoctorController(doctorView,theModel);
            theView.setVisible(false);
            doctorView.setVisible(true);
            theView.getParent().add(doctorView,SwingConstants.CENTER);
        }
    
    }
    
    //listen to the patient combo box and reset appointments on change
    
    class ChangePatientListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            setAppointments();
        }
    
    }
    
    
    //return to the doctor control panel on button press
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
    
    
}
