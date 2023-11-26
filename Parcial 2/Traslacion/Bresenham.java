import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;


public class Bresenham extends JPanel implements Runnable{
    Coordenadas coordenadas = new Coordenadas();
    Traslacion traslacion;

    private int x1, x2, y1, y2, x3, y3, x4, y4;

    private int[] puntoFinalA = new int[2];
    private int[] puntoFinalB = new int[2];
    private int[] puntoFinalC = new int[2];
    private int[] puntoFinalD = new int[2];

    private int x, y, dx, dy, dx2, dy2,  incX, incY, d = 0; 

    private BufferedImage buffer;
    private Image imagen = createImage(getWidth(), getHeight());
    private Graphics gImagen;

    Color contorno = Color.BLACK;
    Color relleno = Color.BLUE;

    public Bresenham() {}

    public Bresenham(int x1_, int y1_, int x2_, int y2_, int x3_, int y3_, int x4_, int y4_) {
        propiedadesPanel();
        coordenadasIniciales();
        coordenadasFinales();
    }

    private void propiedadesPanel() {
        setBackground(Color.white);
        buffer = new BufferedImage(2, 2, BufferedImage.TYPE_INT_RGB);
    }

    private void coordenadasIniciales() {
        x1 = coordenadas.getX1();
        x2 = coordenadas.getX2();
        x3 = coordenadas.getX3();
        x4 = coordenadas.getX4();

        y1 = coordenadas.getY1();
        y2 = coordenadas.getY2();
        y3 = coordenadas.getY3();
        y4 = coordenadas.getY4();
    }

    private void algoritmo(int x1_, int y1_, int x2_, int y2_, Color c) {

        dx = Math.abs(x2_ - x1_);
        dy = Math.abs(y2_ - y1_);

        dx2 = 2*dx;
        dy2 = 2*dy;

        incX = x1_ < x2_ ? 1 : -1;    //Si x1<x2 entonces incX valdra 1, si x1>x2 incX valdra -1
        incY = y1_ < y2_ ? 1 : -1;    //Si y1<y2 entonces incY valdra 1, si y1>y2 incY valdra -1

        x = x1_;
        y = y1_;

        if(dx >= dy) {
            while(true) {
                if(x == x2_)
                    break;
                x += incX;
                d += dy2;
                if(d > dx) {
                    y += incY;
                    d -= dx2;
                }

                putPixel(x, y, c);

                //puntosX1.add(x);
                //puntosY1.add(y);
                
            }
        } else {
            while(true) {
                if(y == y2_)
                    break;
                y += incY;
                d += dx2;
                if(d > dy) {
                    x += incX;
                    d -= dy2;
                }

                putPixel(x, y, c);
                //puntosX2.add(x);
                //puntosY2.add(y);
            }
        }

        /*int indice = 0;

        if(dx >= dy) {
            for(int i=x1_; i<x2_; i++) {
                putPixel(puntosX1.get(indice), puntosY1.get(indice), c);
                indice++;
            }
        } else {
            for(int i=y1_; i<y2_; i++) {
                putPixel(puntosX2.get(indice), puntosY2.get(indice), c);
                indice++;
            }
        } */
    }

    private void dibujarCuadrado() {
        imagen = createImage(getWidth(), getHeight());
        traslacion();
    }

    private void traslacion() {

        if(x1 < puntoFinalA[0] && y1 < puntoFinalA[1] && x2 < puntoFinalB[0] && y2 < puntoFinalB[1] && x3 < puntoFinalC[0] && y3 < puntoFinalC[1] && x4 < puntoFinalD[0] && y4 < puntoFinalD[1]) {
            algoritmo(x1, y1, x2, y2, contorno);
            algoritmo(x1, y1, x3, y3, contorno);
            algoritmo(x2, y2, x4, y4, contorno);
            algoritmo(x3, y3, x4, y4, contorno);
            rellenarCuadrado();

            x1 += 1;
            y1 += 1;

            x2 += 1;
            y2 += 1;

            x3 += 1;
            y3 += 1;

            x4 += 1;
            y4 += 1;

        } else {
            x1 = coordenadas.getX1();
            y1 = coordenadas.getY1();

            x2 = coordenadas.getX2();
            y2 = coordenadas.getY2();

            x3 = coordenadas.getX3();
            y3 = coordenadas.getY3();

            x4 = coordenadas.getX4();
            y4 = coordenadas.getY4();
        }
    }

    private void rellenarCuadrado() {
        int xInterna = x1+1;
        int xInterna1 = x2-2;

        int yInterna = y1+2;
        int yInterna1 = y3-1;

        while(yInterna < yInterna1) {
            algoritmo(xInterna, yInterna, xInterna1, yInterna, relleno);
            yInterna++;
        }

    }

    private void coordenadasFinales() {
        traslacion = new Traslacion(x1, y1, x2, y2, x3, y3, x4, y4);
        int[][] resultado = traslacion.trasladar();
        puntoFinalA[0] = resultado[0][0];
        puntoFinalA[1] = resultado[0][1];

        puntoFinalB[0] = resultado[1][0];
        puntoFinalB[1] = resultado[1][1];

        puntoFinalC[0] = resultado[2][0];
        puntoFinalC[1] = resultado[2][1];

        puntoFinalD[0] = resultado[3][0];
        puntoFinalD[1] = resultado[3][1];
    }

    public void putPixel(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        gImagen = imagen.getGraphics();
        gImagen.drawImage(buffer, x, y, this);
    }

    @Override
    public void paint(Graphics g) {  
        super.paint(g);
        dibujarCuadrado();
        g.drawImage(imagen, 0, 0, this);
    }

    @Override
    public void run() {

        while (true) {

            try {
                repaint();
                Thread.sleep(10);

            } catch (InterruptedException e) {
                e.getStackTrace();
            }
        }
    }
}