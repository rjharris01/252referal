/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Richard Harris
 */
//stores the appointment request class
public class AppointmentRequest extends Appointment implements Serializable {
    private String type;
    public String getType() { return type;}
    public void setType(String newType){type = newType;}
    
    @Override
    public String toString() {
        return ("Doctor: " + this.getDoctor() + " Patient:" + this.getPatient() + this.getAppointmentId());
    }
}
