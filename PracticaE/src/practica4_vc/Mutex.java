package practica4_vc;
public class Mutex {
    private boolean pase = false;
    Mutex(){
        
    }
    public synchronized void lock(){
        while(this.pase){
            try{
                System.out.println("w");
                wait();
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
        this.pase = false;
    }
    public synchronized void unlock(){
        this.pase = false;
        notifyAll();
    }
    public boolean isPase() {
        return pase;
    }
    public void setPase(boolean pase) {
        this.pase = pase;
    }
    public boolean trylock(){
        if(this.pase){
            try{
                lock();
            }catch(Exception e){}
            finally{
                unlock();
            }
            return false;
        }
        return true;
    }
}
