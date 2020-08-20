/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


import models.user.User;

/**
 *
 * @author Richard Harris
 */
//class to store new account requests
public class NewAccountRequest extends Request {
    private User user;
    
    public User getUser() { return user;}
    public void setUser(User newUser){user = newUser;}
    
    @Override
    public String toString() {
        return ("Name: " + this.getUser().getName() + " Address: " + this.getUser().getAddress());
    }
}
