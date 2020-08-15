/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Admin;

import Views.Admin.AdminModifyDoctorsView;
import Views.Admin.AdminView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.SwingConstants;
import models.user.Administrator;
import models.user.Doctor;
import models.user.User;

/**
 *
 * @author richa_bfe6tpy
 */
public class AdminModifyDoctorsController {
    private AdminModifyDoctorsView theView;
    private Administrator theModel;
    
    
    public AdminModifyDoctorsController(AdminModifyDoctorsView theView, Administrator theModel){
        
        this.theView = theView;
        this.theModel = theModel;
        
        this.theView.addDeleteListener(new DeleteListener());
        this.theView.addBackListener(new BackListener());
        
        setDoctorList();
        
    }
    
    class BackListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            AdminView adminView = new AdminView();
            AdminController adminController = new AdminController(adminView,theModel);
            theView.setVisible(false);
            adminView.setVisible(true);
            theView.getParent().add(adminView,SwingConstants.CENTER);
        }
    }
    
    class DeleteListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
             
             try{
                    Doctor doctor = theView.getSelectedUser();
                    theModel.deleteUser(doctor.getUserId());
                    setDoctorList();
                 
                    
                   
                    
        }
         catch(java.lang.NullPointerException ex)
        {
            System.out.print("No Account selected");
        }
                     
        }
    }
    
    public void setDoctorList()
    {
        theView.clearList();
        ArrayList<Doctor> doctors = theModel.getAllDoctors();
        DefaultListModel<Doctor> model = new DefaultListModel();
        for(Doctor d: doctors)
            {
                model.addElement(d);
            }
        theView.setDoctorList(model);
    }
}
