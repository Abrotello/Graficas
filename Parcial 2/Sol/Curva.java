import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Curva extends JPanel {

    private Image imagen;

    private double rangoInicial = 0;
    private double rangoFinal = Math.PI*14;
    

    private final int PUNTOS = 600;
    private final double PASOS = (rangoInicial - rangoFinal) / PUNTOS;
    
    private int xInicial = 240;
    private int yInicial = 220;

    private int[] puntosX = new int[PUNTOS+1];
    private int[] puntosY = new int[PUNTOS+1];

    public Curva() {
        JFrame frame = new JFrame("Sol");
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
            double x = (17 * Math.cos(ANGULO)) + 7 * Math.cos(2.428571 * ANGULO);
            double y = (17 * Math.sin(ANGULO)) - 7 * Math.sin(2.428571 * ANGULO);

            puntosX[i] = (int) (xInicial + (x*8));
            puntosY[i] = (int) (yInicial + (y*8));

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