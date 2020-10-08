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
    public void setRun(boolean run) {
        this.run = run;
    }
    public boolean isRun() {
        return run;
    }
    public void run(){
        try{    
            if(run==true){
                while(run){
                    rc.setDatoCompartido(this.getName());
                    area.append(rc.getDatoCompartido()+"\n");
                    Thread.sleep(1000);
                }
            }else{
                Thread.interrupted();
            }
        }catch(Exception a){
            a.printStackTrace();
        }   
    }
}
