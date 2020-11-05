package practica4_vc;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButtonMenuItem;

public class Practica4_VC extends javax.swing.JFrame {
    public Practica4_VC() {
        initComponents();
        ButtonGroup Algoritmo = new ButtonGroup();
        Algoritmo.add(RadioButtonCC);
        Algoritmo.add(RadioButtonDI);
        Algoritmo.add(RadioButtonVC);
        Algoritmo.add(RadioButtonAE);
        Algoritmo.add(RadioButtonDP);
        Algoritmo.add(RadioButtonM);
        Algoritmo.add(RadioButtonML);
        cd = new Cerradura();
        rc = new RCompartido(cd);
        rc.setTurno(0);
        t1 = new Hilo(jTextArea1, rc);
        t1.setName("Perrito 1");
        
        rc.setTurno(1);
        t2 = new Hilo(jTextArea2, rc);
        t2.setName("Perrito 2");
        
        rc.setTurno(2);
        t3 = new Hilo(jTextArea3, rc);
        t3.setName("Perrito 3");
        
        rc.setTurno(3);
        t4 = new Hilo(jTextArea4, rc);
        t4.setName("Perrito 4");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        RadioButtonCC = new javax.swing.JRadioButtonMenuItem();
        RadioButtonDI = new javax.swing.JRadioButtonMenuItem();
        RadioButtonVC = new javax.swing.JRadioButtonMenuItem();
        RadioButtonAE = new javax.swing.JRadioButtonMenuItem();
        RadioButtonDP = new javax.swing.JRadioButtonMenuItem();
        jMenu2 = new javax.swing.JMenu();
        RadioButtonM = new javax.swing.JRadioButtonMenuItem();
        RadioButtonML = new javax.swing.JRadioButtonMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        jMenuItem4.setText("jMenuItem4");

        jMenu3.setText("jMenu3");

        jMenuItem5.setText("jMenuItem5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane6.setViewportView(jTextArea2);

        jButton1.setText("Correr");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane7.setViewportView(jTextArea3);

        jButton2.setText("Kill - 9");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Terminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane8.setViewportView(jTextArea4);

        jLabel1.setText("Plato 1");

        jLabel2.setText("Plato 2");

        jLabel3.setText("Plato 3");

        jLabel4.setText("Plato 4");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane5.setViewportView(jTextArea1);

        jMenu1.setText("File");

        jMenuItem12.setText("Cerrar");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem12);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Algoritmos");

        RadioButtonCC.setSelected(true);
        RadioButtonCC.setText("Condiciones de Competencia");
        RadioButtonCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonCCActionPerformed(evt);
            }
        });
        jMenu4.add(RadioButtonCC);

        RadioButtonDI.setText("Desactivacion de Interrupciones ");
        RadioButtonDI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonDIActionPerformed(evt);
            }
        });
        jMenu4.add(RadioButtonDI);

        RadioButtonVC.setText("Petterson (VCerradura)");
        RadioButtonVC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonVCActionPerformed(evt);
            }
        });
        jMenu4.add(RadioButtonVC);

        RadioButtonAE.setText("Dekker (Alternancia Estricta)");
        RadioButtonAE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonAEActionPerformed(evt);
            }
        });
        jMenu4.add(RadioButtonAE);

        RadioButtonDP.setText("Dijkstra - Paper");
        RadioButtonDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonDPActionPerformed(evt);
            }
        });
        jMenu4.add(RadioButtonDP);

        jMenu2.setText("Mutex");

        RadioButtonM.setText("Mutex ");
        RadioButtonM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioButtonMActionPerformed(evt);
            }
        });
        jMenu2.add(RadioButtonM);

        RadioButtonML.setText("Mutex con Librerias");
        jMenu2.add(RadioButtonML);

        jMenu4.add(jMenu2);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(jLabel1)
                .addGap(119, 119, 119)
                .addComponent(jLabel2)
                .addGap(113, 113, 113)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(76, 76, 76))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(59, 59, 59)
                .addComponent(jButton1)
                .addGap(33, 33, 33)
                .addComponent(jButton2)
                .addGap(30, 30, 30)
                .addComponent(jButton3)
                .addContainerGap(206, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                            .addComponent(jScrollPane8)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(RadioButtonCC.isSelected()){
            t1.setAlgoritmo(0);
            t2.setAlgoritmo(0);
            t3.setAlgoritmo(0);
            t4.setAlgoritmo(0);
        }
        if(RadioButtonDI.isSelected()){
            t1.setAlgoritmo(1);
            t2.setAlgoritmo(1);
            t3.setAlgoritmo(1);
            t4.setAlgoritmo(1);
        }
        if(RadioButtonVC.isSelected()){
            t1.setAlgoritmo(2);
            t2.setAlgoritmo(2);
            t3.setAlgoritmo(2);
            t4.setAlgoritmo(2);
        }
        if(RadioButtonAE.isSelected()){
            rc.setTurno(0);
            t1.setAlgoritmo(3);
            t2.setAlgoritmo(3);
            t3.setAlgoritmo(3);
            t4.setAlgoritmo(3);
        }
        if(RadioButtonDP.isSelected()){
            rc.setTurno(0);
            t1.setAlgoritmo(4);
            t2.setAlgoritmo(4);
            t3.setAlgoritmo(4);
            t4.setAlgoritmo(4);
        }
        if(RadioButtonM.isSelected()){
            t1.setAlgoritmo(5);
            t2.setAlgoritmo(5);
            t3.setAlgoritmo(5);
            t4.setAlgoritmo(5);
        }
        if(RadioButtonML.isSelected()){
            t1.setAlgoritmo(6);
            t2.setAlgoritmo(6);
            t3.setAlgoritmo(6);
            t4.setAlgoritmo(6);
        }
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int k = (int) (Math.random()*4);
        System.out.println(k);
        try{ 
            switch(k){
                case 0:
                    t1.setDead(true);
                break;
                case 1:
                    t2.setDead(true);
                break;
                case 2:
                    t3.setDead(true);
                break;  
                case 3:
                    t4.setDead(true);
                break;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void RadioButtonMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonMActionPerformed

    }//GEN-LAST:event_RadioButtonMActionPerformed

    private void RadioButtonAEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonAEActionPerformed

    }//GEN-LAST:event_RadioButtonAEActionPerformed

    private void RadioButtonCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonCCActionPerformed

    }//GEN-LAST:event_RadioButtonCCActionPerformed

    private void RadioButtonDIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonDIActionPerformed

    }//GEN-LAST:event_RadioButtonDIActionPerformed

    private void RadioButtonDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonDPActionPerformed

    }//GEN-LAST:event_RadioButtonDPActionPerformed

    private void RadioButtonVCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioButtonVCActionPerformed

    }//GEN-LAST:event_RadioButtonVCActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(!t1.isDead()){
            t1.stop();
        }
        if(!t2.isDead()){
            t2.stop();
        }
        if(!t3.isDead()){
            t3.stop();
        }
        if(!t4.isDead()){
            t4.stop();
        }
        jTextArea1.setText("");
        jTextArea2.setText("");
        jTextArea3.setText("");
        jTextArea4.setText("");
        cd = new Cerradura();
        rc = new RCompartido(cd);
        rc.setTurno(0);
        
        t1 = new Hilo(jTextArea1, rc);
        t1.setName("Perrito 1");
        
        rc.setTurno(1);
        t2 = new Hilo(jTextArea2, rc);
        t2.setName("Perrito 2");
        
        rc.setTurno(2);
        t3 = new Hilo(jTextArea3, rc);
        t3.setName("Perrito 3");
        
        rc.setTurno(3);
        t4 = new Hilo(jTextArea4, rc);
        t4.setName("Perrito 4");
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Practica4_VC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Practica4_VC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Practica4_VC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Practica4_VC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Practica4_VC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButtonMenuItem RadioButtonAE;
    private javax.swing.JRadioButtonMenuItem RadioButtonCC;
    private javax.swing.JRadioButtonMenuItem RadioButtonDI;
    private javax.swing.JRadioButtonMenuItem RadioButtonDP;
    private javax.swing.JRadioButtonMenuItem RadioButtonM;
    private javax.swing.JRadioButtonMenuItem RadioButtonML;
    private javax.swing.JRadioButtonMenuItem RadioButtonVC;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    // End of variables declaration//GEN-END:variables
    private Hilo t1,t2, t3, t4;
    private RCompartido rc;
    private Cerradura cd;
    private boolean ejecutar = false;
}
