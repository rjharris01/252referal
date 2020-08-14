/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Secretary;

import Views.Admin.AdminView;
import Views.Secretary.SecretaryView;
import controllers.Admin.AdminController;
import models.user.Administrator;
import models.user.Secretary;

/**
 *
 * @author richa_bfe6tpy
 */
public class SecretaryController {
    private SecretaryView theView;
    private Secretary theModel;
    
    public SecretaryController(SecretaryView theView,Secretary theModel)
    {
        this.theView = theView;
        this.theModel = theModel;
       
    }
}
