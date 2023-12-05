package comp;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import comp.Aviones;
import coords.Avion;
import lib.Graficos2D;
import lib.Graficos3D;
import mov.Transformacion3D;

public class Aviones {
    
    private int[] vectorProyeccion = { 0, 0, 50 };
    private int[][] puntosFinales = new int[34][0];
    
    BufferedImage buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
    Graficos2D graficos2d = new Graficos2D(buffer);
    ArrayList<Puntos> puntosXY;
    Graficos3D graficos3d = new Graficos3D();

    public Aviones(ArrayList<Puntos> puntosXY) {
        this.puntosXY = puntosXY;
    }

    public BufferedImage dibujarAvion(BufferedImage image, float tx, float ty, float tz, Color c1, Color c2, int posX, int posY, int reductor, int reductor2) {
        Avion avion = new Avion();
        Transformacion3D traslacion = new Transformacion3D(tx*-1, ty, tz);

        for(int i=0; i<puntosFinales.length; i++) {
            puntosFinales[i] = traslacion.trasladar(avion.getPuntosX()[i], avion.getPuntosY()[i], avion.getPuntosZ()[0]);
            double u = graficos3d.calcularUPerspectiva(puntosFinales[i][2], vectorProyeccion[2]);
            double x = graficos3d.calcularXPerspectiva(puntosFinales[i][0], u, vectorProyeccion[0]);
            double y = graficos3d.calcularYPerspectiva(puntosFinales[i][1], u, vectorProyeccion[1]);

            puntosXY.add(new Puntos((int)((x/reductor) + posX), (int)((y/reductor2) - posY)));
        }

        dibujarCaras(puntosXY, image, c1, c2);
        

        return image;
    }

    private void dibujarCaras(ArrayList<Puntos> puntosXY, BufferedImage image, Color c, Color c2) {

        int[][] cara = {
            { puntosXY.get(1).x, puntosXY.get(1).y },
            { puntosXY.get(2).x, puntosXY.get(2).y },
            { puntosXY.get(3).x, puntosXY.get(3).y },
            { puntosXY.get(0).x, puntosXY.get(0).y }
        };

        graficos2d.fillPolygon(cara, c, image);
        
        int[][] cara10 = {
            { puntosXY.get(27).x, puntosXY.get(27).y },
            { puntosXY.get(28).x, puntosXY.get(28).y },
            { puntosXY.get(29).x, puntosXY.get(29).y },
            { puntosXY.get(26).x, puntosXY.get(26).y }
        };

        graficos2d.fillPolygon(cara10, c, image);
        
        int[][] cara2 = {
            { puntosXY.get(5).x, puntosXY.get(5).y },
            { puntosXY.get(6).x, puntosXY.get(6).y },
            { puntosXY.get(7).x, puntosXY.get(7).y },
            { puntosXY.get(4).x, puntosXY.get(4).y }
        };
        
        graficos2d.fillPolygon(cara2, c, image);


        int[][] cara3 = {
            { puntosXY.get(9).x, puntosXY.get(9).y },
            { puntosXY.get(10).x, puntosXY.get(10).y },
            { puntosXY.get(11).x, puntosXY.get(11).y },
            { puntosXY.get(8).x, puntosXY.get(8).y }
        };

        graficos2d.fillPolygon(cara3, c, image);
        
        int[][] cara4 = {
            { puntosXY.get(25).x, puntosXY.get(25).y },
            { puntosXY.get(4).x, puntosXY.get(4).y },
            { puntosXY.get(5).x, puntosXY.get(5).y },
            { puntosXY.get(24).x, puntosXY.get(24).y }
        };
        
        graficos2d.fillPolygon(cara4, c, image);

        int[][] cara5 = {
            { puntosXY.get(25).x, puntosXY.get(25).y },
            { puntosXY.get(4).x, puntosXY.get(4).y },
            { puntosXY.get(7).x, puntosXY.get(7).y },
            { puntosXY.get(19).x, puntosXY.get(19).y }
        };

        graficos2d.fillPolygon(cara5, c, image);
        
        int[][] cara6 = {
            { puntosXY.get(14).x, puntosXY.get(14).y },
            { puntosXY.get(15).x, puntosXY.get(15).y },
            { puntosXY.get(12).x, puntosXY.get(12).y },
            { puntosXY.get(13).x, puntosXY.get(13).y }
        };
        
        graficos2d.fillPolygon(cara6, c, image);

        int[][] cara7 = {
            { puntosXY.get(19).x, puntosXY.get(19).y },
            { puntosXY.get(20).x, puntosXY.get(20).y },
            { puntosXY.get(21).x, puntosXY.get(21).y },
            { puntosXY.get(18).x, puntosXY.get(18).y }
        };

        graficos2d.fillPolygon(cara7, c, image);
        
        int[][] cara8 = {
            { puntosXY.get(14).x, puntosXY.get(14).y },
            { puntosXY.get(15).x, puntosXY.get(15).y },
            { puntosXY.get(17).x, puntosXY.get(17).y },
            { puntosXY.get(16).x, puntosXY.get(16).y }
        };

        graficos2d.fillPolygon(cara8, c2, image);
        
        int[][] cara9 = {
            { puntosXY.get(20).x, puntosXY.get(20).y },
            { puntosXY.get(21).x, puntosXY.get(21).y },
            { puntosXY.get(22).x, puntosXY.get(22).y },
            { puntosXY.get(23).x, puntosXY.get(23).y }
        };

        graficos2d.fillPolygon(cara9, c2, image);
        
        int[][] cara11 = {
            { puntosXY.get(31).x, puntosXY.get(31).y },
            { puntosXY.get(30).x, puntosXY.get(30).y },
            { puntosXY.get(33).x, puntosXY.get(33).y },
            { puntosXY.get(32).x, puntosXY.get(32).y }
        };
       
        graficos2d.fillPolygon(cara11, Color.WHITE, image);
        puntosXY.clear();
    }
}
