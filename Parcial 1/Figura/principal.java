import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Graphics;

public class principal extends JFrame{

    public principal() {

        setSize(500,500);
        setTitle("Casita");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(new Color(25, 150, 200));
        g.fillRect(150, 100, 250, 180);

        g.setColor(new Color(255, 150, 200));
        g.fillOval(150, 200, 150, 100);
        
        g.setColor(new Color(255, 150, 20));
        g.fillPolygon(new int[] {10, 80, 100}, new int[] {100, 20, 100}, 3);
    
    }


    public static void main(String[] args) {
        new principal();
    }
}