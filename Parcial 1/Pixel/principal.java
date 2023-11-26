import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;

public class principal extends JFrame implements Runnable{

    private BufferedImage buffer;
    private Thread hilo;
    int x = 200;
    int xFin = 400;

    public principal() {
        hilo = new Thread(this);
        hilo.start();

        setTitle("Pixels");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        buffer = new BufferedImage(2,2,BufferedImage.TYPE_INT_RGB); 
    }

    public static void main(String[] args) {
        new principal();
    }

    public void putPixel(int x, int y, Color c) {
        buffer.setRGB(0,0,c.getRGB());
        this.getGraphics().drawImage(buffer, x, y,this);
    }

    private void movingPixel() {
        
        if(x < xFin) {
            putPixel(x, 200, Color.BLUE);
            x += 1;
        } else {
            x = 200;
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        movingPixel();
        //putPixel(100, 100, Color.RED);
    }

    @Override
    public void run() {
        while(true) {
            try {
                repaint();
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
        }
    }
}