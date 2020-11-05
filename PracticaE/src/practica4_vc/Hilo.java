package practica4_vc;
import javax.swing.JTextArea;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class Hilo extends Thread {
    private JTextArea area;
    private RCompartido rc;
    private final static int ini = 195;
    private final static int fin = 200;
    private boolean dead = false;
    private Lock m;
    private Mutex mutex;
    private int algoritmo = 0;
    private boolean P[] = {false, false};
    private boolean P2[] = {false, false};
    private boolean P3[] = {false, false};
    private boolean B[] = {true, true, true, true};
    private boolean C[] = {true, true, true, true};
    private int turno;
    Hilo(JTextArea area, RCompartido rc){
        this.area = area;
        this.rc = rc;
        m = new ReentrantLock();
        mutex = new Mutex();
        turno = rc.getTurno();
    }
    public void run(){
        switch(getAlgoritmo()){
            case 0:
                System.out.println("Condiciones Competencias");
                while(true){
                    try{
                        rc.setDatoCompartido(this.getName());
                        area.append(rc.getDatoCompartido() + "\n");
                        if(isDead()){
                            stop();
                        }
                        //Thread.sleep((int)(ini + Math.random() * fin));
                        Thread.sleep(500);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                
                }
            case 1:
                System.out.println("Desactivacion de Interrupciones");
                while(true){
                    try{
                        if(!Ocupada()){
                            rc.setInterrupciones(true);
                            rc.setDatoCompartido(this.getName());
                            area.append(rc.getDatoCompartido()+"\n");
                            if(isDead()){
                                stop(); 
                            }
                            rc.setInterrupciones(false);
                        }else{ 
                            area.append("Esperando...\n");
                        }
                        Thread.sleep((int)(ini + Math.random() * fin));
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
                /*while(true){
                    try{
                        if(rc.isEntra()){
                            rc.bloquea();
                            rc.setDatoCompartido(this.getName());
                            area.append(rc.getDatoCompartido() + "\n");
                            if(isDead()){
                                stop();
                            }
                            rc.desbloquea();
                        }else{
                            area.append("Esperando...\n");
                        }
                        Thread.sleep((int)(ini + Math.random() * fin));
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }*/
            case 2:
                System.out.println("Petterson (Variable Cerradura)");
                while(true){
                    try{
                        if(!rc.isCerradura()){
                            rc.setCerradura(true);
                            rc.setDatoCompartido(this.getName());
                            area.append(rc.getDatoCompartido() + "\n");
                            if(isDead()){
                                stop();
                            }
                            rc.setCerradura(false);
                        }else{
                            area.append("Esperando...\n");
                        }
                        Thread.sleep((int)(ini + Math.random() * fin));
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            case 3:
                System.out.println("Dekker (Alternancia Estricta)");
                //System.out.println(getName() +": " + turno);
                int t = 0;
                boolean p1, p2, p3, p4;
                while(true){
                    try{
                        p1 = false;
                        p2 = false;
                        p3 = false;
                        p4 = false;
                        if(rc.getTurno() == 0 || rc.getTurno() == 1){
                            P[0] = true;
                        }
                        if(rc.getTurno() == 2 || rc.getTurno() == 3){
                            P[1] = true;
                        }
                        if(rc.getTurno() == 0 || rc.getTurno() == 1){
                            while(P[1]){
                                if(rc.getTurno() == 2 || rc.getTurno() == 3){
                                    P[0] = false;
                                    while(rc.getTurno() == 2 || rc.getTurno() == 3){}
                                    P[0] = true;
                                }
                            }
                            //System.out.println(rc.getTurno() + "0" + "Seccion Critica\n\n");
                            while(!p1 && !p2){
                                if(rc.getTurno() == 0){
                                    P2[0] = true;
                                }
                                if(rc.getTurno() == 1){
                                    P2[1] = true;
                                }
                                if(rc.getTurno() == 0 && !p1){
                                    while(P2[1]){
                                        if(rc.getTurno() != 0){
                                            P2[0] = false;
                                            while(rc.getTurno() != 0){}
                                            P2[0] = true;
                                        }
                                    }
                                    rc.setDatoCompartido(this.getName());
                                    area.append(rc.getDatoCompartido() + "\n");
                                    if(isDead()){
                                        stop();
                                    }
                                    p1 = true;
                                    //System.out.println(getName());
                                }else{
                                    if(rc.getTurno() == 1 && !p2){
                                        while(P2[0]){
                                            if(rc.getTurno() != 1){
                                                P2[1] = false;
                                                while(rc.getTurno() != 1){}
                                                P2[1] = true;
                                            }
                                        }
                                        rc.setDatoCompartido(this.getName());
                                        area.append(rc.getDatoCompartido() + "\n");
                                        if(isDead()){
                                            stop();
                                        }
                                        p2 = true;
                                        //System.out.println(getName());
                                    }
                                }
                                if(rc.getTurno() == 0){
                                    P2[0] = false;
                                    rc.setTurno(1);
                                }
                                if(rc.getTurno() == 1){
                                    P2[1] = false;
                                    rc.setTurno(2);
                                }
                            }
                        }else{
                            if(rc.getTurno() == 2 || rc.getTurno() == 3){
                                while(P[0]){
                                    if(rc.getTurno() == 0 || rc.getTurno() == 1){
                                        P[1] = false;
                                        while(rc.getTurno() == 0 || rc.getTurno() == 1){}
                                        P[1] = true;
                                    }
                                }
                                //System.out.println(rc.getTurno() + "2" + "Seccion Critica\n\n");
                                while(!p3 && !p4){
                                    if(rc.getTurno() == 2){
                                        P3[0] = true;
                                    }
                                    if(rc.getTurno() == 3){
                                        P3[1] = true;
                                    }
                                    if(rc.getTurno() == 2 && !p3){
                                        while(P3[1]){
                                            if(rc.getTurno() != 2){
                                                P3[0] = false;
                                                while(rc.getTurno() != 2){}
                                                P3[0] = true;
                                            }
                                        }
                                        rc.setDatoCompartido(this.getName());
                                        area.append(rc.getDatoCompartido() + "\n");
                                        if(isDead()){
                                            stop();
                                        }
                                        p3 = true;
                                        //System.out.println(getName());
                                    }else{
                                        if(rc.getTurno() == 3 && !p4){
                                            while(P3[0]){
                                                if(rc.getTurno() != 3){
                                                    P3[1] = false;
                                                    while(rc.getTurno() != 3){}
                                                    P3[1] = true;
                                                }
                                            }
                                            rc.setDatoCompartido(this.getName());
                                            area.append(rc.getDatoCompartido() + "\n");
                                            if(isDead()){
                                                stop();
                                            }
                                            p4 = true;
                                            //System.out.println(getName());
                                        }
                                    }    
                                    if(rc.getTurno() == 2){
                                        P3[0] = false;
                                        rc.setTurno(3);
                                    }
                                    if(rc.getTurno() == 3){
                                        P3[1] = false;
                                        rc.setTurno(0);
                                    }
                                }
                            }
                        }
                        if(rc.getTurno() == 1 || rc.getTurno() == 2){
                            P[0] = false;
                        }else{
                            P[1] = false;
                        }
                        Thread.sleep((int)(ini + Math.random() * fin));
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            case 4:
                System.out.println("Dijkstra - Paper");
                while(true){
                    try{
                        //System.out.println(this.turno +" "+ rc.getTurno());
                        B[this.turno] = false;
                        if(rc.getTurno() != this.turno){
                            while(rc.getTurno() != this.turno){
                                C[this.turno] = true;
                                if(B[rc.getTurno()]){
                                    rc.setTurno(this.turno);
                                }
                            }
                        }else{
                            /*C[this.turno] = false;
                            for(int j=0;j<C.length;j++){
                                if(j != this.turno && !C[j]){
                                    break;
                                }
                            }
                            System.out.println(this.turno);
                            C[this.turno] = true;
                            B[this.turno] = true;*/
                        }                        
                        Thread.sleep((int)(ini + Math.random() * fin));
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }    
                }
            case 5:
                System.out.println("Mutex");
                while(true){
                    try{
                        mutex.lock();
                        rc.setDatoCompartido(this.getName());
                        area.append(rc.getDatoCompartido() + "\n");
                        if(isDead()){
                            stop();
                        }
                        mutex.unlock();
                        Thread.sleep((int)(ini + Math.random() * fin));
                    }catch(InterruptedException e){
                        System.out.println("m" + e.getMessage());
                    }
                    catch(IllegalMonitorStateException a){
                        System.out.println("i" + a.getMessage());
                    }
                }
            case 6:
                System.out.println("Mutex con Librerias");
                while(true){
                    try{
                        if(m.tryLock()){
                            m.lock();
                            rc.setDatoCompartido(this.getName());
                            area.append(rc.getDatoCompartido() + "\n");
                            if(isDead()){
                                stop();
                            }
                            m.unlock();
                            Thread.sleep((int)(ini + Math.random() * fin));
                        }
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                }
        }
    }
    public boolean isDead() {
        return dead;
    }
    public void setDead(boolean dead) {
        this.dead = dead;
    }
    public int getAlgoritmo() {
        return algoritmo;
    }
    public void setAlgoritmo(int algoritmo) {
        this.algoritmo = algoritmo;
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