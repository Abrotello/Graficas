import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JPanel {
    
    private BufferedImage imagen;
    private int[] vectorProyeccion = { 0, 3, 30 };

    
    private double rangoInicial = 0;
    private double rangoFinal = 8 * (Math.PI);

    private final int PUNTOS = 100;
    private double PASOS = (rangoFinal - rangoInicial) / PUNTOS;
    private double t = 0;

    private int xcentro = 250;
    private int ycentro = 250;

    private double[] xResorte = new double[PUNTOS+1];
    private double[] yResorte = new double[PUNTOS+1];
    private double[] zResorte = new double[PUNTOS+1];

    public Ventana() {
        JFrame frame = new JFrame("Resorte");
        frame.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void proyectarResorte() {
        imagen = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
        BufferedImage buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);

        Figuras figuras = new Figuras(buffer);

        int[] puntosX = new int[PUNTOS+1];
        int[] puntosY = new int[PUNTOS+1];

        for(int i=0; i<=PUNTOS; i++) {
            xResorte[i] = Math.cos(t);
            yResorte[i] = Math.sin(t);
            zResorte[i] = t;

            double u = calcularU(zResorte[i]);
            double x = calcularX(xResorte[i], u);
            double y = calcularY(yResorte[i], u);

            puntosX[i] = (int) (xcentro + (x*150));
            puntosY[i] = (int) (ycentro + (y*50));

            t+=PASOS; 
        }

        int j = 0;
        while(j < PUNTOS) {
            figuras.bresenham(puntosX[j], puntosY[j], puntosX[j+1], puntosY[j+1], Color.WHITE, imagen);
            j++;
        }
    }
    


    private double calcularU(double z) {
        return (z / vectorProyeccion[2]) * (-1);
    }

    private double calcularX(double x1, double u) {
        return x1 + (vectorProyeccion[0] * u);
    }

    private double calcularY(double y1, double u) {
        return y1 + (vectorProyeccion[1] * u);
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        proyectarResorte();
        g.drawImage(imagen, 0, 0, this);
    }
}
