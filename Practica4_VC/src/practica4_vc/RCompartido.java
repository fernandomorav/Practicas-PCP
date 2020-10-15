package practica4_vc;
public class RCompartido {
    private String  datoCompartido;
    private Cerradura cerradura;
    RCompartido(Cerradura c){
        datoCompartido = "";
        cerradura = c;
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
}