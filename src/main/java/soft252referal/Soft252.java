/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft252referal;

import Views.LoginView;
import Views.soft252ReferalView;
import controllers.LoginController;
import models.user.User;

/**
 *
 * @author richa_bfe6tpy
 */
public class Soft252 {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        LoginView theView = new LoginView();
        User theModel = new User() {};
        soft252ReferalView thePanel = new soft252ReferalView();
      
        LoginController theController = new LoginController(theView,theModel);
        
        theView.setVisible(true);
       
    }
}