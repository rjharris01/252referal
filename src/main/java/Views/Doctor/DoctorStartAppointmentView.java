/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Doctor;

import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import models.Appointment;

/**
 *
 * @author richa_bfe6tpy
 */
//This class provide a panel which contains the Doctor Start Appointment view.
public class DoctorStartAppointmentView extends javax.swing.JPanel {

    /**
     * Creates new form DoctorStartAppointmentView
     */
    public DoctorStartAppointmentView() {
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

        DoctorStartAppointmentListBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        DoctorSubmitButton = new javax.swing.JButton();
        DoctorBackButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        DoctorStartAppointmentCommentsField = new javax.swing.JTextArea();

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Start appointment");
        jLabel1.setToolTipText("");

        DoctorSubmitButton.setText("Submit");

        DoctorBackButton.setText("Back");

        DoctorStartAppointmentCommentsField.setColumns(20);
        DoctorStartAppointmentCommentsField.setRows(5);
        jScrollPane1.setViewportView(DoctorStartAppointmentCommentsField);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(DoctorBackButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(DoctorSubmitButton))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                            .addComponent(DoctorStartAppointmentListBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(DoctorStartAppointmentListBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DoctorSubmitButton)
                    .addComponent(DoctorBackButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    //Button Listeners
    
    public void addSubmitListener(ActionListener listenForSubmit){
        DoctorSubmitButton.addActionListener(listenForSubmit);
    }
    
    public void addBackListener(ActionListener listenForBack){
        DoctorBackButton.addActionListener(listenForBack);
    }
    
    //Get and reset appointment comments field 
    public String getAppointmentComments(){
        return DoctorStartAppointmentCommentsField.getText();
    }
    
    public void resetComments(){
        DoctorStartAppointmentCommentsField.setText("");
    }
    
    //Get and set Appointment model and element from listbox
    
    public Appointment getAppointment(){
        return (Appointment)DoctorStartAppointmentListBox.getSelectedItem();
    }
    
    public void setAppointments(DefaultComboBoxModel<Appointment> model)
    {
        DoctorStartAppointmentListBox.setModel(model);
    }
     
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DoctorBackButton;
    private javax.swing.JTextArea DoctorStartAppointmentCommentsField;
    private javax.swing.JComboBox<Appointment> DoctorStartAppointmentListBox;
    private javax.swing.JButton DoctorSubmitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
