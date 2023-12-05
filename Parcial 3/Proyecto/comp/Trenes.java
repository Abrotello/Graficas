package comp;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import coords.Tren;
import lib.*;

public class Trenes {
    private int[] vectorProyeccion = { 0, 0, 50 };
    private int[][] puntosFinales = new int[33][0];

    BufferedImage buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
    Graficos2D graficos2d = new Graficos2D(buffer);

    ArrayList<Puntos> puntosXY = new ArrayList<Puntos>();
    Graficos3D graficos3d = new Graficos3D();

    public Trenes() {}

    public BufferedImage dibujarTren(BufferedImage image) {
        Tren tren = new Tren();

        for(int i=0; i<puntosFinales.length; i++) {
            double u = graficos3d.calcularUPerspectiva(tren.getPuntosZ()[0], vectorProyeccion[2]);
            double x = graficos3d.calcularXPerspectiva(tren.getPuntosX()[i], u, vectorProyeccion[0]);
            double y = graficos3d.calcularYPerspectiva(tren.getPuntosY()[i], u, vectorProyeccion[1]);

            puntosXY.add(new Puntos((int)x, (int)y));
        }

        dibujarCaras(puntosXY, image);  

        return image;
    }

    private void dibujarCaras(ArrayList<Puntos> puntosXY, BufferedImage image) {





    }

}
