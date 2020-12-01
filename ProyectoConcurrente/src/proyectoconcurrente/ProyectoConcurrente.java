package proyectoconcurrente;
import java.awt.Color;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.concurrent.CyclicBarrier;
public class ProyectoConcurrente extends javax.swing.JFrame {
    private PanelBall panel;  
    private ArrayList <Ball> Balls;
    private MX []x = new MX[10];
    private MY []y = new MY[10];
    private NumeroBall n;
    private int s = 1, p = 0, sincro; 
    private int []c = new int[4];
    private CyclicBarrier barrera;
    public ProyectoConcurrente() {
        this.setExtendedState(MAXIMIZED_BOTH);
        initComponents();
        ButtonGroup Sincronizacion = new ButtonGroup();
        Sincronizacion.add(ButtonMutex);
        Sincronizacion.add(ButtonSemaforo);
        Sincronizacion.add(ButtonMonitores);
        Sincronizacion.add(ButtonVC);
        Sincronizacion.add(ButtonBarreras);
        try{
            img = ImageIO.read(new File ("mapa3.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
        n = new NumeroBall();
        panel = new PanelBall(img, n);
        Balls = new ArrayList<Ball>();
        panel.setBackground(new Color(135,206,235));
        panel.setBounds(0, 0, 1360, 680);
        add(panel);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Cerrar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        ButtonMutex = new javax.swing.JRadioButtonMenuItem();
        ButtonSemaforo = new javax.swing.JRadioButtonMenuItem();
        ButtonMonitores = new javax.swing.JRadioButtonMenuItem();
        ButtonVC = new javax.swing.JRadioButtonMenuItem();
        ButtonBarreras = new javax.swing.JRadioButtonMenuItem();

        jMenu3.setText("jMenu3");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenu4.setText("File");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar2.add(jMenu5);

        jMenu6.setText("jMenu6");

        jMenu7.setText("jMenu7");

        jMenuItem5.setText("jMenuItem5");

        jMenu8.setText("jMenu8");

        jMenuItem6.setText("jMenuItem6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("File");

        Cerrar.setText("Salir");
        Cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CerrarActionPerformed(evt);
            }
        });
        jMenu1.add(Cerrar);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Drones");

        jMenuItem3.setText("Nuevo");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("Eliminar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jMenu9.setText("Sincronizacion");

        ButtonMutex.setSelected(true);
        ButtonMutex.setText("Mutex");
        jMenu9.add(ButtonMutex);

        ButtonSemaforo.setText("Semaforos");
        jMenu9.add(ButtonSemaforo);

        ButtonMonitores.setText("Monitores");
        ButtonMonitores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonMonitoresActionPerformed(evt);
            }
        });
        jMenu9.add(ButtonMonitores);

        ButtonVC.setText("Variable Condicion");
        jMenu9.add(ButtonVC);

        ButtonBarreras.setText("Barreras");
        jMenu9.add(ButtonBarreras);

        jMenuBar1.add(jMenu9);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try{
            sincro = OpcionSincro();
            BloquearBotones();
            if(s <= 10){
                for(Ball b: Balls){
                    if(b.isAlive()){
                        b.stop();
                    }
                }
                Balls.clear();
                if(p == 2){
                    c[0] = (panel.getHeight()/p) + 10;
                }
                if(p == 3){
                    c[0] = (panel.getHeight()/p) + 10;
                    c[1] = ((panel.getHeight()/p) *2) + 10;
                }
                if(p == 4){
                    c[0] = (panel.getHeight()/p) + 10;
                    c[1] = ((panel.getHeight()/p) *2) + 10;
                    c[2] = ((panel.getHeight()/p) *3) + 10;
                }
                if(p == 5){
                    c[0] = (panel.getHeight()/p) + 10;
                    c[1] = ((panel.getHeight()/p) *2) + 10;
                    c[2] = ((panel.getHeight()/p) *3) + 10;
                    c[3] = ((panel.getHeight()/p) *4) + 10;
                }
                x[0] = new MX(0);
                y[0] = new MY(0);
                x[1] = new MX(panel.getWidth());
                y[1] = new MY(0);
                x[2] = new MX(0);
                y[2] = new MY(c[0]);
                x[3] = new MX(panel.getWidth());
                y[3] = new MY(c[0]);
                x[4] = new MX(0);
                y[4] = new MY(c[1]);
                x[5] = new MX(panel.getWidth());
                y[5] = new MY(c[1]);
                x[6] = new MX(0);
                y[6] = new MY(c[2]);
                x[7] = new MX(panel.getWidth());
                y[7] = new MY(c[2]);
                x[8] = new MX(0);
                y[8] = new MY(c[3]);
                x[9] = new MX(panel.getWidth());
                y[9] = new MY(c[3]);
                barrera = new CyclicBarrier(s);
                panel.DividirPanel(p);
                panel.CreaCirculo(s); 
                for(int i = 0; i < s; i++){
                    Balls.add(new Ball(panel, x[i], y[i], i+1, p)); 
                    Balls.get(i).setAlgoritmo(sincro); 
                    Balls.get(i).setBarrera(barrera); 
                }
                for(int i =0 ; i < s; i++){
                    Balls.get(i).start();
                }
                p++;
                if(s == 1){
                    s++;
                }else{
                    s = s + 2;
                }
            }else{
                JOptionPane.showMessageDialog(null, "Se ha Alcanzado el Limite Maximo de Objetos", "¡ALERTA!", JOptionPane.ERROR_MESSAGE);
            }
        }catch (IllegalThreadStateException e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        if(s == 2){
            s = 0;
            p = 0;
            jMenuItem3.doClick();
        }
        if(s == 4){  
            p = 0;
            s = 1;
            jMenuItem3.doClick();
        }
        if(s > 4){  
            p = p - 2;
            s = s - 4;
            jMenuItem3.doClick();
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed
    public int OpcionSincro(){
        int op = 0;
        if(ButtonMutex.isSelected()){
            op = 0;
        }
        if(ButtonSemaforo.isSelected()){
            op = 1;
        }
        if(ButtonMonitores.isSelected()){
            op = 2;
        }
        if(ButtonVC.isSelected()){
            op = 3;
        }
        if(ButtonBarreras.isSelected()){
            op = 4;
        }
        return op;
    }
    public void BloquearBotones(){
        ButtonMutex.setEnabled(false); 
        ButtonSemaforo.setEnabled(false);
        ButtonMonitores.setEnabled(false);
        ButtonVC.setEnabled(false);
        ButtonBarreras.setEnabled(false);
    }
    private void CerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CerrarActionPerformed
        
    }//GEN-LAST:event_CerrarActionPerformed

    private void ButtonMonitoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonMonitoresActionPerformed
        
    }//GEN-LAST:event_ButtonMonitoresActionPerformed
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
            java.util.logging.Logger.getLogger(ProyectoConcurrente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProyectoConcurrente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProyectoConcurrente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProyectoConcurrente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProyectoConcurrente().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButtonMenuItem ButtonBarreras;
    private javax.swing.JRadioButtonMenuItem ButtonMonitores;
    private javax.swing.JRadioButtonMenuItem ButtonMutex;
    private javax.swing.JRadioButtonMenuItem ButtonSemaforo;
    private javax.swing.JRadioButtonMenuItem ButtonVC;
    private javax.swing.JMenuItem Cerrar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    // End of variables declaration//GEN-END:variables
    private BufferedImage img;
}
