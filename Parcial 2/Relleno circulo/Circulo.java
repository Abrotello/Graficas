import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Circulo extends JPanel implements Runnable{
    
    private Thread hilo;

    private int radioInicial = 0;
    private int radioFinal;

    private int xcentro, ycentro;
    private double anguloFinal = 3600;
    private double angulo = 0;  
    private final double PASOS = 0.55;

    private ArrayList<Integer> coordenadasX;
    private ArrayList<Integer> coordenadasY;

    private BufferedImage buffer;
    Graphics gBuffer;
    

    public Circulo(int xcentro_, int ycentro_, int radio_) {
        hilo = new Thread(this);
        hilo.start();

        this.xcentro = xcentro_;
        this.ycentro = ycentro_;
        this.radioFinal = radio_;

        coordenadasX = new ArrayList<>();
        coordenadasY = new ArrayList<>();
        floodFill(xcentro, ycentro);

        setBackground(Color.white);
        buffer = new BufferedImage(2, 2, BufferedImage.TYPE_INT_RGB);
        gBuffer = buffer.createGraphics();
        gBuffer.setColor(Color.BLACK);
        
    }

    private void floodFill(int x, int y) {
        int radioMAX = radioFinal;
        int radioMIN = radioInicial;

        while (radioMIN < radioMAX) {
            circuloPolares(x, y, radioMIN, angulo);
            radioMIN++;
        }
    }

    private void circuloPolares(int xcentro_, int ycentro_, int radio_, double angulo_) {
        
        int x;
        int y;
        double anguloRadianes;

        for(int i=0; i <= anguloFinal; i++) {
            angulo_ += PASOS;
            anguloRadianes = degreesToRadians(angulo_);
            x = (int) Math.round(xcentro_ + radio_ * Math.sin(anguloRadianes));
            y = (int) Math.round(ycentro_ + radio_ * Math.cos(anguloRadianes));
            
            coordenadasX.add(x);
            coordenadasY.add(y);
        }
    }


    private double degreesToRadians(double anguloConvertir) {
        double resultado = anguloConvertir * Math.PI / 180;
        return resultado;
    }

    public void putPixel(int x, int y, Color c, Graphics g) {
        buffer.setRGB(0, 0, c.getRGB());
        gBuffer.drawImage(buffer, 0, 0, this);
        g.drawImage(buffer, x, y, this);
    }

    @Override
    public void paint(Graphics g) {
        int indice = 0;

        while (radioInicial < radioFinal) {
            for(int i=0; i <= anguloFinal; i++) {
                putPixel(coordenadasX.get(indice), coordenadasY.get(indice), gBuffer.getColor(), g);
            }
            radioInicial++;
        }
    }


    @Override
    public void run() {
        
        while(true) {

            try {
                repaint();
                Thread.sleep(500);
                System.out.println("Repaint");

            } catch (InterruptedException e) {
                e.getStackTrace();
            }
        }
    }
}
