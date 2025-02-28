/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Admin;

import Views.Admin.AdminView;
import Views.Admin.AdminViewRatingsView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.SwingConstants;
import models.Rating;
import models.user.Administrator;
import models.user.Doctor;

/**
 *
 * @author richa_bfe6tpy
 */
//Controller for the admin view ratings view 
public class AdminViewRatingsController {
    //Variables declaration
    private AdminViewRatingsView theView;
    private Administrator theModel;
    
    
    public AdminViewRatingsController(AdminViewRatingsView theView, Administrator theModel){
        //Construct the controller
        this.theView = theView;
        this.theModel = theModel;
        //set the doctors list
        setDoctors();
        //Connect buttons
        this.theView.addBackListener(new BackListener());
        this.theView.addSubmitListener(new SubmitListener());
        
    }
    
    //set the doctors list
    public void setDoctors(){
        theView.clearDoctorList();
        ArrayList<Doctor> doctors = theModel.getAllDoctors();
        DefaultComboBoxModel<Doctor> model = new DefaultComboBoxModel();
        for(Doctor d: doctors)
            {
                model.addElement(d);
            }
        theView.setDoctors(model);
    }
    
    //on button press view all ratings of selected doctor
    class SubmitListener implements ActionListener{
        
       

        @Override
        public void actionPerformed(ActionEvent e) {
            Doctor selectedDoctor = new Doctor();
            ArrayList<Rating> ratings = new ArrayList();
            DefaultListModel<Rating> model = new DefaultListModel();
            selectedDoctor = theView.getDoctor();
            ratings = selectedDoctor.getRatings();
            
            for(Rating r: ratings)
            {
                model.addElement(r);
            }
            
            theView.clearRatingsList();
            theView.setRatings(model);
            
        }
        
    }
    
    //on button press return to admin main control panel
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
}