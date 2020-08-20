/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Admin;

import Views.Admin.AdminDoctorFeedBackView;
import Views.Admin.AdminView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import models.Rating;
import models.user.Administrator;
import models.user.Doctor;

/**
 *
 * @author richa_bfe6tpy
 */
public class AdminDoctorFeedBackController {
    private AdminDoctorFeedBackView theView;
    private Administrator theModel;
    
    
    public AdminDoctorFeedBackController(AdminDoctorFeedBackView theView, Administrator theModel){
        
        this.theView = theView;
        this.theModel = theModel;
        
        setDoctors();
        
        this.theView.addBackListener(new BackListener());
        this.theView.addGenerateFeedBackListener(new FeedBackListener());
        
    }
    
    public void setDoctors(){
        ArrayList<Doctor> doctors = theModel.getAllDoctors();
        DefaultComboBoxModel <Doctor> model = new DefaultComboBoxModel();
        
        for(Doctor d : doctors)
        {
            model.addElement(d);
        }
        
        theView.setDoctors(model);
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
    
    class FeedBackListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Doctor selectedDoctor = theView.getDoctor();
            Integer average = 0;
            ArrayList<Rating> ratings = selectedDoctor.getRatings();
            selectedDoctor.getRatings();
            for (Rating r : ratings)
            {
                average = average + r.getRating();
            }
            if(ratings.size() > 0)
            {
                average = average/ratings.size();
            }
            
            
            theView.setAdminDoctorFeedBackBox("Average Rating:" + average);
        }
        
    }
}
