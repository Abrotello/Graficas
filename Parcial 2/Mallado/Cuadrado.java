import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Cuadrado extends JPanel {

    private Image imagen;

    private int[] puntosA = {3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    private int[] puntosB = {3, 4, 5, 6, 7, 8, 9, 10};

    public Cuadrado() {
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
        int[] puntosX = new int[puntosA.length+1];
        int[] puntosY = new int[puntosA.length+1];
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        calcularCurva();
        g.drawImage(imagen, 0, 0, this);
    }
}