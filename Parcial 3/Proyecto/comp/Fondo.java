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

    int contador = 0;
    int segundos = 0;
    int minutos = 0;
    
    //Traslacion
    private float tx, ty, tz;
    //Escalacion
    private float sx = (float)0.5, sy, sz;
    //Calculos
    private int[] vectorProyeccion = { 640, 0, 50 };

    private boolean bandera = false;
    private int temp = 0;
    
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
    }

    private void dibujarNubes() {
        BufferedImage bufferedImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Graficos2D graficos2d = new Graficos2D(bufferedImage);
        int separacion = 0;
        for(int i=0; i<7; i++) {
            graficos2d.floodFillCircle(separacion + 50, 45, 15, cielo, Color.WHITE);
            graficos2d.floodFillCircle(separacion + 65, 40, 17, cielo, Color.WHITE);
            graficos2d.floodFillCircle(separacion + 65, 50, 17, cielo, Color.WHITE);
            graficos2d.floodFillCircle(separacion + 80, 45, 15, cielo, Color.WHITE);
            
            separacion += 200;
        }
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
    
    private void dibujarCarteles() {
        Color maderaOscuro = new Color(48, 33, 8);
        Color madera = new Color(139, 96, 23);
        Carteles carteles = new Carteles();
        ArrayList<Puntos> puntosXY = new ArrayList<Puntos>();
        BufferedImage buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Graficos2D graficos2d = new Graficos2D(buffer);
        Graficos3D graficos3d = new Graficos3D();

        for(int i=0; i<carteles.getPuntosX().length; i++) {
            double u = graficos3d.calcularUParalela(carteles.getPuntosZ()[i], vectorProyeccion[2]);
            double x = graficos3d.calcularXParalela(carteles.getPuntosX()[i], u, vectorProyeccion[0]);
            double y = graficos3d.calcularYParalela(carteles.getPuntosY()[i], u, vectorProyeccion[1]);

            puntosXY.add(new Puntos((int)x, (int)y));
        }

        int[][] cara = {
            { puntosXY.get(3).x, puntosXY.get(3).y }, 
            { puntosXY.get(2).x, puntosXY.get(2).y },
            { puntosXY.get(0).x, puntosXY.get(0).y },
            { puntosXY.get(1).x, puntosXY.get(1).y }
        };
        
        graficos2d.fillPolygon(cara, madera, fondo);
    
        int[][] cara2 = {
            { puntosXY.get(5).x, puntosXY.get(5).y }, 
            { puntosXY.get(4).x, puntosXY.get(4).y },
            { puntosXY.get(2).x, puntosXY.get(2).y },
            { puntosXY.get(3).x, puntosXY.get(3).y }
        };

        graficos2d.fillPolygon(cara2, maderaOscuro, fondo);

        int[][] cara3 = {
            { puntosXY.get(5).x, puntosXY.get(5).y }, 
            { puntosXY.get(3).x, puntosXY.get(3).y },
            { puntosXY.get(1).x, puntosXY.get(1).y },
            { puntosXY.get(6).x, puntosXY.get(6).y }
        };
        
        graficos2d.fillPolygon(cara3, maderaOscuro, fondo);

        int cara4[][] = {
            { puntosXY.get(8).x, 230 },
            { puntosXY.get(7).x, 230 },
            { puntosXY.get(7).x, puntosXY.get(7).y },
            { puntosXY.get(8).x, puntosXY.get(8).y }
        };

        graficos2d.fillPolygon(cara4, maderaOscuro, fondo);

    }

    private void dibujarCerros() {
        Color cerro = new Color(5, 61, 22);
        BufferedImage buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Curvas montanas = new Curvas(buffer);

        int separacion = 0;
        for(int i=0; i<4; i++) {
            montanas.curva100pts(cielo, 30 + separacion, 200, 40, 30, cerro, 2);
            montanas.curva100pts(cielo, 150 + separacion, 200, 30, 20, cerro, 2);
            montanas.curva100pts(cielo, 240 + separacion, 200, 30, 20, cerro, 2);
            
            separacion += 295;
        }
    }

    private void dibujarAnimacion() {
        ArrayList<Puntos> puntosAvion1 = new ArrayList<Puntos>();
        Aviones avion = new Aviones(puntosAvion1);
        Trenes tren = new Trenes();

        if(minutos < 2) {
            animacion = avion.dibujarAvion(animacion, tx, ty, tz, Color.RED, Color.WHITE, 1200, -80, 5, 5);
            animacion = avion.dibujarAvion(animacion, tx, ty, tz, Color.YELLOW, Color.BLACK, 1500, -50, 3, 4);
            animacion = avion.dibujarAvion(animacion, tx, ty, tz, Color.GRAY, Color.BLACK, 1200, -50, 3, 4);
            animacion = avion.dibujarAvion(animacion, tx, ty, tz, Color.BLACK, Color.BLUE, 1200, 10, 2, 2);
        }
        
        if(bandera) {
            animacion = tren.dibujarTren(animacion, sx, sy, sz);
        }

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
            dibujarCarteles();
            dibujarNubes();
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
        

        while (minutos < 2) {

            if(contador == 100) {
                segundos++;
                contador=0;
                System.out.println(segundos);
            }
            contador++;
            
            if(segundos == 60) {
                minutos++;
                segundos = 0;
                contador = 0;
                System.out.println(minutos);
            }

            if(segundos == 40) {
                tx=0;
                ty=0;
                tz=0;
                temp++;
                bandera = true;
            }

            if(temp == 40) {
                bandera = false;
            }

            if(!bandera) {
                sx=0;
                sy=0;
                sz=0;
            } else if(bandera) {
                 if(sy > 0.8 && sy < 1.6) {
                    sx = (float)0.75;
                } else if(sy > 1.6 && sy < 2.5) {
                    sx = (float)1.125;
                } else if(sy > 2.5 && sy < 4.1) {
                    sx = (float)1.6875;
                } else if(sy > 4.1 && sy < 5.6) {
                    sx = (float)2.53125;
                } else if(sy > 5.6 && sy < 7.8) {
                    sx = (float)3.796875;
                } else if(sy > 7.8 && sy < 11) {
                    sx = (float)5.6953125;
                } else if (sy > 14){
                    sx = (float)8.5;
                }
                
                sy += 0.01;
                sz = 1;
            }

            tx+=1.8;
            ty+=0.05;
            tz=1;

            try {
                repaint();
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
        }
    }
}
