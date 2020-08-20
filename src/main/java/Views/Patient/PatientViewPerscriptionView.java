/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Patient;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import models.Perscription;

/**
 *
 * @author richa_bfe6tpy
 */
//This class provide a panel which contains the Patient view perscription details view.
public class PatientViewPerscriptionView extends javax.swing.JPanel {

    /**
     * Creates new form PatientViewPerscriptionView
     */
    public PatientViewPerscriptionView() {
        initComponents();
        PatientViewPerscriptionPerscriptionList.setCellRenderer(createListRenderer());//Sets patient perscription list box to use custom renderer
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PatientViewPerscriptionHeaderLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PatientViewPerscriptionPerscriptionList = new javax.swing.JList<>();
        PatientBackButton = new javax.swing.JButton();
        PatientViewPerscriptionPrintButton = new javax.swing.JButton();

        PatientViewPerscriptionHeaderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PatientViewPerscriptionHeaderLabel.setText("Patient View Perscription");

        PatientViewPerscriptionPerscriptionList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(PatientViewPerscriptionPerscriptionList);

        PatientBackButton.setText("Back");

        PatientViewPerscriptionPrintButton.setText("Print");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                    .addComponent(PatientViewPerscriptionHeaderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PatientBackButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PatientViewPerscriptionPrintButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(PatientViewPerscriptionHeaderLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PatientBackButton)
                    .addComponent(PatientViewPerscriptionPrintButton))
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    //Button Listeners
    public void addPatientBackButton(ActionListener listenForBack){
        PatientBackButton.addActionListener(listenForBack);
    }
    
    public void addPatientPerscriptionPrintButton(ActionListener listenForPrint){
        PatientViewPerscriptionPrintButton.addActionListener(listenForPrint);
    }
    
    //Set Perscription model & get perscription element 
    public Perscription getPerscriptionToPrint(){
        return (Perscription) PatientViewPerscriptionPerscriptionList.getSelectedValue();
    }
    
    public void setPerscription(DefaultListModel model){
        PatientViewPerscriptionPerscriptionList.setModel(model);
    }
    
    //custom cell renderer for perscription Medicine:Dosage
    
    private static ListCellRenderer<? super Perscription> createListRenderer() {
      return new DefaultListCellRenderer() {
          private Color background = new Color(0, 100, 255, 15);
          private Color defaultBackground = (Color) UIManager.get("List.background");
          
          public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                        boolean isSelected, boolean cellHasFocus) {
              Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
              if (c instanceof JLabel) {
                  JLabel label = (JLabel) c;
                  Perscription p = (Perscription) value;
                  label.setText(String.format("Medicine:%s         Dosage:%s", p.getMedicine().getName(), p.getDosage()));
                  if (!isSelected) {
                      label.setBackground(index % 2 == 0 ? background : defaultBackground);
                  }
              }
              return c;
          }
      };
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PatientBackButton;
    private javax.swing.JLabel PatientViewPerscriptionHeaderLabel;
    private javax.swing.JList<Perscription> PatientViewPerscriptionPerscriptionList;
    private javax.swing.JButton PatientViewPerscriptionPrintButton;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
