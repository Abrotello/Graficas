import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Dibujo extends JPanel implements Runnable {
    BufferedImage image = null;
    
    int[] vectorProyeccion = { 0, 0, 50 };
    private int tx = 50, ty = 90, tz = 50;

    private void calcularMovimiento() {

        /*
         *
         * 1. Calcular la proyeccion inicial de cada punto del cubo en 3D a 2D
         * 
         * 2. Calcular la posicion final de cada punto del cubo en 3D
         * 
         * 3. Calcular la proyeccion final de cada punto del cubo en 3D a 2D
         * 
         * 4. Incrementar los valores de la proyeccion inicial de cada punto del cubo hasta llegar al resultado final
         * 
         */

    }

    private void proyectar() {

        Cubo cubo = new Cubo();


    }

    private double calcularUParalela(double z, int zp) {
        return (z / zp) * (-1);
    }

    private double calcularXParalela(double x1, double u, int xp) {
        return x1 + (xp * u);
    }

    private double calcularYParalela(double y1, double u, int zp) {
        return y1 + (zp * u);
    }
 
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        calcularMovimiento();
        g.drawImage(image, 0, 0, this);
    }

    @Override
    public void run() {
        while (true) {
            
            try {
                repaint();
                System.out.println("Tick");
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                e.getStackTrace();
            }


        }
    }
}
