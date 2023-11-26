import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Figuras extends JPanel {

    private BufferedImage imagen;
    private Color contorno = Color.RED;
    
    Bresenham bresenham = new Bresenham();

    public Figuras() {
        JFrame frame = new JFrame("Triangulo y Rombo");
        frame.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void triangulo() {
        int[] puntoA = {150, 75};
        int[] puntoB = {100, 150};
        int[] puntoC = {200, 150};
        
        bresenham.algoritmo(puntoA[0], puntoA[1], puntoB[0], puntoB[1], contorno, imagen);
        bresenham.algoritmo(puntoA[0], puntoA[1], puntoC[0], puntoC[1], contorno, imagen);
        bresenham.algoritmo(puntoB[0], puntoB[1], puntoC[0], puntoC[1], contorno, imagen);
    }

    private void rombo() {
        int[] puntoA = {350, 175};
        int[] puntoB = {300, 250};
        int[] puntoC = {400, 250};
        int[] puntoD = {350, 325};

        bresenham.algoritmo(puntoA[0], puntoA[1], puntoB[0], puntoB[1], contorno, imagen);
        bresenham.algoritmo(puntoA[0], puntoA[1], puntoC[0], puntoC[1], contorno, imagen);
        bresenham.algoritmo(puntoB[0], puntoB[1], puntoD[0], puntoD[1], contorno, imagen);
        bresenham.algoritmo(puntoC[0], puntoC[1], puntoD[0], puntoD[1], contorno, imagen);

        bresenham.floodFill(350, 250, contorno);
    }



    @Override
    public void paint(Graphics g) {
        super.paint(g);
        imagen = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
        triangulo();
        rombo();
        g.drawImage(imagen, 0, 0, this);
    }
}
