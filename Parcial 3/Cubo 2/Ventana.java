import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JPanel {
    
    private BufferedImage image;
    private int[] vectorProyeccion = { 2, 2, 5 };

    private int xcentro = 150;
    private int ycentro = 150;

    Color color1 = Color.WHITE;
    Color color2 = Color.GREEN;
    
    public Ventana() {
        JFrame frame = new JFrame("Cubo");
        frame.add(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    private void proyeccion() {
        BufferedImage buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Figuras figuras = new Figuras(buffer);

        int aux = 0;
        int[] figuraX1 = new int[4]; 
        int[] figuraY1 = new int[4];
        
        int[] figuraX2 = new int[4];
        int[] figuraY2 = new int[4];
        
        Cubo cubo = new Cubo();
        image = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);

        for(int i=0; i<8; i++) { 
            double u = calcularU(cubo.getPuntosZ()[i]);
            double x = calcularX(cubo.getPuntosX()[i], u);
            double y = calcularY(cubo.getPuntosY()[i], u);
            System.out.println("Punto " + (i+1));
            System.out.println("x: " + x);
            System.out.println("y: " + y + "\n");

            if(i < 4) {
                figuraX1[i] = (int) (xcentro + (x*3)); 
                figuraY1[i] = (int) (ycentro + (y*3));
            } else {
                figuraX2[aux] = (int) (xcentro + (x*3));
                figuraY2[aux] = (int) (ycentro + (y*3));
                aux++;
            }
        }

        figuras.poligono4Lados(figuraX1, figuraY1, color1, image);
        figuras.poligono4Lados(figuraX2, figuraY2, color1, image);
        figuras.bresenham(figuraX1[0], figuraY1[0], figuraX2[0], figuraY2[0], color1, image);
        figuras.bresenham(figuraX1[1], figuraY1[1], figuraX2[1], figuraY2[1], color1, image);
        figuras.bresenham(figuraX1[2], figuraY1[2], figuraX2[2], figuraY2[2], color1, image);
        figuras.bresenham(figuraX1[3], figuraY1[3], figuraX2[3], figuraY2[3], color1, image);
        
    }

    private double calcularU(double z) {
        return ((-1 * vectorProyeccion[2]) / (z - vectorProyeccion[2]));
    }

    private double calcularX(double x1, double u) {
        return vectorProyeccion[0] + ((x1 - vectorProyeccion[0]) * u);
    }

    private double calcularY(double y1, double u) {
        return vectorProyeccion[1] + ((y1 - vectorProyeccion[1]) * u);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        proyeccion();
        g.drawImage(image, 0, 0, this);
    }
}
