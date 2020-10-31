package practica3;
import javax.swing.JTextArea;
public class Hilo extends Thread{
    private JTextArea area;
    private RCompartido rc;
    private boolean run = true;
    Hilo(JTextArea area,RCompartido rc){
        this.area=area;
        this.rc=rc;
    }
    public boolean isRun() {
        return run;
    }
    public void setRun(boolean run) {
        this.run = run;
    }
    public void run(){
         while(run){
            try{
                if(!Ocupada()){
                    rc.setInterrupciones(true);
                    rc.setDatoCompartido(this.getName());
                    area.append(rc.getDatoCompartido()+"\n");
                    rc.setInterrupciones(false);
                }
                Thread.sleep((int)(Math.random()*400));
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }    
    }
    public boolean Ocupada(){
        boolean f = true;
        boolean interrup[] = rc.getInterrupciones();
        for(int i=0;i<interrup.length;i++){
            if(interrup[i] == false){
                f = false;
            }else{
                return true;
            }
        }
        return f; 
    } 
}