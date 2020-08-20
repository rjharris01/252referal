/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author richa_bfe6tpy
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import models.Request;
import models.NewAppointmentRequest;
import models.NewAccountRequest;
import models.OrderMedicineRequest;
import models.AppointmentRequest;
import models.AccountDeleteRequest;
import models.user.User;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import models.Medicine;

/**
 *
 * @author Richard Harris
 */
//class used to manage new requests 
public class RequestMaker {  
    
    //generate new account request
    public void newAccountRequest(User user)
    {
        NewAccountRequest request;
        request = new NewAccountRequest();
        request.setUser(user);
        request.setType("newAccountRequest");
        request.setRequestId(request.getNextRequestId());
        writeRequest(request);
    }
    
    //generate terminate account request
    public void accountTerminationRequest(User user)
    {
        AccountDeleteRequest request;
        request = new AccountDeleteRequest();
        request.setUserId(user.getUserId());
        request.setType("accountDeleteRequest");
        request.setRequestId(request.getNextRequestId());
        writeRequest(request);
    }
    
    
    //generate appointment request
    public void appointmentRequest(AppointmentRequest appointment)
    {
        NewAppointmentRequest request;
        request = new NewAppointmentRequest();
        request.setAppointmentRequest(appointment);
        request.setType("newAppointmentRequest");
        request.setRequestId(request.getNextRequestId());
        writeRequest(request);
    }
    
    
    //generate order medicine request
    public void orderMedicineRequest(Medicine medicine)
    {
        OrderMedicineRequest request;
        request = new OrderMedicineRequest();
        request.setMedicine(medicine);
        request.setType("orderMedicineRequest");
        request.setRequestId(request.getNextRequestId());
        writeRequest(request);
    }
    
    
    //write request to request file 
    public void writeRequest(Request request)
    {
        ArrayList<Request> requests;
        requests = request.getAllRequests();
         
        requests.add(request);
         
        try
        {
            FileOutputStream fos = new FileOutputStream("Requests.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(requests);
            oos.close();
            fos.close();
        } 
         
         catch (IOException ioe) 
        {
            ioe.printStackTrace();
        }    
    }
    
    
    
}

