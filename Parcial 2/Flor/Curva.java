import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Curva extends JPanel {

    private Image imagen;

    private double rangoInicial = 0;
    private double rangoFinal = Math.PI*2;
    

    private final int PUNTOS = 600;
    private final double PASOS = (rangoInicial - rangoFinal) / PUNTOS;
    
    private int xInicial = 250;
    private int yInicial = 200;

    private int[] puntosX = new int[PUNTOS+1];
    private int[] puntosY = new int[PUNTOS+1];

    public Curva() {
        JFrame frame = new JFrame("Flor");
        frame.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void calcularCurva() {
        Bresenham bresenham = new Bresenham();
        imagen = createImage(500, 500);
        double ANGULO = 0;

        for(int i=0; i<=PUNTOS; i++) {
            double x = Math.cos(ANGULO) + 0.5 * Math.cos(7 * ANGULO) + 0.3 * Math.sin(17 * ANGULO);
            double y = Math.sin(ANGULO) + 0.5 * Math.sin(7 * ANGULO) + 0.3 * Math.cos(17 * ANGULO);

            puntosX[i] = (int) (xInicial + (x*100));
            puntosY[i] = (int) (yInicial + (y*100));

            ANGULO += PASOS;

            System.out.println(puntosX[i] + ", " + puntosY[i]);
        }

        int j=0;
        while(j < PUNTOS) {
            bresenham.algoritmo(puntosX[j], puntosY[j], puntosX[j+1], puntosY[j+1], Color.BLACK, imagen);
            j++;
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        calcularCurva();
        g.drawImage(imagen, 0, 0, this);
    }
}