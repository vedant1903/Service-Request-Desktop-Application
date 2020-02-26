/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.InventoryMgr;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.MunicipalEnterprise;
import Business.Inventory.InventoryItem;
import Business.Network.Network;
import Business.Organization.InventoryOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.InventoryWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vedan
 */
public class ViewRequestDetailsJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private InventoryOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private InventoryWorkRequest request;
    private EcoSystem system;
    private Network network;
    MunicipalEnterprise mp;
    /**
     * Creates new form ViewRequestDetailsJPanel
     */
    public ViewRequestDetailsJPanel(JPanel userProcessContainer, InventoryWorkRequest workRequest, Enterprise enterprise, UserAccount userAccount, EcoSystem system) {
        this.request = workRequest;
        this.enterprise = enterprise;
        this.system =system;
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        
        initComponents();
        setButtons();
        populateLabels();
        populateRequestTable();
    }
    
    public void setButtons()
    {
        if(request.getStatus().equals("Complete"))
        {
            approveBtn.setEnabled(false);
            declineBtn.setEnabled(false);
        }
    }
    
    public void populateLabels()
    {
        senderLabel.setText(request.getSender().getUsername());
        if(request.getReceiver()!=null)
        {
            receiverLabel.setText(request.getReceiver().getUsername());
        }
        
        message.setText(request.getMessage());
        statusLabel.setText(request.getStatus());
    }
    
    public void populateRequestTable()
    {
        
        DefaultTableModel model = (DefaultTableModel)reqTable.getModel();
        model.setRowCount(0);
        
        try
        {
        for(InventoryItem item : request.getItemsRequired()){
            
            Object[] row = new Object[2];
            
            //InventoryWorkRequest req = (InventoryWorkRequest) request;
            
            row[0] = item.getItemName();
            row[1] = item.getQuantity();
            
            model.addRow(row);
        }}
        catch(Exception e)
        {
            System.out.println("Cant populate table");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        message = new javax.swing.JLabel();
        senderLabel = new javax.swing.JLabel();
        receiverLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reqTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        approveBtn = new javax.swing.JButton();
        declineBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();

        jLabel2.setText("Sender : ");

        jLabel3.setText("Receiver : ");

        jLabel1.setText("Message : ");

        message.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        senderLabel.setText("John Cross");

        receiverLabel.setText("Yet to be assigned");

        reqTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name ", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(reqTable);

        jButton1.setText("<<Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        approveBtn.setText("Approve");
        approveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveBtnActionPerformed(evt);
            }
        });

        declineBtn.setText("Decline");

        jLabel4.setText("Status : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(message, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(receiverLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(senderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(143, 143, 143)
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 85, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jButton1)
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(approveBtn)
                                .addGap(349, 349, 349)
                                .addComponent(declineBtn))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(senderLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(receiverLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(approveBtn)
                    .addComponent(declineBtn))
                .addContainerGap(166, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        InventoryMgrWorkAreaJPanel dwjp = (InventoryMgrWorkAreaJPanel) component;
        dwjp.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void approveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveBtnActionPerformed
        // TODO add your handling code here:
        System.out.println(request.getAssigned()!=userAccount);
        if(request.getAssigned() != userAccount)
        {
            JOptionPane.showMessageDialog(null, "This service is not assigned to you");
            return;
        }
        
        
        boolean flag = true; 
        try
        {
            for(InventoryItem item : request.getItemsRequired())
            {
                for(InventoryItem eitem : enterprise.getInventoryDirectoryEnterpriseLevel().getInventoryList())
                {
                    if(item.getItemName().equals(eitem.getItemName()))
                    {
                        if(item.getQuantity()> eitem.getQuantity())
                            flag = false;
                    }
                }
            }
            
            if(flag)
            {
                System.out.println("Inside flag loop");
                for(InventoryItem item : request.getItemsRequired())
            {
                for(InventoryItem eitem : enterprise.getInventoryDirectoryEnterpriseLevel().getInventoryList())
                {
                    if(item.getItemName().equals(eitem.getItemName()))
                    {
                        int temp = eitem.getQuantity();
                        eitem.setQuantity(temp - item.getQuantity());
                    }
                    
                }
            }
                
                request.setStatus("Complete");             
                //organization.getWorkQueue().deleteWorkRequest(request);
            }
            else 
            {
                JOptionPane.showMessageDialog(null, "Not enough materials for the job. Please raise a request with the finance team.");
            }
            
        }
        
        catch(Exception e)
        {
            System.out.println("Item not found");
        }
        
    }//GEN-LAST:event_approveBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton approveBtn;
    private javax.swing.JButton declineBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel message;
    private javax.swing.JLabel receiverLabel;
    private javax.swing.JTable reqTable;
    private javax.swing.JLabel senderLabel;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables
}
