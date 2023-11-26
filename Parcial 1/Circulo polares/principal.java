import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;

public class principal extends JFrame {

    private BufferedImage buffer;

    //Coordenadas del centro
    private int[] centro = {250, 260};
    //Radio del circulo 
    private int radio = 150;
    //Angulo
    private double angulo = 0;
    private int anguloFinal = 3600;
    private final double PASOS = 0.2;

    //Matrices para las coordenadas a graficar
    private int[] coordenadasX;
    private int[] coordenadasY;
    private int indice = 0;

    public principal() {
        circuloPolares(centro[0], centro[1], radio, angulo);

        setTitle("Circulo polares");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        setVisible(true);
    }

    private void circuloPolares(int xcentro, int ycentro, int radio_, double angulo_) {
        coordenadasX = new int[anguloFinal+1];
        coordenadasY = new int[anguloFinal+1];

        double anguloRadianes = 0;
        
        //Math.sin funciona en radianes
        for(int i=0; i <= anguloFinal; i++) {
            angulo_ += PASOS;
            anguloRadianes = degreesToRadians(angulo_);
            coordenadasX[indice] = (int) Math.round(xcentro + radio_ * Math.sin(anguloRadianes));
            coordenadasY[indice] = (int) Math.round(ycentro + radio_ * Math.cos(anguloRadianes));
            indice++;
        }
    }

    private double degreesToRadians(double anguloConvertir) {
        double resultado = anguloConvertir * Math.PI / 180;
        return resultado;
    }

    public void paint(Graphics g) {
        super.paint(g);
        indice = 0;

        for(int i=0; i <= anguloFinal; i++) {
            putPixel(coordenadasX[indice], coordenadasY[indice], Color.BLACK);
            indice++;
        }
    }

    public void putPixel(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(buffer, x, y, this);
    }

    public static void main(String[] args) {
        new principal();    
    }
}