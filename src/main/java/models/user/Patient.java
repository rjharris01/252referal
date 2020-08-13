/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.user;

import java.time.LocalDate;
import java.util.Scanner;
import models.Rating;
import models.Appointment;
/**
 *
 * @author richa_bfe6tpy
 */
public class Patient extends User {
    
    private String gender;
    private LocalDate birthday;
    
    public String getGender() { return gender;}
    public void setGender(String newGender){gender = newGender;}
    
    public LocalDate getBirthday() { return birthday;}
    public void setBirthday(LocalDate newBirthday){birthday = newBirthday;}
    
    public void newRating(Appointment appointment)
    {
        Scanner userInput = new Scanner(System.in);
        String tempInput;
        
        
        Rating rating = new Rating();
        rating.setDoctor(appointment.getDoctor());
        rating.setPatient(appointment.getPatient());
        rating.setAppointment(appointment);
        
        System.out.print("Please enter a rating: ");
        tempInput = userInput.nextLine();
        rating.setRating(tempInput);
        
        rating.getDoctor().addRating(rating);
    }
    
    public void requestAccountTermination()
    {
          
    
    }
    
    @Override
    public String toString() {
        return ("Name: " + this.getName() + " ID:" + this.getUserId());
    }
}
