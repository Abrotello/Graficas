import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Dibujo extends JPanel implements Runnable {
    BufferedImage image = null;
    
    int[] vectorProyeccion = { 8, 7, 20 };
    private int tx, ty, tz;

    //Puntos finales
    int[][] puntosFinales = new int[8][0];

    ArrayList<Puntos> puntosXY = new ArrayList<Puntos>();
    int xInicial, yInicial, xFinal, yFinal;
    
    
    
    private void dibujarCubo() {
        Cubo cubo = new Cubo();
        Transformacion3D transformacion3d = new Transformacion3D(tx, ty, tz);
        
        for(int i=0; i<puntosFinales.length; i++) {
            puntosFinales[i] = transformacion3d.trasladar(cubo.getPuntosX()[i], cubo.getPuntosY()[i], cubo.getPuntosZ()[i]);
            double u = calcularUParalela(puntosFinales[i][2], vectorProyeccion[2]);
            double x = calcularXParalela(puntosFinales[i][0], u, vectorProyeccion[0]);
            double y = calcularYParalela(puntosFinales[i][1], u, vectorProyeccion[1]);

            puntosXY.add(new Puntos((int) x, (int) y));
        }
        proyectar();
    } 

    private void proyectar() {
        
        int[][] cara = {
            { puntosXY.get(0).x, puntosXY.get(0).y },
            { puntosXY.get(1).x, puntosXY.get(1).y },
            { puntosXY.get(5).x, puntosXY.get(5).y },
            { puntosXY.get(4).x, puntosXY.get(4).y }
        };
       
        rellenar(cara, Color.WHITE);

        int[][] cara2 = {
            { puntosXY.get(0).x, puntosXY.get(0).y },
            { puntosXY.get(4).x, puntosXY.get(4).y },
            { puntosXY.get(6).x, puntosXY.get(6).y },
            { puntosXY.get(2).x, puntosXY.get(2).y }
        };

        rellenar(cara2, Color.BLUE);

        int[][] cara3 = {
            { puntosXY.get(4).x, puntosXY.get(4).y },
            { puntosXY.get(5).x, puntosXY.get(5).y },
            { puntosXY.get(7).x, puntosXY.get(7).y },
            { puntosXY.get(6).x, puntosXY.get(6).y }
        };

        rellenar(cara3, Color.RED);
        puntosXY.clear();
    }

    private void rellenar(int[][] puntos, Color color) {

        int longitud = puntos.length;
        xInicial = Integer.MAX_VALUE;
        yInicial = Integer.MAX_VALUE;
        xFinal = Integer.MIN_VALUE;
        yFinal = Integer.MIN_VALUE;

        for(int i=1; i<longitud; i++) {
            int x = puntos[i][0];
            int y = puntos[i][1];
            
            xInicial = Math.min(xInicial, x);
            yInicial = Math.min(yInicial, y);

            xFinal = Math.max(xFinal, x);
            yFinal = Math.max(yFinal, y);
        }

        int direccion = 0;
        int x = xInicial;
        int y = yInicial;

        while ( xInicial <= xFinal && yInicial <= yFinal ) {

            while ( x >= xInicial && x <= xFinal && y >= yInicial && y <= yFinal ) {

                if(estaDentro(x, y, puntos)) {
                    putPixel(x, y, color);
                }

                switch (direccion) {
                    case 0:
                        x++;
                        break;
                    case 1:
                        y++;
                        break;
                    case 2:
                        x--;
                        break;
                    case 3:
                        y--;
                        break;
                    default:
                        break;
                }
            }
            switch (direccion) {
                case 0:
                    yInicial++;
                    x--;
                    y++;
                    break;
                case 1:
                    xFinal--;
                    x--;
                    y--;
                    break;
                case 2:
                    yFinal--;
                    x++;
                    y--;
                    break;
                case 3:
                    xInicial++;
                    x++;
                    y++;
                    break;
            }
            direccion = (direccion + 1) % 4;
        }
    }

    private boolean estaDentro(int x, int y, int[][] puntos) {

        int longitud = puntos.length;
        boolean bandera = false;

        for(int i=0, j=longitud-1; i<longitud; j = i++) {

            int xi = puntos[i][0];
            int yi = puntos[i][1];
            int xj = puntos[j][0];
            int yj = puntos[j][1];


            if(((yi>y) != (yj > y)) && (x< (xj-xi) * (y-yi) / (yj-yi) + xi)  ) {
                bandera = !bandera;
            }

        }

        return bandera;
    }

    private double calcularUParalela(double z, int zp) {
        return (z / zp) * (-1);
    }

    private double calcularXParalela(double x1, double u, int xp) {
        return x1 + (xp * u);
    }

    private double calcularYParalela(double y1, double u, int zp) {
        return y1 + (zp * u);
    }

    private void putPixel(int x, int y, Color c) {
        image.setRGB(0, 0, c.getRGB());
        this.getGraphics().drawImage(image, x, y, this);
    }
 
    @Override
    public void paint(Graphics g) {
        if(image == null) {
            image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        }
        update(g);
    }

    @Override
    public void update(Graphics g) {
        super.paint(g);
        dibujarCubo();
        g.drawImage(image, 0, 0, this);
    }

    @Override
    public void run() {
        while (tx<50) {
            
            try {
                tx+=1;
                ty-=1;
                tz=1;
                repaint();
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
        }
    }
}
