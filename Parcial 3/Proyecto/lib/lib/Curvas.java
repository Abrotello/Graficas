package lib;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Curvas {
    private BufferedImage buffer;

    public Curvas(BufferedImage buffer_) {
        this.buffer = buffer_;
    }

    public BufferedImage curva100pts(BufferedImage imagen, int xInicial, int yInicial, int amplitud, int longitud, Color color, int puntos) {
        double rangoInicial = 0;
        double rangoFinal = Math.PI;

        final double PASOS = (rangoFinal - rangoInicial) / (puntos);

        int[] puntosX = new int[puntos+1];
        int[] puntosY = new int[puntos+1];

        BufferedImage buffer = new BufferedImage(2, 2, BufferedImage.TYPE_INT_RGB);

        for(int i=0; i<buffer.getWidth(); i++) {
            for(int j=0; j<buffer.getHeight(); j++) {
                buffer.setRGB(i, j, color.getRGB());
            }
        }

        Graficos2D curva = new Graficos2D(buffer);

        for(int i=0; i<=puntos; i++) {
            double x = (rangoInicial + PASOS * i) ;
            double y = (Math.sin(x)) * -1;

            puntosX[i] = (int) (xInicial + (x*amplitud));
            puntosY[i] = (int) (yInicial + (y*longitud));
        }

        int j=0;

        while(j < puntos) {
            curva.paintLine(puntosX[j], puntosY[j], puntosX[j+1], puntosY[j+1], color, imagen);
            j++;
        }

        return imagen;
    }

    public BufferedImage parametrica(BufferedImage imagen, int xInicial, int yInicial, int amplitud, int longitud, Color color) {
        Graficos2D figuras = new Graficos2D(buffer);
        double ANGULO = 0;
        final int PUNTOS = 500;
        final double PASOS = 0.1;

        int[] puntosX = new int[PUNTOS+1];
        int[] puntosY = new int[PUNTOS+1];

        for(int i=0; i<=PUNTOS; i++) {
            double x = ANGULO - (3 * Math.sin(ANGULO)) * -1;
            double y =  4 - (3 * Math.cos(ANGULO));

            puntosX[i] = (int) (xInicial + (x*amplitud));
            puntosY[i] = (int) (yInicial + (y*longitud));

            ANGULO += PASOS;
        }

        int j=0;
        while(j < PUNTOS) {
            figuras.paintLine(puntosX[j], puntosY[j], puntosX[j+1], puntosY[j+1], color, imagen);
            j++;
        }        
        
        return imagen;
    }

    public BufferedImage sol(BufferedImage imagen, int xInicial, int yInicial, int amplitud, int longitud, Color color) {

        double rangoInicial = 0;
        double rangoFinal = Math.PI*14;

        final int PUNTOS = 600;
        final double PASOS = (rangoInicial - rangoFinal) / PUNTOS;

        int[] puntosX = new int[PUNTOS+1];
        int[] puntosY = new int[PUNTOS+1];

        Graficos2D figuras = new Graficos2D(buffer);
        double ANGULO = 0;

        for(int i=0; i<=PUNTOS; i++) {
            double x = (17 * Math.cos(ANGULO)) + 7 * Math.cos(2.428571 * ANGULO);
            double y = (17 * Math.sin(ANGULO)) - 7 * Math.sin(2.428571 * ANGULO);

            puntosX[i] = (int) (xInicial + (x*amplitud));
            puntosY[i] = (int) (yInicial + (y*longitud));

            ANGULO += PASOS;
        }

        int j=0;
        while(j < PUNTOS) {
            figuras.paintLine(puntosX[j], puntosY[j], puntosX[j+1], puntosY[j+1], color, imagen);
            j++;
        }

        return imagen;
    }

    public BufferedImage flor(BufferedImage image, int xInicial, int yInicial, int amplitud, int longitud, Color color) {

        double rangoInicial = 0;
        double rangoFinal = Math.PI*2;

        final int PUNTOS = 600;
        final double PASOS = (rangoInicial - rangoFinal) / PUNTOS;

        int[] puntosX = new int[PUNTOS+1];
        int[] puntosY = new int[PUNTOS+1];

        Graficos2D figuras = new Graficos2D(buffer);
        double ANGULO = 0;

        for(int i=0; i<=PUNTOS; i++) {
            double x = Math.cos(ANGULO) + 0.5 * Math.cos(7 * ANGULO) + 0.3 * Math.sin(17 * ANGULO);
            double y = Math.sin(ANGULO) + 0.5 * Math.sin(7 * ANGULO) + 0.3 * Math.cos(17 * ANGULO);

            puntosX[i] = (int) (xInicial + (x*amplitud));
            puntosY[i] = (int) (yInicial + (y*longitud));

            ANGULO += PASOS;
        }

        int j=0;
        while(j < PUNTOS) {
            figuras.paintLine(puntosX[j], puntosY[j], puntosX[j+1], puntosY[j+1], color, image);
            j++;
        }


        return image;
    }

    public BufferedImage infinito(BufferedImage imagen, int xInicial, int yInicial, int amplitud, int longitud, int radio, Color color) {
        final int PUNTOS = 65;
        
        int[] puntosX = new int[PUNTOS+1];
        int[] puntosY = new int[PUNTOS+1];

        Graficos2D figuras = new Graficos2D(buffer);
        double angulo = 0;
        final double PASOS = 0.1;

        for(int i=0; i<=PUNTOS; i++) {
            double x = radio * Math.sin(angulo) / 1 + Math.cos(2) * angulo;
            double y = radio * Math.sin(angulo) * Math.cos(angulo) / 1 + Math.cos(2) * angulo;

            puntosX[i] = (int) Math.round(xInicial + (x*amplitud));
            puntosY[i] = (int) Math.round(yInicial + (y*longitud));

            angulo += PASOS;
        }

        int j=0;
        while(j < PUNTOS) {
            figuras.paintLine(puntosX[j], puntosY[j], puntosX[j+1], puntosY[j+1], color, imagen);
            j++;
        }

        return imagen;
    }

    public BufferedImage humito(BufferedImage image, int xInicial, int yInicial, int amplitud, int longitud, Color color) {
        double rangoInicial = 0;
        double rangoFinal = Math.PI*2;

        final int PUNTOS = 100;
        final double pasos = (rangoFinal - rangoInicial) / (PUNTOS);

        int[] puntosX = new int[PUNTOS+1];
        int[] puntosY = new int[PUNTOS+1];

        Graficos2D figuras = new Graficos2D(buffer);

        for(int i=0; i<=PUNTOS; i++) {
            double y = (rangoInicial + pasos * i) * -1;
            double x =  y*(Math.cos(4*y));

            puntosX[i] = (int) (xInicial + (x*amplitud));
            puntosY[i] = (int) (yInicial + (y*longitud));
        }

        int j=0;
        while(j < PUNTOS) {
            figuras.paintLine(puntosX[j], puntosY[j], puntosX[j+1], puntosY[j+1], color, image);
            j++;
        }

        return image;
    }
}
