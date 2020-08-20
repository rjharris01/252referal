/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Patient;

import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import models.Appointment;

/**
 *
 * @author richa_bfe6tpy
 */

//This class provide a panel which contains the Patient leave feedback for doctor view.
public class PatientLeaveFeedbackForDoctorView extends javax.swing.JPanel {

    /**
     * Creates new form PatientLeaveFeedbackForDoctorView
     */
    public PatientLeaveFeedbackForDoctorView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PatientFeedbackAppointmentBox = new javax.swing.JComboBox<>();
        PatientFeedbackRatingBox = new javax.swing.JComboBox<>();
        PatientFeedbackSubmitButton = new javax.swing.JButton();
        PatientFeedbackBackButton = new javax.swing.JButton();
        PatientLeaveFeedbackLabel = new javax.swing.JLabel();
        PatientFeedbackRatingLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PatientFeedbackCommentBox = new javax.swing.JTextArea();

        PatientFeedbackRatingBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        PatientFeedbackSubmitButton.setText("Submit");

        PatientFeedbackBackButton.setText("Back");

        PatientLeaveFeedbackLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PatientLeaveFeedbackLabel.setText("Appointment");

        PatientFeedbackRatingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PatientFeedbackRatingLabel.setText("Rating");

        PatientFeedbackCommentBox.setColumns(20);
        PatientFeedbackCommentBox.setRows(5);
        jScrollPane1.setViewportView(PatientFeedbackCommentBox);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(PatientFeedbackSubmitButton)
                .addGap(37, 37, 37))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(PatientFeedbackBackButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PatientLeaveFeedbackLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PatientFeedbackRatingBox, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PatientFeedbackRatingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(124, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(PatientFeedbackAppointmentBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(PatientLeaveFeedbackLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PatientFeedbackAppointmentBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PatientFeedbackRatingLabel)
                .addGap(7, 7, 7)
                .addComponent(PatientFeedbackRatingBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PatientFeedbackSubmitButton)
                    .addComponent(PatientFeedbackBackButton))
                .addGap(27, 27, 27))
        );

        PatientFeedbackAppointmentBox.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    //Button Listners 
    public void addSubmitListener(ActionListener listenForSubmit){
        PatientFeedbackSubmitButton.addActionListener(listenForSubmit);
    }
    
    public void addBackListener(ActionListener listenForSubmit){
        PatientFeedbackBackButton.addActionListener(listenForSubmit);
    }
    
    //Set and get (element) patient appointments list
    
    public void setPatientFeedbackAppointmentBox(DefaultComboBoxModel<Appointment> appointmentModel ){
        PatientFeedbackAppointmentBox.setModel(appointmentModel);
    }
    
    public Appointment getAppointment(){
                return (Appointment)PatientFeedbackAppointmentBox.getSelectedItem();
    }
    
    //Other getters required for feedback view
    
    public int getRating(){
        return Integer.parseInt(PatientFeedbackRatingBox.getSelectedItem().toString());
    }
    
    public String getComment(){
       return PatientFeedbackCommentBox.getText();
    }
    

     
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Appointment> PatientFeedbackAppointmentBox;
    private javax.swing.JButton PatientFeedbackBackButton;
    private javax.swing.JTextArea PatientFeedbackCommentBox;
    private javax.swing.JComboBox<String> PatientFeedbackRatingBox;
    private javax.swing.JLabel PatientFeedbackRatingLabel;
    private javax.swing.JButton PatientFeedbackSubmitButton;
    private javax.swing.JLabel PatientLeaveFeedbackLabel;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
