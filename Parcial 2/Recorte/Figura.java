import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class Figura extends JPanel implements Runnable {
    
    Coordenadas coordenadas = new Coordenadas();
    Bresenham bresenham;
    
    private Image imagen;

    private int x1,y1, x2,y2, x3,y3, x4,y4;
    
    Color contorno = Color.BLACK;
    Color relleno = Color.YELLOW;

    public Figura() {
        //Punto A
        x1 = coordenadas.getPuntoA()[0];
        y1 = coordenadas.getPuntoA()[1];

        //Punto B
        x2 = coordenadas.getPuntoB()[0];
        y2 = coordenadas.getPuntoB()[1];

        //Punto C
        x3 = coordenadas.getPuntoC()[0];
        y3 = coordenadas.getPuntoC()[1];
        
        //Punto D
        x4 = coordenadas.getPuntoD()[0];
        y4 = coordenadas.getPuntoD()[1];
        
        bresenham = new Bresenham();
    }

    private void cuadrado () {
        imagen = createImage(700, 700);
        bresenham.algoritmo(x1, y1, x2, y2, contorno, imagen);
        bresenham.algoritmo(x1, y1, x3, y3, contorno, imagen);
        bresenham.algoritmo(x2, y2, x4, y4, contorno, imagen);
        bresenham.algoritmo(x3, y3, x4, y4, contorno, imagen);
        relleno();
    }


    private void relleno() {

        int xInterna = x1+1;
        int xInterna1 = x2-1;

        int yInterna = y1+2;
        int yInterna1 = y3-1;

        while(yInterna < yInterna1) {
            bresenham.algoritmo(xInterna, yInterna, xInterna1, yInterna, relleno, imagen);
            yInterna++;
        }
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        cuadrado();
        g.drawImage(imagen, 0, 0, this);
    }

    @Override
    public void run() {
        
        while (true) {

            repaint();
            
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.getStackTrace();
            }
        }
    }
}
