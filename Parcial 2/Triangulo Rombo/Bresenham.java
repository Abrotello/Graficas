import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Bresenham {

    private BufferedImage buffer;
    private BufferedImage imagen;
    private Graphics gImagen;
    private int x, y, dx, dy, dx2, dy2,  incX, incY, d = 0;

    public Bresenham() {
        buffer = new BufferedImage(2, 2, BufferedImage.TYPE_INT_RGB);
    }

    public void algoritmo(int x1, int y1, int x2, int y2, Color color, BufferedImage imagen) {
        this.imagen = imagen;
        
        dx = Math.abs(x2 - x1);
        dy = Math.abs(y2 - y1);

        dx2 = 2*dx;
        dy2 = 2*dy;

        incX = x1 < x2 ? 1 : -1;    //Si x1<x2 entonces incX valdra 1, si x1>x2 incX valdra -1
        incY = y1 < y2 ? 1 : -1;    //Si y1<y2 entonces incY valdra 1, si y1>y2 incY valdra -1

        x = x1;
        y = y1;

        if(dx >= dy) {
            while(true) {
                if(x == x2)
                    break;
                x += incX;
                d += dy2;
                if(d > dx) {
                    y += incY;
                    d -= dx2;
                }

                putPixel(x, y, color);
                
            }
        } else {
            while(true) {
                if(y == y2)
                    break;
                y += incY;
                d += dx2;
                if(d > dy) {
                    x += incX;
                    d -= dy2;
                }

                putPixel(x, y, color);

            }
        }
    }

  
    public void floodFill(int seedX, int seedY, Color color) {

        if(imagen.getRGB(seedX, seedY) == color.getRGB()) {
            imagen.setRGB(seedX, seedY, Color.YELLOW.getRGB());

            floodFill(seedX-1, seedY-1, color);
            floodFill(seedX-1, seedY+1, color);
            floodFill(seedX+1, seedY-1, color);
            floodFill(seedX+1, seedY+1, color);
        }
    }

    public void scanLine(int x1, int y1, int x2, int yFinal) {
        int x1_ = x1;
        int x2_ = x2;

        while(yFinal < y1) {
            x1_ += 1;
            x2_ -= 1;
            System.out.println("x1: " + x1_ + " x2: " + x2_);
            algoritmo(x1_, y1, x2_, y1, Color.WHITE, imagen);
            y1--;
        }
    }
    
    public void putPixel(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        gImagen = imagen.getGraphics();
        gImagen.drawImage(buffer, x, y, null);
    }
}