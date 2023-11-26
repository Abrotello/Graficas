import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Curva extends JPanel {

    private Image imagen;

    private double rangoInicial = 0;
    private double rangoFinal = Math.PI;

    private final int PUNTOS = 100;
    private final double pasos = (rangoFinal - rangoInicial) / (PUNTOS);
    
    private int xInicial = 300;
    private int yInicial = 300;

    private int[] puntosX = new int[PUNTOS+1];
    private int[] puntosY = new int[PUNTOS+1];

    public Curva() {
        JFrame frame = new JFrame("Curva 100 puntos");
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
        System.out.println(pasos);

        for(int i=0; i<=PUNTOS; i++) {
            double x = (rangoInicial + pasos * i) * -1;
            double y =  Math.sin(x);

            puntosX[i] = (int) (xInicial + (x*80));
            puntosY[i] = (int) (yInicial + (y*200));

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