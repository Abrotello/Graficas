package comp;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Fondo extends JPanel implements Runnable {

    BufferedImage fondo;
    
    public Fondo() {}


    private void dibujarFondo(Graphics g) {

        if( fondo == null ) {

            fondo = new BufferedImage(1280, 720, BufferedImage.TYPE_INT_RGB);

            //Dibujar fondo

        }

        update(g);
    }

    @Override
    public void update(Graphics g) {
        
    }

    @Override
    public void paint(Graphics g) {        
        dibujarFondo(g);
    }

    @Override
    public void run() {
        
        while (true) {

            try {
                repaint();
                Thread.sleep(50);
                //System.out.println("Tick");
            } catch (InterruptedException e) {
                e.getStackTrace();
            }

        }

    }
}
