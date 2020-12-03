package proyectoconcurrente;
import java.awt.Color;
import java.awt.geom.Rectangle2D;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import javax.swing.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class Ball  extends Thread{
    private PanelBall panel;
    private MX x;
    private MY y;
    private double[] datosX;
    private double[] datosY;
    private int bx = 5;
    private int by = 3;
    private int secc, div;
    private Lock mutex;    
    private Semaphore semaforo;
    private boolean Ocupado = false;
    private int algoritmo;
    private CyclicBarrier barrera;
    Ball(PanelBall panel, MX x, MY y, int secc, int div){
        this.panel = panel;
        this.secc = secc;
        this.div = div;
        this.x = x;
        this.y = y;
        this.datosX = new double[10000];
        this.datosY = new double[10000];
        this.mutex = new ReentrantLock();
        this.semaforo = new Semaphore(1);
    }
    public void run(){
        int iter = 0;
        while(true){ 
            try{
                switch(getAlgoritmo()){
                    case 0:
                        if(mutex.tryLock()){
                            System.out.println(this.secc + " Mutex");
                            mutex.lock();
                            x.setX(x.getX() + bx); 
                            y.setY(y.getY() + by);
                            Grafica(iter);
                            MovimientoXY();
                            panel.ActuaslizaXYN(x, y, this.secc - 1); 
                            panel.repaint();
                            mutex.unlock();
                        }
                        Thread.sleep(10+(int)Math.random()*20);
                    break;
                    case 1:
                        semaforo.acquire();
                        System.out.println(this.secc + " Semaforos");
                        x.setX(x.getX() + bx); 
                        y.setY(y.getY() + by);
                        Grafica(iter);
                        MovimientoXY();
                        panel.ActuaslizaXYN(x, y, this.secc - 1); 
                        panel.repaint();
                        semaforo.release();
                        Thread.sleep(10+(int)Math.random()*20);
                    break;
                    case 2:
                        System.out.println(this.secc + " Monitores");
                        OperacionXY(iter);
                        Thread.sleep(10+(int)Math.random()*20);
                    break;
                    case 3:
                        mutex.lock();
                        System.out.println(this.secc + " Variables de Condicion");
                        Espera(mutex);
                        x.setX(x.getX() + bx); 
                        y.setY(y.getY() + by);
                        Grafica(iter);
                        MovimientoXY();
                        panel.ActuaslizaXYN(x, y, this.secc - 1); 
                        panel.repaint();
                        Señal(mutex);
                        Thread.sleep(10+(int)Math.random()*20);
                    break;
                    case 4:
                        System.out.println(this.secc + " Barreras");
                        x.setX(x.getX() + bx); 
                        y.setY(y.getY() + by);
                        Grafica(iter);
                        MovimientoXY();
                        panel.ActuaslizaXYN(x, y, this.secc - 1); 
                        barrera.await();
                        panel.repaint();
                        Thread.sleep(10+(int)Math.random()*20);
                    break;
                }
                iter++;
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    public void MovimientoXY(){
        if(this.div == 0 && this.secc == 1){
            LimitesX(0, panel.getWidth() - 20);
            LimitesY(0, panel.getHeight() - 20);
        }else{
            if(this.secc == 1 || this.secc == 3 || this.secc == 5 || this.secc == 7 || this.secc == 9){
                LimitesX(0, (panel.getWidth()/2) - 15);
            }else{
                LimitesX((panel.getWidth()/2) + 15, panel.getWidth());
            }
            if(this.secc == 1 || this.secc == 2){
                LimitesY(0, (panel.getHeight()/this.div) - 20);
            }
            if(this.secc == 3 || this.secc == 4){
                LimitesY((panel.getHeight()/this.div) + 10, ((panel.getHeight()/this.div) * 2) - 20);      
            }
            if(this.secc == 5 || this.secc == 6){
                LimitesY(((panel.getHeight()/this.div) *2) + 10, ((panel.getHeight()/this.div) * 3) - 20);             
            }
            if(this.secc == 7 || this.secc == 8){
                LimitesY(((panel.getHeight()/this.div) *3) + 10, ((panel.getHeight()/this.div) * 4) - 20);            
            }
            if(this.secc == 9 || this.secc == 10){
                LimitesY(((panel.getHeight()/this.div) *4) + 10, panel.getHeight() - 20);             
            }
        }
    }
    public void LimitesX(int lim1, int lim2){
        if(x.getX() > lim2  || x.getX() < lim1){
            bx=-bx;
        }
    }
    public void LimitesY(int lim1, int lim2){
        if(y.getY() > lim2 || y.getY() < lim1){
            by=-by;
        }
    }
    public int getAlgoritmo() {
        return algoritmo;
    }
    public void setAlgoritmo(int algoritmo) {
        this.algoritmo = algoritmo;
    }
    public synchronized void OperacionXY(int iter){
        try{
            while(Ocupado){
                wait();                 
            }
            Ocupado = true;
            x.setX(x.getX() + bx); 
            y.setY(y.getY() + by);
            Grafica(iter);
            MovimientoXY();
            panel.ActuaslizaXYN(x, y, this.secc - 1); 
            panel.repaint();
            Ocupado = false;
            notifyAll();
        }catch(Exception e){}
    }
    public synchronized void Espera(Lock mutex){
        try{
            while(Ocupado){
                wait();
            }
            Ocupado = true;
        }catch(Exception e){}
    }
    public synchronized void Señal(Lock mutex){
        try{
            Ocupado = false;
            mutex.unlock();
            notifyAll();
        }catch(Exception e){}
    }
    public CyclicBarrier getBarrera() {
        return barrera;
    }
    public void Grafica(int iter){
        if(iter < datosX.length){
                datosX[iter] = x.getX();
                datosY[iter] = y.getY();
        }
    }
    public void setBarrera(CyclicBarrier barrera) {
        this.barrera = barrera;
    }
    public double[] getDatosX() {
        return datosX;
    }
    public void setDatosX(double[] datosX) {
        this.datosX = datosX;
    }
    public double[] getDatosY() {
        return datosY;
    }
    public void setDatosY(double[] datosY) {
        this.datosY = datosY;
    }
    
}