/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Doctor;

import Views.Doctor.DoctorCreateNewMedicineView;
import Views.Doctor.DoctorView;
import controllers.MedicineFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import models.Medicine;
import models.user.Doctor;

/**
 *
 * @author richa_bfe6tpy
 */
//Controller for the login view 
public class DoctorCreateNewMedicineController {
    //Variables declaration
    private DoctorCreateNewMedicineView theView;
    private Doctor theModel;
    
    public DoctorCreateNewMedicineController(DoctorCreateNewMedicineView theView, Doctor theModel){
        //Construct the controller
        this.theView = theView;
        this.theModel = theModel;
        //Connect buttons
        this.theView.addSubmitListener(new SubmitListener());
        this.theView.addBackListener(new BackListener());
        
        
    }
    
    //return to doctor control panel on button press
    
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
     
     //create new medicine on button press
    
    class SubmitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            MedicineFactory mf = new MedicineFactory();//create new instance of medicine factory
            Medicine m = mf.makeNewMedicine(theView.getDoctorCreateMedicineField(),theModel);//uses medicine factory to create new medicine
            theView.clearDoctorCreateMedicineField();
            JOptionPane.showMessageDialog(null, "Medcine\n"+ m.getName() +"\nCreated");// notify that the account has been created
        }
        
        
    }
        
    
}
