/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.user;



import java.util.ArrayList;
import models.Rating;

/**
 *
 * @author Richard Harris
 */
public class Administrator extends User {
    public ArrayList<Rating> getDoctorRatings(Doctor doctor)
    {
        return doctor.getRatings();
    }
}
