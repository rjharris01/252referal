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
public class SecretaryOrderMedicineController {
    private SecretaryOrderMedicineView theView;
    private Secretary theModel;
    
    
    public SecretaryOrderMedicineController(SecretaryOrderMedicineView theView, Secretary theModel){
        
        this.theView = theView;
        this.theModel = theModel;
        
        setMedicines();
        
        this.theView.addBackListener(new BackListener());
        this.theView.addOrderListener(new OrderListener());
       
    }
    
    public void setMedicines(){
        ArrayList<Medicine> medicines = theModel.getAllMedicine();
        DefaultComboBoxModel<Medicine> model = new DefaultComboBoxModel();
        for(Medicine m : medicines)
        {
            model.addElement(m);
        }
        theView.setSecretaryOrderMedecineMedicinesBox(model);
    }
    
    class OrderListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            Medicine m = theView.getSecretaryOrderMedecineMedicinesBox();
            m.setStock(m.getStock() + theView.getSecretaryOrderMedicineQuantityField());
            m.updateMedicine();
        }
    
    }
    
    
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
