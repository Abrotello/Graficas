import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
public class principal extends JFrame {
    
    int x1 = 188, y1 = 188, x2 = 103, y2 = 103; 
    
    int x, y;
    int steps;
    int xinc, yinc;
    
    private BufferedImage buffer;
    private Graphics graPixel;

    public static void main(String[] args) {   
        new principal(); 
    }

    public principal() {
        DDA(x1, y1, x2, y2);

        setTitle("DDA");
        setSize(500, 500);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        
        buffer = new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB);
        graPixel = (Graphics2D) buffer.createGraphics();
    }

    public void DDA (int x1_, int y1_, int x2_, int y2_) {
        int dx = Math.abs(x2_ - x1_);
        int dy = Math.abs(y2_ - y1_);

        if(dx > dy) {
            steps = dx;
        } else {
            steps = dy;
        }

        xinc = dx / steps;
        yinc = dy / steps;

        x = x1_;
        y = y1_;
    }

    public void putPixel(int x, int y, Color c) {
        buffer.setRGB(0,0,c.getRGB());
        this.getGraphics().drawImage(buffer, x, y,this);
    }

    
    public void paint(Graphics g) {
        super.paint(g);
        for(int i=1; i<=steps; i++) {
            x += xinc;
            y += yinc;
            putPixel(x, y, Color.GREEN);
        }
    }
}