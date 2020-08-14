/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Patient;

import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import models.user.Doctor;
import models.user.Patient;

/**
 *
 * @author richa_bfe6tpy
 */
public class PatientRequestAppointmentView extends javax.swing.JPanel {

    private JComboBox<Doctor> PatientAppointmentDoctorBox;
    private JComboBox<Object> PatientAppointmentMonthBox;
    private JButton PatientAppointmentSubmitButton;
    private JButton PatientAppointmentBackButton;
    private JLabel PatientAppointmentDoctorLabel;
    private JLabel PatientAppointmentMonthLabel;
    private JLabel PatientAppointmentDayLabel;
    private JComboBox<Object> PatientAppointmentDayBox;
    private JComboBox<Object> PatientAppointmentYearBox;
    private JComboBox<Object> PatientAppointmentHourBox;
    private JComboBox<Object> PatientAppointmentMinuteBox;
    private JLabel PatientAppointmentYearLabel;
    private JLabel PatientAppointmentHourLabel;
    private JLabel PatientAppointmentMinuteLabel;
    private JPanel PatientApprovePatientPanel;
    private JButton PatientApprovePatientButton;
    

    /**
     * Creates new form PatientRequestAppointmentView
     */
    public PatientRequestAppointmentView() {
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
    public void initMyComponents() {
        PatientAppointmentDoctorBox = new javax.swing.JComboBox<>();
        PatientAppointmentMonthBox = new javax.swing.JComboBox<>();
        PatientAppointmentSubmitButton = new javax.swing.JButton();
        PatientAppointmentBackButton = new javax.swing.JButton();
        PatientAppointmentDoctorLabel = new javax.swing.JLabel();
        PatientAppointmentMonthLabel = new javax.swing.JLabel();
        PatientAppointmentDayLabel = new javax.swing.JLabel();
        PatientAppointmentDayBox = new javax.swing.JComboBox<>();
        PatientAppointmentYearBox = new javax.swing.JComboBox<>();
        PatientAppointmentHourBox = new javax.swing.JComboBox<>();
        PatientAppointmentMinuteBox = new javax.swing.JComboBox<>();
        PatientAppointmentYearLabel = new javax.swing.JLabel();
        PatientAppointmentHourLabel = new javax.swing.JLabel();
        PatientAppointmentMinuteLabel = new javax.swing.JLabel();
        PatientApprovePatientButton = new javax.swing.JButton();
        
        
        
        PatientAppointmentMonthBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        PatientAppointmentSubmitButton.setText("Submit");
        PatientAppointmentBackButton.setText("Back");
        PatientAppointmentDoctorLabel.setText("Doctor");
        PatientAppointmentMonthLabel.setText("Month");
        PatientAppointmentDayLabel.setText("Day");
        PatientAppointmentHourBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
        PatientAppointmentMinuteBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
        PatientAppointmentYearLabel.setText("Year");
        PatientAppointmentHourLabel.setText("Hour");
        PatientAppointmentMinuteLabel.setText("Minute");
        
        setAppointmentYears();
        
        PatientAppointmentMonthBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                SecretaryAppointmentMonthBoxItemStateChanged(evt);
            }
        });
        
        PatientAppointmentYearBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                SecretaryAppointmentYearBoxItemStateChanged(evt);
            }
        });
        
        
        javax.swing.GroupLayout SecretaryAppointmentPanelLayout = new javax.swing.GroupLayout(this);
        this.setLayout(SecretaryAppointmentPanelLayout);
        SecretaryAppointmentPanelLayout.setHorizontalGroup(
            SecretaryAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SecretaryAppointmentPanelLayout.createSequentialGroup()
                .addGroup(SecretaryAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SecretaryAppointmentPanelLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(SecretaryAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SecretaryAppointmentPanelLayout.createSequentialGroup()
                                .addGroup(SecretaryAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PatientAppointmentDoctorLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SecretaryAppointmentPanelLayout.createSequentialGroup()
                                .addGroup(SecretaryAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(PatientAppointmentDoctorBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SecretaryAppointmentPanelLayout.createSequentialGroup()
                                        .addGroup(SecretaryAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(SecretaryAppointmentPanelLayout.createSequentialGroup()
                                                .addComponent(PatientAppointmentMonthLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(PatientAppointmentDayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(22, 22, 22)
                                                .addComponent(PatientAppointmentYearLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                                .addGap(16, 16, 16))
                                            .addGroup(SecretaryAppointmentPanelLayout.createSequentialGroup()
                                                .addComponent(PatientAppointmentMonthBox, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(PatientAppointmentDayBox, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(PatientAppointmentYearBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                        .addGroup(SecretaryAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(PatientAppointmentHourBox, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(SecretaryAppointmentPanelLayout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(PatientAppointmentHourLabel)))
                                        .addGap(18, 18, 18)
                                        .addGroup(SecretaryAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(PatientAppointmentMinuteLabel)
                                            .addComponent(PatientAppointmentMinuteBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(129, 129, 129))))
                    .addGroup(SecretaryAppointmentPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PatientAppointmentBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(PatientAppointmentSubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        SecretaryAppointmentPanelLayout.setVerticalGroup(
            SecretaryAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SecretaryAppointmentPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(PatientAppointmentDoctorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PatientAppointmentDoctorBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SecretaryAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PatientAppointmentYearLabel)
                    .addComponent(PatientAppointmentDayLabel)
                    .addComponent(PatientAppointmentMonthLabel)
                    .addComponent(PatientAppointmentHourLabel)
                    .addComponent(PatientAppointmentMinuteLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SecretaryAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PatientAppointmentMonthBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PatientAppointmentDayBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PatientAppointmentYearBox, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PatientAppointmentHourBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PatientAppointmentMinuteBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(SecretaryAppointmentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PatientAppointmentSubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PatientAppointmentBackButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        
    }
     private void setAppointmentYears()
    {
        for (int i = LocalDateTime.now().getYear();i < (LocalDateTime.now().getYear()+20);i++)
                {
                    PatientAppointmentYearBox.addItem(String.valueOf(i));
                }
    }
     
     private void SecretaryAppointmentMonthBoxItemStateChanged(java.awt.event.ItemEvent evt) {                                                              
        setAppointmentDays(Integer.parseInt(PatientAppointmentMonthBox.getSelectedItem().toString()));
    }  
     
     private void SecretaryAppointmentYearBoxItemStateChanged(java.awt.event.ItemEvent evt) {
        setAppointmentDays(Integer.parseInt(PatientAppointmentMonthBox.getSelectedItem().toString()));
    }    
     
     
     
     private void setAppointmentDays(int month)
    {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                PatientAppointmentDayBox.removeAllItems();
                for(int i = 0; i < 31 ; i++)
                {
                    PatientAppointmentDayBox.addItem(String.format("%02d",i + 1));
                }   break;
            case 4:
            case 6:
            case 9:
            case 11:
                PatientAppointmentDayBox.removeAllItems();
                for(int i = 0; i < 30 ; i++)
                {
                    PatientAppointmentDayBox.addItem(String.format("%02d",i + 1));
                }   break;
            case 2:
                PatientAppointmentDayBox.removeAllItems();
                for(int i = 0; i < 28 ; i++)
                {
                    PatientAppointmentDayBox.addItem(String.format("%02d",i + 1));
                }   
                int year = Integer.parseInt(PatientAppointmentYearBox.getSelectedItem().toString());
                if (((year % 4 == 0) && (year % 100!= 0)) || (year%400 == 0))
                {
                    PatientAppointmentDayBox.addItem("29");
                }   
                break;
            default:
                break;
        }
    }
     
     
     
     public Doctor getDoctor(){
                return (Doctor)PatientAppointmentDoctorBox.getSelectedItem();
    }
     
     public void setDoctors(DefaultComboBoxModel<Doctor> doctorModel){
                PatientAppointmentDoctorBox.setModel(doctorModel);
    }
     
     public void addSubmitListener(ActionListener listenForSubmit){
        PatientAppointmentSubmitButton.addActionListener(listenForSubmit);
    }
    
    public void addBackListener(ActionListener listenForSubmit){
        PatientAppointmentBackButton.addActionListener(listenForSubmit);
    }
    
    public String getPatientAppointmentDay(){
        return PatientAppointmentDayBox.getSelectedItem().toString();
    }
    
    public String getPatientAppointmentMonthBox(){
        return PatientAppointmentMonthBox.getSelectedItem().toString();
    }
    
   public String getPatientAppointmentYearBox(){
        return PatientAppointmentYearBox.getSelectedItem().toString();
    }
     
    public String getPatientAppointmentHourBox(){
        return PatientAppointmentHourBox.getSelectedItem().toString();
    }
      
    public String getPatientAppointmentMinuteBox(){
        return PatientAppointmentMinuteBox.getSelectedItem().toString();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
