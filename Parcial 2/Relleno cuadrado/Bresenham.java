import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;


public class Bresenham extends JPanel implements Runnable{
    private Thread hilo;

    private int x1, x2, y1, y2;

    private int x, y, dx, dy, dx2, dy2,  incX, incY, d = 0; 

    private ArrayList<Integer> puntosX1;
    private ArrayList<Integer> puntosY1;

    private ArrayList<Integer> puntosX2;
    private ArrayList<Integer> puntosY2;


    private BufferedImage buffer;
    Graphics gBuffer;

    public Bresenham(int x1_, int y1_, int x2_, int y2_) {
        hilo = new Thread(this);
        hilo.start();
        
        this.x1 = x1_;
        this.y1 = y1_;
        this.x2 = x2_;
        this.y2 = y2_;

        puntosX1 = new ArrayList<>();
        puntosX2 = new ArrayList<>();

        puntosY1 = new ArrayList<>();
        puntosY2 = new ArrayList<>();
        
        setBackground(Color.WHITE);
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        gBuffer = buffer.createGraphics();
        gBuffer.setColor(Color.BLUE);
        relleno(x1, y1, x2);
    }

    private void relleno(int x1_, int y1_, int x2_) {
        int yMAX = this.y2;
        int i = y1_;
        
        while (i < yMAX) {
            algoritmo(x1_, i, x2_, i);
            i++;
        }
    }

    public void floodFill(int x, int y, int rgb, BufferedImage bufferedImage, Color nuevo) {
        
        if(bufferedImage.getRGB(x, y) == rgb) {
            
            bufferedImage.setRGB(x, y, nuevo.getRGB());

            floodFill(x + 1, y, rgb, bufferedImage, nuevo);
            floodFill(x - 1, y, rgb, bufferedImage, nuevo);
            floodFill(x, y + 1, rgb, bufferedImage, nuevo);
            floodFill(x, y - 1, rgb, bufferedImage, nuevo);
        }
    }

    private void algoritmo(int x1_, int y1_, int x2_, int y2_) {

        dx = Math.abs(x2_-x1_);
        dy = Math.abs(y2_-y1_);

        dx2 = 2*dx;
        dy2 = 2*dy;

        incX = x1_ < x2_ ? 1 : -1;    //Si x1<x2 entonces incX valdra 1, si x1>x2 incX valdra -1
        incY = y1_ < y2_ ? 1 : -1;    //Si y1<y2 entonces incY valdra 1, si y1>y2 incY valdra -1

        x = x1_;
        y = y1_;

        if(dx >= dy) {
            while(true) {
                if(x == x2_)
                    break;
                x += incX;
                d += dy2;
                if(d > dx) {
                    y += incY;
                    d -= dx2;
                }
                puntosX1.add(x);
                puntosY1.add(y);
            }
        } else {
            while(true) {
                if(y == y2_)
                    break;
                y += incY;
                d += dx2;
                if(d > dy) {
                    x += incX;
                    d -= dy2;
                }
                puntosX2.add(x);
                puntosY2.add(y);
            }
        }
    }

    public void putPixel(int x, int y, Color c, Graphics g) {
        buffer.setRGB(0, 0, c.getRGB());
        gBuffer.drawImage(buffer, 0, 0, this);
        g.drawImage(buffer, x, y, this);
    }

    @Override
    public void paint(Graphics g) {
        
        int indice = 0;

        while (y1 < y2) {
            if(dx >= dy) {
                for(int i=this.x1; i<this.x2; i++) {
                    putPixel(puntosX1.get(indice), puntosY1.get(indice), gBuffer.getColor(), g);
                    indice++;
                }
            } else {
                for(int i=this.y1; i<this.y2; i++) {
                    putPixel(puntosX2.get(indice), puntosY2.get(indice), gBuffer.getColor(),  g);
                    indice++;
                }
            }
            y1++;
        }
    }

    @Override
    public void run() {

        while (true) {

            try {
                
                repaint();
                Thread.sleep(1000);
                System.out.println("repaint");

            } catch (InterruptedException e) {
                e.getStackTrace();
            }

        }

    }
}