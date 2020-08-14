/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Patient;

import Views.Patient.PatientViewPerscriptionView;
import models.user.Patient;

/**
 *
 * @author richa_bfe6tpy
 */
public class PatientViewPerscriptionController {
    private PatientViewPerscriptionView theView;
    private Patient theModel;
    
    public PatientViewPerscriptionController(PatientViewPerscriptionView theView,Patient theModel)
    {
        this.theView = theView;
        this.theModel = theModel;
        
    }
}
