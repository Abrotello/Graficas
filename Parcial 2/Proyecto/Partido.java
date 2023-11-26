import java.awt.Color;
import java.awt.image.BufferedImage;

public class Partido {
    
    CoordenadasPersonas jugadores = new CoordenadasPersonas();
    int i = jugadores.getJugador1()[0];
    int dx = 50;
    int dy = 1;

    int xPasos = jugadores.getJugador1()[0] + dx;
    int yPasos = jugadores.getJugador1()[1] + dy;

    BufferedImage buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
    Figuras monitos = new Figuras(buffer);
    
    Color carnita = new Color(252, 208, 180);

    public Partido() {
    }

    public BufferedImage jugarPartido(BufferedImage image) {

        
        image = moverMonitos(image);
        
        return image;
    } 

    private BufferedImage moverMonitos(BufferedImage image) {
        CoordenadasPersonas coordenadas = new CoordenadasPersonas();
        BufferedImage buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        Figuras porteros = new Figuras(buffer);

        if(i < xPasos) {
            porteros.circulo(i, coordenadas.getJugador1()[1], 4, 0, carnita, image);
            porteros.floodFill(i, coordenadas.getJugador1()[1], image.getRGB(i, coordenadas.getJugador1()[1]), image, carnita);
            i += 1;
            return image;
        } else {
            i = coordenadas.getJugador1()[0];
            return image;
        }
    }
}
