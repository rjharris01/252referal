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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Richard Harris
 */
//stores the request abstract class
public abstract class Request implements Serializable {
    
    private String type;
    private int requestId;
    
    public String getType() { return type;}
    public void setType(String newType){type = newType;}
    
    public int getRequestId() { return requestId;}
    public void setRequestId(int newRequestId){requestId = newRequestId;}
    
    //returns all requests
    public ArrayList<Request>  getAllRequests()
     {
        ArrayList<Request> requests = new ArrayList<>();
        try {
                        FileInputStream fis = new FileInputStream("Requests.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
                        requests = (ArrayList) ois.readObject();
			
			ois.close();
                        fis.close();
                        
            } catch (FileNotFoundException  e) {
			System.out.print("No file \n");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
        return requests; 
     }
    
    //gets the next available request id
    public int getNextRequestId()
    {
        ArrayList<Request> requests = getAllRequests();
        return requests.size();
        
    }
    
    
}
