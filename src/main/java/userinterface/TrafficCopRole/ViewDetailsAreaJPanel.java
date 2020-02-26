/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.TrafficCopRole;

import Business.EcoSystem;
import Business.WorkQueue.TrafficWorkRequest;
import com.db4o.ext.Db4oException;
import com.dropbox.core.DbxDownloader;
import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.google.common.io.Files;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author pranav
 */
public class ViewDetailsAreaJPanel extends javax.swing.JPanel {
    private JPanel userProcessContainer;
    private TrafficWorkRequest request;
    private static String product = "";
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    /**
     * Creates new form ViewDetailsAreaJPanel
     */
//    public ViewDetailsAreaJPanel() {
//        initComponents();
//    }

    ViewDetailsAreaJPanel(JPanel userProcessContainer, TrafficWorkRequest request) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.request = request;
        populateFields();
    }
    
    /*
    Code for rendering the image in picLabel
    */
    public static String getExtensionByGuava(String filename) {
        return Files.getFileExtension(filename);
    }
    public String download(String webPath) throws Db4oException, IOException, DbxException 
    {
        DbxRequestConfig config = new DbxRequestConfig("sample", "en_US");
        DbxClientV2 client = new DbxClientV2(config, EcoSystem.ACCESS_TOKEN);
        
        //String fileSeparator = System.getProperty("file.separator");
        //System.out.println(fileSeparator);
        
        //String root = "/home/pranav/group2/thebugslayers/Urban/UrbanMaven/resources/";
        
        
        System.out.println(System.getProperty("user.dir"));
        
        String root = System.getProperty("user.dir");
        root = root + "\\" + "resources";
        String newname = randomAlphaNumeric(5);
        DbxDownloader<FileMetadata> downloader = client.files().download(webPath);        
        try {
            
            newname = newname + "." + getExtensionByGuava(webPath);
            root = root + "\\" + newname;
//            File file = new File(root+newname);
//            FileOutputStream out = new FileOutputStream(newname);

            FileOutputStream out = new FileOutputStream(root);
            //FileOutputStream out = new FileOutputStream(newname);
            downloader.download(out);
            out.close();
        } catch (DbxException ex) {
            System.out.println("unable to create a local file for product path "+ root);
        }
        
        System.out.println(root);
        return root;
    }
    
    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
        int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
        builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }
    /*
    Code to Populate Work request fields and the image
    */
    private void populateFields(){
        jLabel5.setText(request.getMessage());
        jLabel6.setText(request.getSender().toString());
        //jLabel7.setText(request.getRequestDate().toString());
        
        if(request.getImgLocation()==null)
        {
            picLabel.setText("No corresponding image for the selected request");
            return;
        }
        
        System.out.println("WEB location "+request.getImgLocation());
//        String product = "";
        try
        {
            product = download(request.getImgLocation());
        }
        catch(Exception e)
        {
            System.out.println("Some issue with downloading");
            
        }
        
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(product));
            Image dimg = img.getScaledInstance(160 , 90,Image.SCALE_SMOOTH);

        ImageIcon imageIcon = new ImageIcon(dimg);
        picLabel.setIcon(imageIcon);
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Unable to find " + product);
        }

        
        /*int labelh = picLabel.getHeight();
        int labelw = picLabel.getWidth();
        int aspectRatio = labelw/labelh;
        
        System.out.println(img.getWidth()+" x " + img.getHeight());
        int imageh = (int) (img.getWidth() / aspectRatio);
        int imagew = (int) (img.getHeight() * aspectRatio);
        
        System.out.println("imageh is "+imageh);*/
        
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        picLabel = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        jLabel1.setText("Work Request Details");

        jLabel2.setText("Name");

        jLabel3.setText("Sender");

        jLabel4.setText("Request Date");

        jLabel5.setText("jLabel5");

        jLabel6.setText("jLabel6");

        jLabel7.setText("jLabel7");

        jLabel8.setText("Image");

        picLabel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        picLabel.setMaximumSize(new java.awt.Dimension(160, 90));
        picLabel.setMinimumSize(new java.awt.Dimension(160, 90));
        picLabel.setPreferredSize(new java.awt.Dimension(160, 90));

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(picLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(124, 124, 124))
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(btnBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(279, 279, 279))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(picLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addGap(25, 25, 25)
                .addComponent(btnBack)
                .addGap(47, 47, 47))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        TrafficCopWorkAreaJPanel dwjp = (TrafficCopWorkAreaJPanel) component;
        dwjp.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        File file = new File(product);
        file.delete();
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel picLabel;
    // End of variables declaration//GEN-END:variables
}
