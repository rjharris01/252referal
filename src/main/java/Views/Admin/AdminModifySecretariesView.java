/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Admin;

import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import models.user.Secretary;
import models.user.User;

/**
 *
 * @author richa_bfe6tpy
 */

//This class provide a panel which contains the Admin Modify Secretaries  view.
public class AdminModifySecretariesView extends javax.swing.JPanel {

    /**
     * Creates new form AdminModifySecretariesView
     */
    public AdminModifySecretariesView() {
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

        AdminBackButton = new javax.swing.JButton();
        AdminModifySecretaryDeleteButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        AdminModifySecretaryListBox = new javax.swing.JList<>();
        AdminModifySecretaryLabel = new javax.swing.JLabel();

        AdminBackButton.setText("Back");

        AdminModifySecretaryDeleteButton.setText("Delete");

        AdminModifySecretaryListBox.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(AdminModifySecretaryListBox);

        AdminModifySecretaryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AdminModifySecretaryLabel.setText("Select Secretary To Delete");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AdminBackButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AdminModifySecretaryDeleteButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(AdminModifySecretaryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(AdminModifySecretaryLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AdminBackButton)
                    .addComponent(AdminModifySecretaryDeleteButton))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    //Button listeners
    public void addBackListener(ActionListener listenForSubmit){
        AdminBackButton.addActionListener(listenForSubmit);
    }
    
    public void addDeleteListener(ActionListener listenForDelete){
        AdminModifySecretaryDeleteButton.addActionListener(listenForDelete);
    }
    
    
     //Get to return Secretary
    public Secretary getSelectedUser(){
        Secretary user = AdminModifySecretaryListBox.getSelectedValue();
        return user;
    }
    
    //Functions to setup the Secretary list box
    
    public void clearList()
    {
        AdminModifySecretaryListBox.removeAll();
    }
    
    public void setSecretaryList(DefaultListModel<Secretary> users)
    {
        AdminModifySecretaryListBox.setModel(users);
    }
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdminBackButton;
    private javax.swing.JButton AdminModifySecretaryDeleteButton;
    private javax.swing.JLabel AdminModifySecretaryLabel;
    private javax.swing.JList<Secretary> AdminModifySecretaryListBox;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
