import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;



public class principal extends JFrame{ 

    private BufferedImage buffer;

    //Coordenadas punto A
    private int[] puntoA = {10, 300};
    //Coordenadas punto B
    private int[] puntoB = {400, 100};

    int pasosX = 0;
    int pasosY = 0;
    int x, y;

    public principal() {
        nuevasCoordenadas(puntoA[0], puntoA[1], puntoB[0], puntoB[1]);

        setTitle("Rectangulo");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        buffer = new BufferedImage(2, 2, BufferedImage.TYPE_INT_RGB);
        setVisible(true);
    }


    private void nuevasCoordenadas(int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);


        if(x2 > x1) {
            x = x1;
            y = y2;
        } else {
            x = x2;
            y = y1;
        }

        pasosX = dx;
        pasosY = dy;
    }

    public void paint(Graphics g) {
        super.paint(g);

        for(int i=0; i<=pasosY; i++) {
            y += 1;
            putPixel(puntoA[0], y, Color.RED);
            putPixel(puntoB[0], y, Color.RED);
        }

        for(int j=0; j<=pasosX; j++) {
            x += 1;
            putPixel(x, puntoA[1], Color.RED);
            putPixel(x, puntoB[1], Color.RED);
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