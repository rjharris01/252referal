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
//stores the new appointment request class
public class NewAppointmentRequest extends Request{
    private AppointmentRequest appointment = new AppointmentRequest();
    
    public AppointmentRequest getAppointmentRequest() { return appointment;}
    public void setAppointmentRequest(AppointmentRequest newAppointmentRequest){appointment = newAppointmentRequest;}
    
    @Override
    public String toString() {
        return ("Patient: " + appointment.getPatient().getName() + "  Doctor: " + appointment.getDoctor().getName() + "  Date: " + appointment.getAppointmentDate().toString());
    }
}
