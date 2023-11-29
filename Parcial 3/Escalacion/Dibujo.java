import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Dibujo extends JPanel implements Runnable {
    BufferedImage image = null;

    int[] vectorProyeccion = { 8, 7, 20 };
    private float tx, ty, tz;

    //Puntos finales
    int[][] puntosFinales = new int[8][0];

    ArrayList<Puntos> puntosXY = new ArrayList<Puntos>();
    int xInicial, yInicial, xFinal, yFinal;
    BufferedImage bufferedImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
    Graficos2D graficos2d = new Graficos2D(bufferedImage);
    
    
    
    private void dibujarCubo() {
        Cubo cubo = new Cubo();
        Transformacion3D transformacion3d = new Transformacion3D(tx, ty, tz);
    
        for(int i=0; i<puntosFinales.length; i++) {
            puntosFinales[i] = transformacion3d.escalar(cubo.getPuntosX()[i], cubo.getPuntosY()[i], cubo.getPuntosZ()[i]);
            double u = calcularUParalela(puntosFinales[i][2], vectorProyeccion[2]);
            double x = calcularXParalela(puntosFinales[i][0], u, vectorProyeccion[0]);
            double y = calcularYParalela(puntosFinales[i][1], u, vectorProyeccion[1]);

            puntosXY.add(new Puntos((int) x, (int) y));
        }
        proyectar();
    } 

    private void proyectar() {
        
        int[][] cara = {
            { puntosXY.get(0).x, puntosXY.get(0).y },
            { puntosXY.get(1).x, puntosXY.get(1).y },
            { puntosXY.get(5).x, puntosXY.get(5).y },
            { puntosXY.get(4).x, puntosXY.get(4).y }
        };
       
        graficos2d.fillPolygon(cara, Color.BLUE, image);

        int[][] cara2 = {
            { puntosXY.get(0).x, puntosXY.get(0).y },
            { puntosXY.get(4).x, puntosXY.get(4).y },
            { puntosXY.get(6).x, puntosXY.get(6).y },
            { puntosXY.get(2).x, puntosXY.get(2).y }
        };

        graficos2d.fillPolygon(cara2, Color.GREEN, image);

        int[][] cara3 = {
            { puntosXY.get(4).x, puntosXY.get(4).y },
            { puntosXY.get(5).x, puntosXY.get(5).y },
            { puntosXY.get(7).x, puntosXY.get(7).y },
            { puntosXY.get(6).x, puntosXY.get(6).y }
        };

        graficos2d.fillPolygon(cara3, Color.WHITE, image);
        puntosXY.clear();
    }


    private double calcularUParalela(double z, int zp) {
        return (z / zp);
    }

    private double calcularXParalela(double x1, double u, int xp) {
        return x1 + (xp * u);
    }

    private double calcularYParalela(double y1, double u, int zp) {
        return y1 + (zp * u);
    }
 
    @Override
    public void paint(Graphics g) {
        image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        super.paint(g);
        dibujarCubo();
        g.drawImage(image, 0, 0, this);
    }

    @Override
    public void run() {
        while (tx<1.5) {
            
            try {
                tx+=0.001;
                ty+=0.001;
                tz=1;
                repaint();
                Thread.sleep(5); 
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
        }
    }
}
