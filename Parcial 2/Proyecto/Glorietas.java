import java.awt.Color;
import java.awt.image.BufferedImage;

public class Glorietas {
    
    public Glorietas() {}

    public BufferedImage glorieta(BufferedImage imagen) {

        BufferedImage glorietas = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Figuras glorieta = new Figuras(glorietas);
        //glorieta.circulo(635, 350, 175, 0, Color.WHITE, imagen);
        glorieta.floodFillCirculo(635, 350, 170, imagen, Color.BLACK);
        glorieta.circulo(640, 345, 65, 0, Color.WHITE, imagen);
        glorieta.circulo(640, 345, 50, 0, Color.WHITE, imagen);
        //glorieta.circulo(640, 345, 20, 0, Color.WHITE, imagen);
        
        return imagen;
    }

}
