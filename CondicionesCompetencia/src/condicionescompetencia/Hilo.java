package condicionescompetencia;
import javax.swing.JTextArea;
public class Hilo extends Thread{
    private JTextArea area;
    private RCompartido rc;
    Hilo(JTextArea area,RCompartido rc){
        this.area=area;
        this.rc=rc;
    }
    public void run(){
        try{              
            while(true){
                rc.setDatoCompartido(this.getName());
                area.append(rc.getDatoCompartido()+"\n");
                Thread.sleep(1000);
            }
        }catch(Exception a){
            a.printStackTrace();
        }   
    }
}
