/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bandcontrols;

import com.digi.xbee.api.XBeeDevice;
import com.digi.xbee.api.RemoteXBeeDevice;
import com.digi.xbee.api.models.XBee64BitAddress;
import com.digi.xbee.api.exceptions.XBeeException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.nio.file.StandardOpenOption;
import java.util.*;

/**
 *
 * @author ECE 590 Team 2
 */
public class DesignGUI extends javax.swing.JFrame {

    // GUI Controller for access to model.
    private GUIController _controller;

    // Reference to the script file on the computer.
    private File _script;
    
    /**
     * Creates new form ControlsGUI
     */
    public DesignGUI() {
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

        uxSaveDialog = new javax.swing.JFileChooser();
        uxInstrumentBox = new javax.swing.JComboBox<>();
        uxInstrumentNumberBox = new javax.swing.JComboBox<>();
        uxColorBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        uxWorkingScript = new javax.swing.JTextArea();
        uxAddButton = new javax.swing.JButton();
        uxSaveButton = new javax.swing.JButton();
        uxConfigureButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        uxSetNumberBox = new javax.swing.JTextPane();
        uxSetNumberLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        uxInstrumentBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trumpet", "Alto Sax", "Trombone", "Flute", "Snare Drum", "Tenor Drum", "Piccolo" }));

        uxInstrumentNumberBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }));

        uxColorBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Red", "Green", "Blue" }));

        uxWorkingScript.setColumns(20);
        uxWorkingScript.setLineWrap(true);
        uxWorkingScript.setRows(5);
        jScrollPane1.setViewportView(uxWorkingScript);

        uxAddButton.setText("Add Line");
        uxAddButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uxAddButtonMouseClicked(evt);
            }
        });

        uxSaveButton.setText("Save");
        uxSaveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uxSaveButtonMouseClicked(evt);
            }
        });

        uxConfigureButton.setText("Configure...");
        uxConfigureButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uxConfigureButtonMouseClicked(evt);
            }
        });

        jScrollPane2.setName(""); // NOI18N
        jScrollPane2.setViewportView(uxSetNumberBox);

        uxSetNumberLabel.setText("Set Number: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(uxSetNumberLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane2))
                                    .addComponent(uxInstrumentBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(uxSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(185, 185, 185))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(uxColorBox, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(uxInstrumentNumberBox, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(uxConfigureButton, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(322, 322, 322)
                                .addComponent(uxAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 441, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(17, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(uxSetNumberLabel))
                        .addGap(41, 41, 41)
                        .addComponent(uxInstrumentBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(uxConfigureButton)
                            .addComponent(uxSaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(uxInstrumentNumberBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(uxColorBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(uxAddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void uxConfigureButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uxConfigureButtonMouseClicked
        // TODO add your handling code here:
        ConfigGUI config = new ConfigGUI();
        config.setVisible(true);
    }//GEN-LAST:event_uxConfigureButtonMouseClicked

    /**
     * Ensures that closing the DesignGUI does not close the StartGUI.
     * @param evt 
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_formWindowClosing

    /**
     * Saves the edited script to the controller.
     * TODO: FIX => NOT SAVING
     * @param evt 
     */
    private void uxSaveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uxSaveButtonMouseClicked
        StartGUI.controller.saveScript(uxWorkingScript.getText());
        uxSaveDialog = new JFileChooser(_script);
        if (uxSaveDialog.showSaveDialog(this) == 0)
        {
            try {
                List<String> text = Arrays.asList(uxWorkingScript.getText());
                Files.write(uxSaveDialog.getSelectedFile().toPath(), text, Charset.forName("UTF-8"));
            } catch (IOException ex) {
                Logger.getLogger(DesignGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_uxSaveButtonMouseClicked

    /**
     * Adds a line to the working script based upon the instrument information selected.
     * @param evt 
     */
    private void uxAddButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uxAddButtonMouseClicked
        String instrument = (String)uxInstrumentBox.getSelectedItem();
        String instNum = (String)uxInstrumentNumberBox.getSelectedItem();
        String color = (String)uxColorBox.getSelectedItem();
        uxWorkingScript.append(instrument.replace(" ", "") + "," + instNum + "," + color + "\n");
    }//GEN-LAST:event_uxAddButtonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DesignGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DesignGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DesignGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DesignGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DesignGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton uxAddButton;
    private javax.swing.JComboBox<String> uxColorBox;
    private javax.swing.JButton uxConfigureButton;
    private javax.swing.JComboBox<String> uxInstrumentBox;
    private javax.swing.JComboBox<String> uxInstrumentNumberBox;
    private javax.swing.JButton uxSaveButton;
    private javax.swing.JFileChooser uxSaveDialog;
    private javax.swing.JTextPane uxSetNumberBox;
    private javax.swing.JLabel uxSetNumberLabel;
    private javax.swing.JTextArea uxWorkingScript;
    // End of variables declaration//GEN-END:variables
}
