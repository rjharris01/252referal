/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Views.AdminView;
import models.user.Administrator;

/**
 *
 * @author richa_bfe6tpy
 */
public class AdminController {
    private AdminView theView;
    private Administrator theModel;
    
    public AdminController(AdminView theView,Administrator theModel)
    {
        this.theView = theView;
        this.theModel = theModel;
    }
}
