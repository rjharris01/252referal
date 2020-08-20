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
//sotres the order medicine request class
public class OrderMedicineRequest extends Request {
    private Medicine medicine;
    
    public Medicine getMedicine() { return medicine;}
    public void setMedicine(Medicine newMedicine){medicine = newMedicine;}
}

