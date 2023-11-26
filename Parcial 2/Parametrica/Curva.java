import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Curva extends JPanel {

    private Image imagen;

    private final int PUNTOS = 500;
    
    private int yInicial = 100;

    private int[] puntosX = new int[PUNTOS+1];
    private int[] puntosY = new int[PUNTOS+1];

    public Curva() {
        JFrame frame = new JFrame("Parametrica");
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
        final double PASOS = 0.1;

        for(int i=0; i<=PUNTOS; i++) {
            double x = ANGULO - (3 * Math.sin(ANGULO)) * -1;
            double y =  4 - (3 * Math.cos(ANGULO));

            puntosX[i] = (int) ((x*10));
            puntosY[i] = (int) (yInicial + (y*20));

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