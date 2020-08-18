/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.Patient;

import Views.Patient.PatientView;
import Views.Patient.PatientViewHistoryView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.SwingConstants;
import models.Appointment;
import models.user.Patient;

/**
 *
 * @author richa_bfe6tpy
 */
public class PatientViewHistoryController {
    private PatientViewHistoryView theView;
    private Patient theModel;
    
    public PatientViewHistoryController(PatientViewHistoryView theView,Patient theModel)
    {
        this.theView = theView;
        this.theModel = theModel;
    
        this.theView.addPatientViewHistoryBackButton(new PatientViewHistoryBackListener());
        setHistory();
    }
    
    
    
    public void setHistory(){
        ArrayList<Appointment> appointments = theModel.getAllPastAppointments();
        DefaultListModel<Appointment> tempModel = new DefaultListModel<>();

        for (Appointment appointment: appointments)
        {
            tempModel.addElement(appointment);
        }        
        
        theView.setPatientHistory(tempModel);
    }
    
    class PatientViewHistoryBackListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            PatientView patientView = new PatientView();
            PatientController patientController = new PatientController(patientView,theModel);
            theView.setVisible(false);
            patientView.setVisible(true);
            theView.getParent().add(patientView,SwingConstants.CENTER);
        }
        
    }
}
