/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.Label;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author richa_bfe6tpy
 */
public class AdminView extends javax.swing.JPanel {

    private Label label2;
    private JButton AdminCreateAccountButton;
    private JButton AdminModifyDoctorsButton;
    private JButton AdminViewRatingsButton;
    private JButton AdminModifySecretariesButton;
    private JButton AdminLogoutButton;

    /**
     * Creates new form AdministratorView
     */
    
    public AdminView() {
        myInitComponents();
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

    public void myInitComponents() {
        label2 = new java.awt.Label();
        AdminCreateAccountButton = new javax.swing.JButton();
        AdminModifyDoctorsButton = new javax.swing.JButton();
        AdminViewRatingsButton = new javax.swing.JButton();
        AdminModifySecretariesButton = new javax.swing.JButton();
        AdminLogoutButton = new javax.swing.JButton();
        
        label2.setAlignment(java.awt.Label.CENTER);
        label2.setText("Admin Panel");

        AdminCreateAccountButton.setText("Create Account");
        

        AdminModifyDoctorsButton.setText("Modify Doctors ");

        AdminViewRatingsButton.setText("View Ratings ");
        

        AdminModifySecretariesButton.setText("Modify Secretaries ");
        
     

        AdminLogoutButton.setText("Logout");
       

        javax.swing.GroupLayout AdminMainPanelLayout = new javax.swing.GroupLayout(this);
        this.setLayout(AdminMainPanelLayout);
        AdminMainPanelLayout.setHorizontalGroup(
            AdminMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminMainPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(AdminMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AdminCreateAccountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AdminLogoutButton))
                .addGap(18, 18, 18)
                .addGroup(AdminMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AdminModifySecretariesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AdminMainPanelLayout.createSequentialGroup()
                        .addGroup(AdminMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(label2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AdminModifyDoctorsButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addComponent(AdminViewRatingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        AdminMainPanelLayout.setVerticalGroup(
            AdminMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdminMainPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(AdminMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AdminLogoutButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AdminMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AdminCreateAccountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AdminMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(AdminModifyDoctorsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AdminViewRatingsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AdminModifySecretariesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

    }
    
    
    
    
    
    
    public void addAdminCreateAccountListener(ActionListener listenForAdminCreateAccount){
        AdminCreateAccountButton.addActionListener(listenForAdminCreateAccount);
    }
    
    public void addAdminModifyDoctorsListener(ActionListener listenForAdminModifyDoctors){
        AdminModifyDoctorsButton.addActionListener(listenForAdminModifyDoctors);
    }
    
    public void addAdminViewRatingsListener(ActionListener listenForAdminViewRatings){
        AdminViewRatingsButton.addActionListener(listenForAdminViewRatings);
    }
    
    public void addAdminModifySecretariesListener(ActionListener listenForAdminModifySecretaries){
        AdminModifySecretariesButton.addActionListener(listenForAdminModifySecretaries);
    }
    
    public void addAdminLogoutListener(ActionListener listenForAdminLogout){
        AdminLogoutButton.addActionListener(listenForAdminLogout);
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
