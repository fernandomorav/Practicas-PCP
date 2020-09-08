package practica1_20084_competencias;
import javax.swing.JTextArea;
public class Hilo1 extends Thread{
    private JTextArea area;
    int f=0;
    public Hilo1(JTextArea area){
        this.area=area;
    }
    public void pausa(){
        f=1;
    }
    public void run(){
        int i=0;
        try{
            while(true){
                if(f==0){
                    area.append(i+"\n");
                    i++;
                    Thread.sleep(1000);
                }else{
                    Thread.interrupted();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
