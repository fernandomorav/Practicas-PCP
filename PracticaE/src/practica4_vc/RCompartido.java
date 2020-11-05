package practica4_vc;
import java.util.ArrayList;
public class RCompartido {
    private String  datoCompartido;
    private Cerradura cerradura;
    private boolean interrupciones[] = new boolean[4];
    private boolean H[] = {false, false, false, false};
    private int turno;
    RCompartido(Cerradura c){
        datoCompartido = "";
        cerradura = c;
        for(int i=0;i<interrupciones.length;i++){
            interrupciones[i] = false;
        }
        turno = 0;
    }
    public String getDatoCompartido() {
        return datoCompartido;
    }
    public void setDatoCompartido(String datoCompartido) {
        this.datoCompartido = datoCompartido;
    }
    public boolean isCerradura() {
        return cerradura.getCerradura();
    }
    public void setCerradura(boolean C) {
        this.cerradura.setCerradura(C);
    }
    public boolean[] getInterrupciones() {
        return interrupciones;
    }
    public void setInterrupciones(boolean interrupciones) {
        for(int i=0;i<this.interrupciones.length;i++){
            this.interrupciones[i] = interrupciones;
        }
    }
    public int getTurno() {
        return turno;
    }
    public void setTurno(int turno) {
        this.turno = turno;
    }
}