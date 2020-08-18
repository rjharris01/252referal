/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Secretary;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import models.Perscription;
import models.user.Patient;

/**
 *
 * @author richa_bfe6tpy
 */
public class SecretaryCompletePerscriptionView extends javax.swing.JPanel {

    /**
     * Creates new form SecretaryCompletePerscriptionView
     */
    public SecretaryCompletePerscriptionView() {
        initComponents();
        SecretaryCompletePerscriptionPerscriptionsListBox.setCellRenderer(perscriptionRenderer());
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        SecretaryCompletePerscriptionPerscriptionsListBox = new javax.swing.JList<>();
        SecretaryCompletePerscriptionHeaderLabel = new javax.swing.JLabel();
        SecretaryCompletePerscriptionPatientComboBox = new javax.swing.JComboBox<>();
        SecretaryCompletePerscriptionPatientLabel = new javax.swing.JLabel();
        SecretaryCompletePerscriptionPerscriptionsLabel = new javax.swing.JLabel();
        SecretaryCompletePerscriptionCompleteSubmitButton = new javax.swing.JButton();
        SecretaryBackButton = new javax.swing.JButton();

        SecretaryCompletePerscriptionPerscriptionsListBox.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(SecretaryCompletePerscriptionPerscriptionsListBox);

        SecretaryCompletePerscriptionHeaderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SecretaryCompletePerscriptionHeaderLabel.setText("Complete Perscription");

        SecretaryCompletePerscriptionPatientLabel.setText("Patient:");

        SecretaryCompletePerscriptionPerscriptionsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SecretaryCompletePerscriptionPerscriptionsLabel.setText("Prescriptions");

        SecretaryCompletePerscriptionCompleteSubmitButton.setText("Complete");

        SecretaryBackButton.setText("Back");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SecretaryCompletePerscriptionPerscriptionsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SecretaryCompletePerscriptionHeaderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SecretaryCompletePerscriptionPatientLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SecretaryCompletePerscriptionPatientComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(SecretaryBackButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SecretaryCompletePerscriptionCompleteSubmitButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SecretaryCompletePerscriptionHeaderLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SecretaryCompletePerscriptionPatientComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SecretaryCompletePerscriptionPatientLabel))
                .addGap(18, 18, 18)
                .addComponent(SecretaryCompletePerscriptionPerscriptionsLabel)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SecretaryCompletePerscriptionCompleteSubmitButton)
                    .addComponent(SecretaryBackButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    public void addPatientSelectListener (ActionListener listenForPatientChange)
    {
        SecretaryCompletePerscriptionPatientComboBox.addActionListener(listenForPatientChange);
    }
    
    public void addBackListener(ActionListener listenForBack){
        SecretaryBackButton.addActionListener(listenForBack);
    }
    
     public void addSubmitListener(ActionListener listenForSubmit){
        SecretaryCompletePerscriptionCompleteSubmitButton.addActionListener(listenForSubmit);
    }
     
     public void clearPerscriptionsList(){
         SecretaryCompletePerscriptionPerscriptionsListBox.removeAll();
     }
     
     public Perscription getPerscription(){
         return SecretaryCompletePerscriptionPerscriptionsListBox.getSelectedValue();
     }
     
     public Patient getPatient(){
         return (Patient)SecretaryCompletePerscriptionPatientComboBox.getSelectedItem();
     }
     
     public void setPatientList(DefaultComboBoxModel Model){
         SecretaryCompletePerscriptionPatientComboBox.setModel(Model);
     }
     
     public void setPerscriptionList(DefaultListModel model){
         SecretaryCompletePerscriptionPerscriptionsListBox.setModel(model);
     }
     
     private static ListCellRenderer<? super Perscription> perscriptionRenderer() {
      return new DefaultListCellRenderer() {
          private Color background = new Color(0, 100, 255, 15);
          private Color defaultBackground = (Color) UIManager.get("List.background");
          
          public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                        boolean isSelected, boolean cellHasFocus) {
              Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
              if (c instanceof JLabel) {
                  JLabel label = (JLabel) c;
                  Perscription p = (Perscription) value;
                  label.setText(String.format("Medicine:%s         Dosage:%s         Quantity:%s", p.getMedicine().getName(), p.getDosage(), p.getQuantity()));
                  if (!isSelected) {
                      label.setBackground(index % 2 == 0 ? background : defaultBackground);
                  }
              }
              return c;
          }
      };
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SecretaryBackButton;
    private javax.swing.JButton SecretaryCompletePerscriptionCompleteSubmitButton;
    private javax.swing.JLabel SecretaryCompletePerscriptionHeaderLabel;
    private javax.swing.JComboBox<Patient> SecretaryCompletePerscriptionPatientComboBox;
    private javax.swing.JLabel SecretaryCompletePerscriptionPatientLabel;
    private javax.swing.JLabel SecretaryCompletePerscriptionPerscriptionsLabel;
    private javax.swing.JList<Perscription> SecretaryCompletePerscriptionPerscriptionsListBox;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
