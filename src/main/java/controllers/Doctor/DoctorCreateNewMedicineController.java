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
import javax.swing.SwingConstants;
import models.user.Doctor;

/**
 *
 * @author richa_bfe6tpy
 */
public class DoctorCreateNewMedicineController {
    private DoctorCreateNewMedicineView theView;
    private Doctor theModel;
    
    public DoctorCreateNewMedicineController(DoctorCreateNewMedicineView theView, Doctor theModel){
        
        this.theView = theView;
        this.theModel = theModel;
        
        this.theView.addSubmitListener(new SubmitListener());
        this.theView.addBackListener(new BackListener());
        
        
    }
    
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
    
    class SubmitListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            MedicineFactory mf = new MedicineFactory();
            mf.makeNewMedicine(theView.getDoctorCreateMedicineField());
            theView.clearDoctorCreateMedicineField();
        }
        
        
    }
        
    
}
