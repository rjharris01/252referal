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
import java.io.Serializable;

/**
 *
 * @author Richard Harris
 */
public class Medicine implements Serializable {
    private int medId;
    private String name;
    private int stock;
    
    
    
    public int getMedId(){return medId;}
    public void setMedId(int newMedId){medId = newMedId;}
    
    public String getName() { return name;}
    public void setName(String newName){name = newName;}
    
    public int getStock(){return stock;}
    public void setStock(int newStock){stock = newStock;}
    
    @Override
    public String toString() {
        return (this.getName());
    }
    
}