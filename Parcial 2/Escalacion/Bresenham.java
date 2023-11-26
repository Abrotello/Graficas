import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;


public class Bresenham extends JPanel implements Runnable{
    Coordenadas coordenadas = new Coordenadas();
    Escalacion escalacion;

    private int x1, x2, y1, y2, x3, y3, x4, y4;

    private int[] puntoFinalA = new int[2];
    private int[] puntoFinalB = new int[2];
    private int[] puntoFinalC = new int[2];
    private int[] puntoFinalD = new int[2];

    private int x, y, dx, dy, dx2, dy2,  incX, incY, d = 0; 

    private BufferedImage buffer;
    private Image imagen;
    private Graphics gImagen;

    private int distanciax1;
    private int distanciax2;
    private int distanciax1_;

    private int distanciay1;
    private int distanciay2;
    private int distanciay1_;
    private int coordenadasx1 = 0;
    private int coordenadasy1 = 0;

    private int coordenadasx2 = 0;
    private int coordenadasy2 = 0;

    private int coordenadasx3 = 0;
    private int coordenadasy3 = 0;

    private int coordenadasx4 = 0;
    private int coordenadasy4 = 0;

    Color contorno = Color.BLACK;
    Color relleno = Color.green;

    public Bresenham() {}

    public Bresenham(int x1_, int y1_, int x2_, int y2_, int x3_, int y3_, int x4_, int y4_) {
        propiedadesPanel();
        coordenadasIniciales();
        coordenadasFinales();
    }

    private void calcularDistancias() {

        if(distanciax1 > distanciax2 && distanciay1 > distanciay2) {
           if(distanciax1_ >= distanciax2) {
                coordenadasx1 = distanciax1_*x1/distanciax1;
                coordenadasx2 = distanciax1_*x2/distanciax1;
                coordenadasx3 = distanciax1_*x3/distanciax1;
                coordenadasx4 = distanciax1_*x4/distanciax1;
                distanciax1_--;
           } else {

            }

           if(distanciay1_ >= distanciay2) {
                coordenadasy1 = distanciay1_*y1/distanciay1;
                coordenadasy2 = distanciay1_*y2/distanciay1;
                coordenadasy3 = distanciay1_*y3/distanciay1;
                coordenadasy4 = distanciay1_*y4/distanciay1;
                distanciay1_--;
           } else {
                
           }
           
           algoritmo(coordenadasx1, coordenadasy1, coordenadasx2, coordenadasy2, contorno);
           algoritmo(coordenadasx1, coordenadasy1, coordenadasx3, coordenadasy3, contorno);
           algoritmo(coordenadasx3, coordenadasy3, coordenadasx4, coordenadasy4, contorno);
           algoritmo(coordenadasx2, coordenadasy2, coordenadasx4, coordenadasy4, contorno);
           rellenarCuadrado();
        
        } else if(distanciax2 > distanciax1 && distanciay2 > distanciay1){
            if(distanciax1_ <= distanciax2) {
                coordenadasx1 = distanciax1_*x1/distanciax1;
                coordenadasx2 = distanciax1_*x2/distanciax1;
                coordenadasx3 = distanciax1_*x3/distanciax1;
                coordenadasx4 = distanciax1_*x4/distanciax1;
                distanciax1_++;
            } else {

            }

            if(distanciay1_ <= distanciay2) {
                coordenadasy1 = distanciay1_*y1/distanciay1;
                coordenadasy2 = distanciay1_*y2/distanciay1;
                coordenadasy3 = distanciay1_*y3/distanciay1;
                coordenadasy4 = distanciay1_*y4/distanciay1;
                distanciay1_++;
            }
            algoritmo(coordenadasx1, coordenadasy1, coordenadasx2, coordenadasy2, contorno);
            algoritmo(coordenadasx1, coordenadasy1, coordenadasx3, coordenadasy3, contorno);
            algoritmo(coordenadasx3, coordenadasy3, coordenadasx4, coordenadasy4, contorno);
            algoritmo(coordenadasx2, coordenadasy2, coordenadasx4, coordenadasy4, contorno);
            rellenarCuadrado();
        }
    }

    private void propiedadesPanel() {
        //setBackground(Color.white);
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

                }
            }
    }

    private void dibujarCuadrado() {
        imagen = createImage(getWidth(), getHeight());
        
        escalar();
    }

    private void escalar() {
        calcularDistancias();
    }

    private void rellenarCuadrado() {
        int xInterna = coordenadasx1+1;
        int xInterna1 = coordenadasx2-2;

        int yInterna = coordenadasy1+2;
        int yInterna1 = coordenadasy3-1;

        while(yInterna < yInterna1) {
            algoritmo(xInterna, yInterna, xInterna1, yInterna, relleno);
            System.out.println(yInterna);
            yInterna++;
            if(yInterna == yInterna1) {
                break;
            }
        }

    }

    private void coordenadasFinales() {
        
        escalacion = new Escalacion(x1, y1, x2, y2, x3, y3, x4, y4);
        double[][] resultado = escalacion.escalar();
        puntoFinalA[0] = (int) resultado[0][0];
        puntoFinalA[1] = (int) resultado[0][1];

        puntoFinalB[0] = (int) resultado[1][0];
        puntoFinalB[1] = (int) resultado[1][1];

        puntoFinalC[0] = (int) resultado[2][0];
        puntoFinalC[1] = (int) resultado[2][1];

        puntoFinalD[0] = (int) resultado[3][0];
        puntoFinalD[1] = (int) resultado[3][1];
        
        System.out.println(puntoFinalA[0] + "," + puntoFinalA[1]);
        System.out.println(puntoFinalB[0] + "," + puntoFinalB[1]);
        System.out.println(puntoFinalC[0] + "," + puntoFinalC[1]);
        System.out.println(puntoFinalD[0] + "," + puntoFinalD[1]);

        distanciax1 = Math.abs(x1-x2);
        distanciax1_ = distanciax1;
        
        distanciax2 = Math.abs(puntoFinalA[0] - puntoFinalB[0]);

        distanciay1 = Math.abs(y1-y3);
        distanciay1_ = distanciay1;
        
        distanciay2 = Math.abs(puntoFinalA[1] - puntoFinalC[1]);
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