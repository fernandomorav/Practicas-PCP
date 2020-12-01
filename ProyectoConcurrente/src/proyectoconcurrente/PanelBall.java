package proyectoconcurrente;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
public class PanelBall extends JPanel{
    private MX []x = new MX[10];
    private MY []y = new MY[10];
    private NumeroBall n;
    private BufferedImage img;
    private ArrayList<Ellipse2D> circulos;
    private ArrayList<Rectangle2D> lineas;
    private int d = 0;
    public PanelBall(BufferedImage img, NumeroBall n){
        this.img = img;
        this.n = n;
        circulos = new ArrayList<Ellipse2D>();
        lineas = new ArrayList<Rectangle2D>();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(img, 0, 0, this.getWidth(),this.getHeight(),null);
        g2.setColor(Color.BLUE);
        int i = 1;
        if(d >= 1){
            g2.fill(new Rectangle2D.Double((this.getWidth()/2) + 5, 0, 10, this.getHeight()));
        }
        for(Rectangle2D l: lineas){
            l.setFrame(0, (this.getHeight()/d+1)*i, this.getWidth(), 10);
            g2.fill((Rectangle2D)l);
            i++;
        }
        i = 0;
        for(Ellipse2D c: circulos){
            try{
                g2.setColor(Color.BLUE);
                c.setFrame(x[i].getX(), y[i].getY(), 20, 20);
                g2.fill((Ellipse2D)c);
                g2.setColor(Color.WHITE);
                this.n.setContador(i+1);
                g2.drawString(String.valueOf(n.getContador()), x[i].getX()+5, y[i].getY()+14); 
                i++;
            }catch(NullPointerException e){}
        }
    } 
    public void CreaCirculo(int numC){
        circulos.clear();
        for(int i = 0; i < numC; i++){
            circulos.add(new Ellipse2D.Double());
        }
    }
    public void DividirPanel(int numP){
        d = numP;
        lineas.clear();
        for(int i = 0; i < numP; i++){
            lineas.add(new Rectangle2D.Double());
        }
    }
    public void ActuaslizaXYN(MX x, MY y, int n){
        this.x[n] = x;
        this.y[n] = y;
    }
}
