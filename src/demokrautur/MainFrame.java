/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demokrautur;

import java.awt.Color;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Phil
 */
public class MainFrame extends javax.swing.JFrame {

    private static int hoehe = 20;
    private static int laenge = 20;
    private int reload = 100;
    private int interationen = 0;

    private ArrayList<Bewohner> spielfeld;
    private ArrayList<Partei> parteien;
    private Random random = new Random();

    private void ausgabe() {

        for (int i = 0; i < laenge * hoehe; i++) {
            spielfeld.get(i).paint(spielfeld.get(i).getGraphics());
        }

        interration_anzahl_graf.setText(interationen + "");
        
    }

    private void gameloop() {

        Wraparound wraparound = new Wraparound(hoehe, laenge);

        for (int i = 0; i < (int) interation_int.getValue(); i++) {
            int rngbewohner = random.nextInt((hoehe * laenge)) + 1;
            wraparound.setBewohner(rngbewohner);
            int randomNachbar = (random.nextInt(4) + 1);
            switch (randomNachbar) {
                case 1:
                    randomNachbar = wraparound.getUp();
                    break;
                case 2:
                    randomNachbar = wraparound.getRight();
                    break;
                case 3:
                    randomNachbar = wraparound.getDown();
                    break;
                case 4:
                    randomNachbar = wraparound.getLeft();
                    break;
                default:
                    break;
            }

            // random farbe nachbar
            if (!(spielfeld.get(rngbewohner - 1).getPartei().getName().equals(spielfeld.get(randomNachbar - 1).getPartei().getName()))) {

                if (random.nextBoolean()) {
                    spielfeld.get(randomNachbar - 1).setPartei(spielfeld.get(rngbewohner - 1).getPartei());
                }

            }

            if ((i % reload) == 0) {
                ausgabe();
            }
            interationen++;
        }
        ausgabe();
    }

    /**
     * Creates new form MainFrame
     *
     *
     * Notizen: True = Schwartz = KPCh False = Rot = RKdK
     */
    public MainFrame() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/icon.png")));
        initComponents();

        // Erstellung Des Spielfeld
        spielfeld = new ArrayList<>();
        parteien = new ArrayList<>();

        parteien.add(new Partei("KPCh", Color.BLACK));
        parteien.add(new Partei("RKdK", Color.RED));

        for (int i = 0; i < laenge * hoehe; i++) {
            spielfeld.add(new Bewohner(parteien.get(random.nextInt(parteien.size()))));
            spielPanel.add(spielfeld.get(i));
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

        interation_int = new javax.swing.JSpinner();
        start_Button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        spielPanel = new javax.swing.JPanel();
        interration_txt = new javax.swing.JLabel();
        rkdk_txt = new javax.swing.JLabel();
        kpch_txt = new javax.swing.JLabel();
        rkdk_procent = new java.awt.TextField();
        kpch_procent = new java.awt.TextField();
        interationen_anzahl_txt = new javax.swing.JLabel();
        interration_anzahl_graf = new java.awt.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Demokratur (China Edition)");
        setResizable(false);

        interation_int.setModel(new javax.swing.SpinnerNumberModel(10000, 1, 10000000, 1));
        interation_int.setToolTipText("");
        interation_int.setAutoscrolls(true);
        interation_int.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        interation_int.setName(""); // NOI18N
        interation_int.setValue(10000);

        start_Button.setText("Start");
        start_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                start_ButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        spielPanel.setLayout(new java.awt.GridLayout(hoehe, laenge));
        jScrollPane1.setViewportView(spielPanel);

        interration_txt.setText("Interration");

        rkdk_txt.setForeground(new java.awt.Color(255, 0, 0));
        rkdk_txt.setText("RKdK");

        kpch_txt.setBackground(new java.awt.Color(255, 255, 255));
        kpch_txt.setText("KPCh");

        rkdk_procent.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        rkdk_procent.setEditable(false);
        rkdk_procent.setText("0%");
        rkdk_procent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rkdk_procentActionPerformed(evt);
            }
        });

        kpch_procent.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        kpch_procent.setEditable(false);
        kpch_procent.setText("0%");
        kpch_procent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kpch_procentActionPerformed(evt);
            }
        });

        interationen_anzahl_txt.setText("anzahl:");

        interration_anzahl_graf.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        interration_anzahl_graf.setEditable(false);
        interration_anzahl_graf.setText("0");
        interration_anzahl_graf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interration_anzahl_grafActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(interration_txt)
                        .addGap(55, 55, 55))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(kpch_txt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rkdk_txt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rkdk_procent, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kpch_procent, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(interation_int, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(start_Button))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(interationen_anzahl_txt)
                                .addGap(9, 9, 9)
                                .addComponent(interration_anzahl_graf, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(interration_txt)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(interration_anzahl_graf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(interationen_anzahl_txt)
                        .addGap(3, 3, 3)))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(interation_int, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(start_Button))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(kpch_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kpch_procent, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rkdk_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rkdk_procent, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(346, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void start_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_start_ButtonActionPerformed
        gameloop();
    }//GEN-LAST:event_start_ButtonActionPerformed

    // Ignorieren 

    private void kpch_procentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kpch_procentActionPerformed

    }//GEN-LAST:event_kpch_procentActionPerformed

    private void rkdk_procentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rkdk_procentActionPerformed

    }//GEN-LAST:event_rkdk_procentActionPerformed

    private void interration_anzahl_grafActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interration_anzahl_grafActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_interration_anzahl_grafActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Windows look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner interation_int;
    private javax.swing.JLabel interationen_anzahl_txt;
    private java.awt.TextField interration_anzahl_graf;
    private javax.swing.JLabel interration_txt;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.TextField kpch_procent;
    private javax.swing.JLabel kpch_txt;
    private java.awt.TextField rkdk_procent;
    private javax.swing.JLabel rkdk_txt;
    private javax.swing.JPanel spielPanel;
    private javax.swing.JButton start_Button;
    // End of variables declaration//GEN-END:variables

}
