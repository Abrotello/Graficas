import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;

public class principal extends JFrame{

    private BufferedImage buffer;

    //Coordenadas del centro
    private int[] centro = {250, 250};
    //Radio del circulo
    private int radio = 100;

    private int[] coordenadasY;
    private int[] coordenadasNegativosY;
    private int indice = 0;

    int xinicial = 0;
    int xfinal = 0;

    public principal() {
        circuloBasico(centro[0], centro[1], radio);

        setTitle("Circulo basico");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        setVisible(true);
    }

    public void circuloBasico(int xcentro, int ycentro, int radio_) {
        xinicial = xcentro - radio_;
        xfinal = xcentro + radio_;

        int radioCuadrado = potencia(radio_, 2);
        int resultadoCuadrado = 0;

        coordenadasY = new int[xfinal-xinicial+1];
        coordenadasNegativosY = new int[xfinal-xinicial+1];

        for(int i=xinicial; i<=xfinal; i++) {
            resultadoCuadrado = potencia(i-xcentro, 2);
            coordenadasY[indice] = (int) Math.round(ycentro + Math.sqrt(radioCuadrado - resultadoCuadrado));
            coordenadasNegativosY[indice] = (int) Math.round(ycentro - Math.sqrt(radioCuadrado - resultadoCuadrado));
            System.out.println("X: " + i);
            System.out.println("Y positiva: " + coordenadasY[indice]);
            System.out.println("Y negativa: " + coordenadasNegativosY[indice]);
            indice++;
        }
        
    }

    private int potencia(int numero, int veces) {
        int auxiliar = 0;
        while(veces > 0) {
             auxiliar = numero * numero;
             veces--;
        }
        return auxiliar;
    }

    public void paint(Graphics g) {
        super.paint(g);
        indice = 0;
        for(int i=xinicial; i<=xfinal; i++) {
            if(coordenadasY[indice] == coordenadasNegativosY[indice]) {
                putPixel(i, coordenadasY[indice], Color.RED);
            }
            putPixel(i, coordenadasY[indice], Color.RED);
            putPixel(i, coordenadasNegativosY[indice], Color.RED);
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