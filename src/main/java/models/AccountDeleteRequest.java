/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author richa_bfe6tpy
 */
//class for account delete request
public class AccountDeleteRequest extends Request {
    private String userId;
    
    public String getUserId() { return userId;}
    public void setUserId(String newUserId){userId = newUserId;}
    
    @Override
    public String toString() {
        return (" ID:" + this.getUserId());
    }
}
