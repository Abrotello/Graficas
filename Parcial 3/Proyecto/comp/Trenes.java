package comp;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import coords.Tren;
import lib.*;
import mov.Transformacion3D;

public class Trenes {
    private int[] vectorProyeccion = { 640, 0, 50 };
    private int[][] puntosFinales = new int[33][0];

    BufferedImage buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
    Graficos2D graficos2d = new Graficos2D(buffer);

    ArrayList<Puntos> puntosXY = new ArrayList<Puntos>();
    Graficos3D graficos3d = new Graficos3D();
    int posicionamiento = 0;
    

    public Trenes() {}

    public BufferedImage dibujarTren(BufferedImage image, float tx, float ty, float tz) {
        Tren tren = new Tren();
        Transformacion3D escalacion = new Transformacion3D(tx, ty, tz);

        for(int i=0; i<puntosFinales.length; i++) {
            puntosFinales[i] = escalacion.escalar(tren.getPuntosX()[i], tren.getPuntosY()[i], tren.getPuntosZ()[0]);
            double u = graficos3d.calcularUParalela(puntosFinales[i][2], vectorProyeccion[2]);
            double x = graficos3d.calcularXParalela(puntosFinales[i][0], u, vectorProyeccion[0]);
            double y = graficos3d.calcularYParalela(puntosFinales[i][1], u, vectorProyeccion[1]);

            if(tx == 0.5) {
                posicionamiento = 320;
            } else if(tx == 0.75) {
                posicionamiento = 160;
            } else if(tx == 1.125) {
                posicionamiento = -80;
            } else if(tx == 1.6875) {
                posicionamiento = -442;
            } else if(tx == 2.53125) {
                posicionamiento = -985;
            } else if(tx == 3.796875) {
                posicionamiento = -1790; 
            } else if(tx == 5.6953125) {
                posicionamiento = -3000;
            } else if(tx == 8.5){
                posicionamiento = -4800;
            }

            puntosXY.add(new Puntos((int)((x) + (posicionamiento)), (int)((y/4) + 200)));
        }

        dibujarCaras(puntosXY, image);  

        return image;
    }

    private void dibujarCaras(ArrayList<Puntos> puntosXY, BufferedImage image) {
        
        int[][] cara = {
            { puntosXY.get(0).x, puntosXY.get(0).y },
            { puntosXY.get(1).x, puntosXY.get(1).y },
            { puntosXY.get(2).x, puntosXY.get(2).y },
            { puntosXY.get(3).x, puntosXY.get(3).y }
        };

        graficos2d.fillPolygon(cara, Color.BLACK, image);
        
        int[][] cara2 = {
            { puntosXY.get(6).x, puntosXY.get(6).y },
            { puntosXY.get(7).x, puntosXY.get(7).y },
            { puntosXY.get(8).x, puntosXY.get(8).y },
            { puntosXY.get(9).x, puntosXY.get(9).y }
        };
        
        graficos2d.fillPolygon(cara2, Color.GRAY, image);


        int[][] cara3 = {
            { puntosXY.get(4).x, puntosXY.get(4).y },
            { puntosXY.get(5).x, puntosXY.get(5).y },
            { puntosXY.get(7).x, puntosXY.get(7).y },
            { puntosXY.get(6).x, puntosXY.get(6).y }
        };

        graficos2d.fillPolygon(cara3, Color.WHITE, image);
        
        int[][] cara4 = {
            { puntosXY.get(13).x, puntosXY.get(13).y },
            { puntosXY.get(14).x, puntosXY.get(14).y },
            { puntosXY.get(12).x, puntosXY.get(12).y },
            { puntosXY.get(13).x, puntosXY.get(13).y },
        };
        
        graficos2d.fillPolygon(cara4, Color.GRAY, image);

        int[][] cara5 = {
            { puntosXY.get(10).x, puntosXY.get(10).y },
            { puntosXY.get(11).x, puntosXY.get(11).y },
            { puntosXY.get(12).x, puntosXY.get(12).y },
            { puntosXY.get(13).x, puntosXY.get(13).y }
        };

        graficos2d.fillPolygon(cara5, Color.WHITE, image);
        
        int[][] cara6 = {
            { puntosXY.get(16).x, puntosXY.get(16).y },
            { puntosXY.get(1).x, puntosXY.get(1).y },
            { puntosXY.get(0).x, puntosXY.get(0).y },
            { puntosXY.get(15).x, puntosXY.get(15).y }
        };
        
        graficos2d.fillPolygon(cara6, Color.BLACK, image);

        int[][] cara7 = {
            { puntosXY.get(18).x, puntosXY.get(18).y },
            { puntosXY.get(16).x, puntosXY.get(16).y },
            { puntosXY.get(15).x, puntosXY.get(15).y },
            { puntosXY.get(17).x, puntosXY.get(17).y }
        };

        graficos2d.fillPolygon(cara7, Color.BLACK, image);
        
        int[][] cara8 = {
            { puntosXY.get(20).x, puntosXY.get(20).y },
            { puntosXY.get(18).x, puntosXY.get(18).y },
            { puntosXY.get(17).x, puntosXY.get(17).y },
            { puntosXY.get(19).x, puntosXY.get(19).y }
        };

        graficos2d.fillPolygon(cara8, Color.BLACK, image);
        
        int[][] cara9 = {
            { puntosXY.get(22).x, puntosXY.get(22).y },
            { puntosXY.get(20).x, puntosXY.get(20).y },
            { puntosXY.get(19).x, puntosXY.get(19).y },
            { puntosXY.get(21).x, puntosXY.get(21).y }
        };

        graficos2d.fillPolygon(cara9, Color.BLACK, image);

        int[][] cara10 = {
            { puntosXY.get(24).x, puntosXY.get(24).y },
            { puntosXY.get(22).x, puntosXY.get(22).y },
            { puntosXY.get(21).x, puntosXY.get(21).y },
            { puntosXY.get(23).x, puntosXY.get(23).y }
        };

        graficos2d.fillPolygon(cara10, Color.BLACK, image);
        
        int[][] cara11 = {
            { puntosXY.get(26).x, puntosXY.get(26).y },
            { puntosXY.get(24).x, puntosXY.get(24).y },
            { puntosXY.get(23).x, puntosXY.get(23).y },
            { puntosXY.get(25).x, puntosXY.get(25).y }
        };
       
        graficos2d.fillPolygon(cara11, Color.BLACK, image);

  
        int[][] cara12 = {
            { puntosXY.get(28).x, puntosXY.get(28).y },
            { puntosXY.get(26).x, puntosXY.get(26).y },
            { puntosXY.get(25).x, puntosXY.get(25).y },
            { puntosXY.get(27).x, puntosXY.get(27).y }
        };

        graficos2d.fillPolygon(cara12, Color.BLACK, image);
  
        int[][] cara13 = {
            { puntosXY.get(30).x, puntosXY.get(30).y },
            { puntosXY.get(28).x, puntosXY.get(28).y },
            { puntosXY.get(27).x, puntosXY.get(27).y },
            { puntosXY.get(29).x, puntosXY.get(29).y }
        };

        graficos2d.fillPolygon(cara13, Color.BLACK, image);
  
        int[][] cara14 = {
            { puntosXY.get(32).x, puntosXY.get(32).y },
            { puntosXY.get(30).x, puntosXY.get(30).y },
            { puntosXY.get(29).x, puntosXY.get(29).y },
            { puntosXY.get(31).x, puntosXY.get(31).y }
        };

        graficos2d.fillPolygon(cara14, Color.BLACK, image);
        puntosXY.clear();

    }

}
