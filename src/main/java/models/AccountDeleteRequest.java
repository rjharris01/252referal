/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Richard Harris
 */
public class AccountDeleteRequest extends Request {
    private String userId;
    
    public String getUserId() { return userId;}
    public void setUserId(String newUserId){userId = newUserId;}
    
    
}
