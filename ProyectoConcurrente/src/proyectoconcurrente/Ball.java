package proyectoconcurrente;
import javax.swing.*;
public class Ball  extends Thread{
    private PanelBall panel;
    private MX x;
    private MY y;
    int bx=10;
    int by=7;
    Ball(PanelBall panel, MX x, MY y){
        this.panel=panel;
        this.x=x;
        this.y=y;
    }
    public void run(){
        while(true){
            try{
                x.setX(x.getX()+bx); 
                y.setY(y.getY()+by); 
                if(x.getX()>panel.getWidth()-20 || x.getX()<0){
                    bx=-bx;
                }
                if(y.getY()>panel.getHeight()-20 || y.getY()<0){
                    by=-by;
                }
                panel.repaint();
                Thread.sleep(50);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
