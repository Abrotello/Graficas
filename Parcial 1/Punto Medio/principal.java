import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class principal extends JFrame{

    private BufferedImage buffer;

    private int x, y, dx, dy, xend, p, incE, incNE;

    //Coordenadas punto A
    private int[] puntoA = {100, 100};
    
    //Coordenadas punto B
    private int[] puntoB = {30, 200};

    public principal(){
        PuntoMedio(puntoA[0], puntoA[1], puntoB[0], puntoB[1]);

        setTitle("Punto Medio");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        buffer = new BufferedImage(1,1,BufferedImage.TYPE_INT_RGB); 
    }

    public void PuntoMedio(int x1, int y1, int x2, int y2){

        dx = x2 - x1;
        dy = y2 - y1;

        p = 2*dy - dx;

        incE = 2*dy;
        incNE = 2*(dy-dx);

        if(x1 > x2){
            x = x2;
            y = y2;
            xend = x1;
        }else{
            x = x1;
            y = y1;
            xend = x2;
        }

    }
    
    public void paint(Graphics g) {
        super.paint(g);

        while(x <= xend) {
            System.out.println(x);
            System.out.println(y);
            putPixel(x, y, Color.BLACK);
            x++;

            if(p <= 0){
                p += incE;
            }else{
                y++;
                p += incNE;
            }
        }
    }

    public void putPixel(int x, int y, Color c) {
        buffer.setRGB(0,0,c.getRGB());
        this.getGraphics().drawImage(buffer, x, y,this);
    }


    public static void main(String[] args){
        new principal();
    }
}