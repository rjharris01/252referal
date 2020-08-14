/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Secretary;

import Views.Secretary.SecretaryOrderMedicineView;
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
       
    }
}
