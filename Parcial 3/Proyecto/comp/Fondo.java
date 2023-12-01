package comp;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

import coords.*;
import lib.*;

public class Fondo extends JPanel implements Runnable {

    private BufferedImage fondo;



    //Calculos
    private int[] vectorProyeccion = { 50, 0, 50 };
    private ArrayList<Puntos> puntosXY = new ArrayList<Puntos>();
    private BufferedImage buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
    private Graficos2D graficos2d = new Graficos2D(buffer);

    public Fondo() {}

    private void dibujarRieles() {
        Rieles rieles = new Rieles();
        Tablas tablas = new Tablas();

    }

    private void dibujarEdificios() {
        Edificios edificios = new Edificios();
    }


    private void dibujarFondo(Graphics g) {

        if( fondo == null ) {

            fondo = new BufferedImage(1280, 720, BufferedImage.TYPE_INT_RGB);

            dibujarRieles();
            dibujarEdificios();

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
            } catch (InterruptedException e) {
                e.getStackTrace();
            }

        }

    }
}
