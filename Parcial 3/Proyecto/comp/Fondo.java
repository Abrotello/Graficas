package comp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.JPanel;

import coords.*;
import lib.*;

public class Fondo extends JPanel implements Runnable {

    private BufferedImage fondo = null;
    private BufferedImage cielo = null;
    private BufferedImage animacion = null;
    private Graphics gAnimacion;
    


    //Calculos
    private int[] vectorProyeccion = { 8, 7, 50 };
    

    public Fondo() {}

    private void dibujarRieles() {
        Color gris = new Color(223, 223, 225);
        Rieles rieles = new Rieles();
        ArrayList<Puntos> puntosXY = new ArrayList<Puntos>();
        BufferedImage buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Graficos2D graficos2d = new Graficos2D(buffer);
        Graficos3D graficos3d = new Graficos3D();

        for(int i=0; i<rieles.getPuntosX().length; i++) {
            double u = graficos3d.calcularUParalela(rieles.getPuntosZ()[i], vectorProyeccion[2]);
            double x = graficos3d.calcularXParalela(rieles.getPuntosX()[i], u, vectorProyeccion[0]);
            double y = graficos3d.calcularYParalela(rieles.getPuntosY()[i], u, vectorProyeccion[1]);

            puntosXY.add(new Puntos((int)x, (int)y));
        }

        graficos2d.paintLine(puntosXY.get(0).x, puntosXY.get(0).y, puntosXY.get(1).x, puntosXY.get(1).y, Color.GRAY, fondo);
        graficos2d.paintLine(puntosXY.get(2).x, puntosXY.get(2).y, puntosXY.get(3).x, puntosXY.get(3).y, Color.GRAY, fondo);
        
        for(int i=0; i<4; i++) {
            graficos2d.paintLine(puntosXY.get(i).x, puntosXY.get(i).y, puntosXY.get(4).x, puntosXY.get(4).y, Color.GRAY, fondo);
        }

        int[][] riel = {
            { puntosXY.get(0).x, puntosXY.get(0).y },
            { puntosXY.get(4).x, puntosXY.get(4).y },
            { puntosXY.get(1).x, puntosXY.get(1).y }
        };
        graficos2d.fillPolygon(riel, gris, fondo);
        int[][] riel2 = {
            { puntosXY.get(3).x, puntosXY.get(3).y },
            { puntosXY.get(4).x, puntosXY.get(4).y },
            { puntosXY.get(2).x, puntosXY.get(2).y }
        };
        graficos2d.fillPolygon(riel2, gris, fondo);
        graficos2d.floodFillCircle(640, 5,5, fondo, Color.BLACK);
        dibujarNubes();
    }

    private void dibujarNubes() {
        BufferedImage bufferedImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Graficos2D graficos2d = new Graficos2D(bufferedImage);
        int separacion = 0;
        for(int i=0; i<6; i++) {
            graficos2d.floodFillCircle(separacion + 50, 45, 15, cielo, Color.WHITE);
            graficos2d.floodFillCircle(separacion + 65, 40, 17, cielo, Color.WHITE);
            graficos2d.floodFillCircle(separacion + 65, 50, 17, cielo, Color.WHITE);
            graficos2d.floodFillCircle(separacion + 80, 45, 15, cielo, Color.WHITE);
            
            separacion += 200;
        }

        Curvas sol = new Curvas(bufferedImage);
        sol.sol(cielo, 1220, 40, 2, 2, Color.YELLOW);
        graficos2d.floodFillCircle(1220, 40, 25, cielo, Color.ORANGE);
    }

    private void dibujarTablas() {
        Color maderaOscuro = new Color(48, 33, 8);
        Color madera = new Color(139, 96, 23);
        Tablas tablas = new Tablas();
        ArrayList<Puntos> puntosXY = new ArrayList<Puntos>();
        BufferedImage buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Graficos2D graficos2d = new Graficos2D(buffer);
        Graficos3D graficos3d = new Graficos3D();

        for(int i=0; i<tablas.getPuntosX().length; i++) {
            double u = graficos3d.calcularUPerspectiva(tablas.getPuntosZ()[i], vectorProyeccion[2]);
            double x = graficos3d.calcularXPerspectiva(tablas.getPuntosX()[i], u, vectorProyeccion[0]);
            double y = graficos3d.calcularYPerspectiva(tablas.getPuntosY()[i], u, vectorProyeccion[1]);

            puntosXY.add(new Puntos((int)x, (int)y));
        }

        ArrayList<Tablas> caras = new ArrayList<Tablas>();
        int separacion = 80;
        int reduccion = 0;

        for(int i=0; i<10; i++) {

            int[][] cara = {
                { puntosXY.get(1).x + reduccion, puntosXY.get(1).y - separacion },
                { puntosXY.get(0).x + reduccion, puntosXY.get(0).y - separacion },
                { puntosXY.get(3).x - reduccion, puntosXY.get(3).y - separacion },
                { puntosXY.get(4).x - reduccion, puntosXY.get(4).y - separacion } 
            };
            
            int[][] cara2 = {
                { puntosXY.get(2).x + reduccion, puntosXY.get(2).y - separacion },
                { puntosXY.get(1).x + reduccion, puntosXY.get(1).y - separacion },
                { puntosXY.get(4).x - reduccion, puntosXY.get(4).y - separacion },
                { puntosXY.get(5).x - reduccion, puntosXY.get(5).y - separacion }
            };

            switch (i) {
                case 7:
                    reduccion = 210;
                    separacion = 395;
                    break;
                case 8:
                    reduccion = 230;
                    separacion = 440;
                    break;
                case 9:
                    reduccion = 230;
                    separacion = 500;
                    break;

                default:
                    break;
            }

            reduccion += 30;
            separacion += 45;
            caras.add(new Tablas(cara, cara2));
        }

        for(int i=0; i<caras.size(); i ++) {
            graficos2d.fillPolygon(caras.get(i).cara, maderaOscuro, fondo);
            graficos2d.fillPolygon(caras.get(i).cara2, madera, fondo);
        }

        dibujarRieles();
    }
    
    private void dibujarEdificios() {
        Edificios edificios = new Edificios();
    }

    private void dibujarCerros() {

    }

    private void dibujarAnimacion() {
        
    }


    private void dibujarFondo(Graphics g) {

        if( fondo == null && cielo == null ) {
            
            cielo = new BufferedImage(1280, 200, BufferedImage.TYPE_INT_RGB);
            fondo = new BufferedImage(1280, 500, BufferedImage.TYPE_INT_RGB);

            Color desierto = new Color(198, 106, 55);
            for(int i=0; i<fondo.getWidth(); i++) {
                for(int j=0; j<fondo.getHeight(); j++) {
                    fondo.setRGB(i, j, desierto.getRGB());
                }
            }
            
            Color azulCielo = new Color(140, 210, 218);

            for(int i=0; i<cielo.getWidth(); i++) {
                for(int j=0; j<cielo.getHeight(); j++) {
                    cielo.setRGB(i, j, azulCielo.getRGB());
                }
            }

            dibujarTablas();
            dibujarEdificios();
            dibujarCerros();

        }

        update(g);
    }

    @Override
    public void update(Graphics g) {
        animacion = new BufferedImage(1280, 600, BufferedImage.TYPE_INT_RGB);
        gAnimacion = animacion.getGraphics();
        
        gAnimacion.drawImage(cielo, 0, 0, this);
        gAnimacion.drawImage(fondo, 0, 200, this);

        dibujarAnimacion();

        g.drawImage(animacion, 0, 0, this);
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
