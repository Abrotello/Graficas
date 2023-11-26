import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;


public class principal extends JFrame{

    private int x1 = 100, x2 = 400, y1 = 150, y2 = 150;

    private int x, y, dx, dy, dx2, dy2,  incX, incY, d, indice = 0;

    private ArrayList<Integer> puntosX1;
    private ArrayList<Integer> puntosY1;

    private ArrayList<Integer> puntosX2;
    private ArrayList<Integer> puntosY2;


    private BufferedImage buffer;

    public principal() {

        this.setTitle("Relleno 1");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

        puntosX1 = new ArrayList<>();
        puntosX2 = new ArrayList<>();

        puntosY1 = new ArrayList<>();
        puntosY2 = new ArrayList<>();

           
        relleno(x1, y1, x2);
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
    }

    private void relleno(int x1_, int y1_, int x2_) {
        int yMAX = 350;
        int i = y1_;
        
        while (i < yMAX) {
            algoritmo(x1_, i, x2_, i);
            i++;
        }
    }


    private void algoritmo(int x1_, int y1_, int x2_, int y2_) {
        d = 0;

        dx = Math.abs(x2_-x1_);
        dy = Math.abs(y2_-y1_);

        dx2 = 2*dx;
        dy2 = 2*dy;

        incX = x1 < x2 ? 1 : -1;    //Si x1<x2 entonces incX valdra 1, si x1>x2 incX valdra -1
        incY = y1 < y2 ? 1 : -1;    //Si y1<y2 entonces incY valdra 1, si y1>y2 incY valdra -1

        x = x1_;
        y = y1_;

        if(dx >= dy) {
            while(true) {
                if(x == x2)
                    break;
                x += incX;
                d += dy2;
                if(d > dx) {
                    y += incY;
                    d -= dx2;
                }
                puntosX1.add(x);
                puntosY1.add(y);
                indice++;
            }
        } else {
            while(true) {
                if(y == y2)
                    break;
                y += incY;
                d += dx2;
                if(d > dy) {
                    x += incX;
                    d -= dy2;
                }
                puntosX2.add(x);
                puntosY2.add(y);
                indice++;
            }
        }
    }

    public void putPixel(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        indice = 0;
        Color color = Color.BLACK;

        while (y1 < 350) {
            if(dx >= dy) {
                for(int i=this.x1; i<this.x2; i++) {
                    putPixel(puntosX1.get(indice), puntosY1.get(indice), color);
                    indice++;
                }
            } else {
                for(int i=this.y1; i<this.y2; i++) {
                    putPixel(puntosX2.get(indice), puntosY2.get(indice), color);
                    indice++;
                }
            }
            y1++;
        }
    }

    public static void main(String[] args) {
        new principal();
    }
}