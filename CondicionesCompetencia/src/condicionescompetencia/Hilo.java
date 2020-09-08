package condicionescompetencia;
import javax.swing.JTextArea;
public class Hilo extends Thread{
    private JTextArea area;
    private RCompartido rc;
    boolean run=true;
    Hilo(JTextArea area,RCompartido rc){
        this.area=area;
        this.rc=rc;
    }
    public void pausahilo(){
        run=false;
    }
    public void run(){
        try{    
            while(true){
                if(run==true){
                    rc.setDatoCompartido(this.getName());
                    area.append(rc.getDatoCompartido()+"\n");
                    Thread.sleep(1500);
                }
                else{
                    Thread.interrupted();
                }
            }
        }catch(IllegalMonitorStateException e){
            e.printStackTrace();
        }catch(Exception a){
            a.printStackTrace();
        }  
        
    }
}
