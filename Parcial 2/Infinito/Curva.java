import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Curva extends JPanel {

    private Image imagen;

    private final int PUNTOS = 65;
    
    private int xInicial = 250;
    private int yInicial = 200;

    private int[] puntosX = new int[PUNTOS+1];
    private int[] puntosY = new int[PUNTOS+1];

    public Curva() {
        JFrame frame = new JFrame("Infinito");
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
        int radio = 100;
        double angulo = 0;
        final double PASOS = 0.1;

        for(int i=0; i<=PUNTOS; i++) {
            double x = radio * Math.sin(angulo) / 1 + Math.cos(2) * angulo;
            double y = radio * Math.sin(angulo) * Math.cos(angulo) / 1 + Math.cos(2) * angulo;

            puntosX[i] = (int) Math.round(xInicial + (x*2));
            puntosY[i] = (int) Math.round(yInicial + (y*2));

            angulo += PASOS;
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