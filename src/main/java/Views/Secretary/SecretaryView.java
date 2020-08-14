/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Secretary;

import java.awt.Label;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author richa_bfe6tpy
 */
public class SecretaryView extends javax.swing.JPanel {

    private Label label1;
    private JButton SecratryApprovePatientButton;
    private JButton SecratryCreateAppointmentButton;
    private JButton SecratryOrderMedicineButton;
    private JButton SecratryRemovePatientButton;
    private JButton SecratryRemovePatientRequestButton;
    private JButton SecratryCompletePerscriptionButton;
    private JButton LogoutButton;
    private JButton SecretaryApproveAppointmentButton;

    /**
     * Creates new form SecretaryView
     */
    public SecretaryView() {
        initMyComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void initMyComponents() {
       label1 = new java.awt.Label();
       SecratryApprovePatientButton = new javax.swing.JButton();
       SecretaryApproveAppointmentButton = new javax.swing.JButton();
       SecratryCreateAppointmentButton = new javax.swing.JButton();
       SecratryOrderMedicineButton = new javax.swing.JButton();
       SecratryRemovePatientButton = new javax.swing.JButton();
       SecratryRemovePatientRequestButton = new javax.swing.JButton();
       SecratryCompletePerscriptionButton = new javax.swing.JButton();
       LogoutButton = new javax.swing.JButton();
       
       
       label1.setAlignment(java.awt.Label.CENTER);
        label1.setText("Secretary Panel");

        SecratryApprovePatientButton.setText("Approve Patients");
       

        SecratryCreateAppointmentButton.setText("Create Appointment");
        

        SecratryOrderMedicineButton.setText("Order Medicine");
        

        SecratryRemovePatientButton.setText("Remove Patient (Manual)");
        
        SecratryRemovePatientRequestButton.setText("Remove Patient (Request)");
        

        SecratryCompletePerscriptionButton.setText("Complete Perscription");

        LogoutButton.setText("Logout");
        

        SecretaryApproveAppointmentButton.setText("Approve Appointments");
        

        javax.swing.GroupLayout SecretaryMainPanelLayout = new javax.swing.GroupLayout(this);
        this.setLayout(SecretaryMainPanelLayout);
        SecretaryMainPanelLayout.setHorizontalGroup(
            SecretaryMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SecretaryMainPanelLayout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addGroup(SecretaryMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SecretaryMainPanelLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SecretaryMainPanelLayout.createSequentialGroup()
                        .addGroup(SecretaryMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SecratryRemovePatientRequestButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SecratryApprovePatientButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SecratryCompletePerscriptionButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(SecretaryMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SecratryRemovePatientButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SecratryOrderMedicineButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SecratryCreateAppointmentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SecretaryApproveAppointmentButton))
                    .addComponent(LogoutButton))
                .addGap(38, 38, 38))
        );
        SecretaryMainPanelLayout.setVerticalGroup(
            SecretaryMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SecretaryMainPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(LogoutButton)
                .addGap(47, 47, 47)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(SecretaryMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SecratryRemovePatientRequestButton)
                    .addComponent(SecratryRemovePatientButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SecretaryMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SecratryApprovePatientButton)
                    .addComponent(SecratryOrderMedicineButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SecretaryMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SecratryCompletePerscriptionButton)
                    .addComponent(SecratryCreateAppointmentButton)
                    .addComponent(SecretaryApproveAppointmentButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    

    
    
    public void addSecratryApprovePatientListener(ActionListener listenForSecratryApprovePatient){
        SecratryApprovePatientButton.addActionListener(listenForSecratryApprovePatient);
    }
    
    public void addSecratryCreateAppointmentListener(ActionListener listenForSecratryCreateAppointment){
        SecratryCreateAppointmentButton.addActionListener(listenForSecratryCreateAppointment);
    }
    
    public void addSecratryOrderMedicineListener(ActionListener listenForSecratryOrderMedicine){
        SecratryOrderMedicineButton.addActionListener(listenForSecratryOrderMedicine);
    }
    
    public void addSecratryRemovePatientListener(ActionListener listenForSecratryRemovePatient){
        SecratryRemovePatientButton.addActionListener(listenForSecratryRemovePatient);
    }
    
    public void addSecratryRemovePatientRequestListener(ActionListener listenForSecratryRemovePatientRequest){
        SecratryRemovePatientRequestButton.addActionListener(listenForSecratryRemovePatientRequest);
    }
    
    public void addSecratryCompletePerscriptionListener(ActionListener listenForSecratryCompletePerscription){
        SecratryCompletePerscriptionButton.addActionListener(listenForSecratryCompletePerscription);
    }
    
    public void addLogoutListener(ActionListener listenForLogout){
        LogoutButton.addActionListener(listenForLogout);
    }
    
    public void addSecretaryApproveAppointmentListener(ActionListener listenForSecretaryApproveAppointment){
        SecretaryApproveAppointmentButton.addActionListener(listenForSecretaryApproveAppointment);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
