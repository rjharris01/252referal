/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author richa_bfe6tpy
 */
public class AdminCreateAccountView extends javax.swing.JPanel {

    private JComboBox<Object> AdminAccountTypeBox;
    private JLabel AdminCreateAccountTypeLabel;
    private JLabel AdminCreatePasswordLabel;
    private JPasswordField AdminCreatePasswordField;
    private JLabel AdminCreateAddressLabel;
    private JTextField AdminCreateAddressField;
    private JLabel AdminCreateNameLabel;
    private JTextField AdminCreateNameField;
    private JButton AdminCreateSubmitButton;

    /**
     * Creates new form AdminCreateAccountView
     */
    public AdminCreateAccountView() {
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
        
        AdminAccountTypeBox = new javax.swing.JComboBox<>();
        AdminCreateAccountTypeLabel = new javax.swing.JLabel();
        AdminCreatePasswordLabel = new javax.swing.JLabel();
        AdminCreatePasswordField = new javax.swing.JPasswordField();
        AdminCreateAddressLabel = new javax.swing.JLabel();
        AdminCreateAddressField = new javax.swing.JTextField();
        AdminCreateNameLabel = new javax.swing.JLabel();
        AdminCreateNameField = new javax.swing.JTextField();
        AdminCreateSubmitButton = new javax.swing.JButton();
        
        
        
        AdminAccountTypeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Secretary", "Doctor", "Administrator" }));
      
        AdminCreateAccountTypeLabel.setText("Account Type :");

        AdminCreatePasswordLabel.setText("Password        :");

        AdminCreatePasswordField.setText("jPasswordField1");
        AdminCreatePasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                AdminCreatePasswordFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                AdminCreatePasswordFieldFocusLost(evt);
            }
        });

        AdminCreateAddressLabel.setText("Address          :");

        AdminCreateAddressField.setText("Enter Address Here");
        AdminCreateAddressField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                AdminCreateAddressFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                AdminCreateAddressFieldFocusLost(evt);
            }
        });

        AdminCreateNameLabel.setText("Name              :");

        AdminCreateNameField.setText("Enter Name Here");
        AdminCreateNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                AdminCreateNameFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                AdminCreateNameFieldFocusLost(evt);
            }
        });

        AdminCreateSubmitButton.setText("Submit");
        

        javax.swing.GroupLayout AdminCreateAccountPanelLayout = new javax.swing.GroupLayout(this);
        this.setLayout(AdminCreateAccountPanelLayout);
        AdminCreateAccountPanelLayout.setHorizontalGroup(
            AdminCreateAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminCreateAccountPanelLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(AdminCreateAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AdminCreateNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AdminCreateAddressLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AdminCreatePasswordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AdminCreateAccountTypeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AdminCreateAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AdminCreateNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(AdminCreatePasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(AdminAccountTypeBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AdminCreateAddressField))
                .addContainerGap(352, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdminCreateAccountPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AdminCreateSubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        AdminCreateAccountPanelLayout.setVerticalGroup(
            AdminCreateAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminCreateAccountPanelLayout.createSequentialGroup()
                .addGroup(AdminCreateAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AdminCreateAccountPanelLayout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(AdminCreateNameLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AdminCreateAccountPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(AdminCreateNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AdminCreateAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AdminCreateAddressLabel)
                    .addComponent(AdminCreateAddressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AdminCreateAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AdminCreatePasswordLabel)
                    .addComponent(AdminCreatePasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AdminCreateAccountPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AdminCreateAccountTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AdminAccountTypeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addComponent(AdminCreateSubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }

    
    private void AdminCreateNameFieldFocusLost(java.awt.event.FocusEvent evt) {                                               
        if (AdminCreateNameField.getText().equals(""))
        {
            AdminCreateNameField.setText("Enter Name Here");
        }
    }                                              

    private void AdminCreateAddressFieldFocusLost(java.awt.event.FocusEvent evt) {                                                  
        if (AdminCreateAddressField.getText().equals(""))
        {
            AdminCreateAddressField.setText("Enter Address Here");
        }
    }                                                 

    private void AdminCreateNameFieldFocusGained(java.awt.event.FocusEvent evt) {                                                 
        AdminCreateNameField.setText("");
    }                                                

    private void AdminCreateAddressFieldFocusGained(java.awt.event.FocusEvent evt) {                                                    
        AdminCreateAddressField.setText("");
    }                                                   

    private void AdminCreatePasswordFieldFocusGained(java.awt.event.FocusEvent evt) {                                                     
        AdminCreatePasswordField.setText("");
    }                                                    

    private void AdminCreatePasswordFieldFocusLost(java.awt.event.FocusEvent evt) {                                                   
        if (AdminCreatePasswordField.getPassword().length == 0)
        {
            AdminCreatePasswordField.setText("Enter Password Here");
        }
    }    
    
    public void addSubmitListener(ActionListener listenForSubmit){
        AdminCreateSubmitButton.addActionListener(listenForSubmit);
    }
    
    public String getAccountType(){
                return AdminAccountTypeBox.getSelectedItem().toString();
    }
    
    public void setFirstAccountType(){
        AdminAccountTypeBox.removeAll();
        AdminAccountTypeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"Administrator" }));
    }
    
    public String getAccountName(){
        return AdminCreateNameField.getText();
    }
    
    public String getAccountPassword() {
        return Arrays.toString(AdminCreatePasswordField.getPassword());
    }
    
    public String getAccountAddress() {
        return AdminCreateAddressField.getText();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
