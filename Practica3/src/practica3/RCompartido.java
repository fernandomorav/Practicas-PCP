package practica3;
public class RCompartido {
    private String  datoCompartido;
    private boolean interrupciones[] = new boolean[4];
    RCompartido(){
        datoCompartido="";
        for(int i=0;i<interrupciones.length;i++){
            interrupciones[i] = false;
        }
    }
    public boolean[] getInterrupciones() {
        return interrupciones;
    }
    public void setInterrupciones(boolean interrupciones) {
        for(int i=0;i<this.interrupciones.length;i++){
            this.interrupciones[i] = interrupciones;
        }
    }
    public String getDatoCompartido() {
        return datoCompartido;
    }
    public void setDatoCompartido(String datoCompartido) {
        this.datoCompartido = datoCompartido;
    }
    
}
