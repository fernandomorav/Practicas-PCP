package practica1_20084_competencias;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Practica1_20084_Competencias extends JFrame{
    private JButton bRun,bPausa,bDetener;
    private JLabel etiHilo1,etiHilo2;
    private JTextArea areaHilo1, areaHilo2;
    private JScrollPane jaHilo1,jaHilo2;
    
    public Practica1_20084_Competencias(){
       setSize(400,400);
       setTitle("Condiciones de Competencias");
       MisComponentes();
    }
    private void MisComponentes(){
        bRun =new JButton("Run");
        bPausa =new JButton("Pausa");
        bDetener =new JButton("Detener");
        etiHilo1 =new JLabel("Hilo 1");
        etiHilo2 =new JLabel("Hilo 2");
        areaHilo1 =new JTextArea();
        areaHilo2 =new JTextArea();
        jaHilo1 =new JScrollPane(areaHilo1);
        jaHilo2 =new JScrollPane(areaHilo2);
        
        setLayout(null);
        bRun.setBounds(10, 100, 100, 25);
        bPausa.setBounds(10, 150, 100, 25);
        bDetener.setBounds(10, 200, 100, 25);
        
        etiHilo1.setBounds(150,10,100 ,25);
        etiHilo2.setBounds(250,10,100 ,25);
        
        jaHilo1.setBounds(150,50, 100, 250);
        jaHilo2.setBounds(250,50, 100, 250);
        
        add(bRun);
        add(bPausa);
        add(bDetener);
        add(etiHilo1);
        add(etiHilo2);
        add(jaHilo1);
        add(jaHilo2);
        Hilo1 t1= new Hilo1(areaHilo1);
        Hilo2 t2= new Hilo2(areaHilo2);
        bRun.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                    t1.start();
                    t2.start();
            }       
        });
        bPausa.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                    t1.pausa();
                    t2.pausa();
            }       
        });
    }
    
    public static void main(String[] args) {
        Practica1_20084_Competencias fr=new Practica1_20084_Competencias();
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
}
