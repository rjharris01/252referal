/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Secretary;

import Views.Secretary.SecretaryOrderMedicineView;
import Views.Secretary.SecretaryView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import models.Medicine;
import models.user.Secretary;

/**
 *
 * @author richa_bfe6tpy
 */
//Controller for the secretary order medicine view 
public class SecretaryOrderMedicineController {
    
    //Variables declaration
    private SecretaryOrderMedicineView theView;
    private Secretary theModel;
    
    
    public SecretaryOrderMedicineController(SecretaryOrderMedicineView theView, Secretary theModel){
        //Construct the controller
        this.theView = theView;
        this.theModel = theModel;
        //set medicine list on load
        setMedicines();
        //Connect buttons
        this.theView.addBackListener(new BackListener());
        this.theView.addOrderListener(new OrderListener());
       
    }
    
    //set combo box medicines 
    public void setMedicines(){
        ArrayList<Medicine> medicines = theModel.getAllMedicine();//get medicines
        DefaultComboBoxModel<Medicine> model = new DefaultComboBoxModel();
        for(Medicine m : medicines)
        {
            model.addElement(m);//add each medicine to model
        }
        theView.setSecretaryOrderMedecineMedicinesBox(model);//set model
    }
    
    
    //on button press oder medicine
    class OrderListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            Medicine m = theView.getSecretaryOrderMedecineMedicinesBox();//medicine to order
            m.setStock(m.getStock() + theView.getSecretaryOrderMedicineQuantityField());// increase the stock
            m.updateMedicine();//save the medicine 
        }
    
    }
    
    //return to secretary control panel
    class BackListener implements ActionListener
    {

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
