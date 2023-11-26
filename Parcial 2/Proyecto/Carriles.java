import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Carriles {
    Color blanco = Color.WHITE;

    public Carriles() {}

    public BufferedImage carril(BufferedImage imagen) {
        CoordenadasCarriles coordenadas = new CoordenadasCarriles();
        BufferedImage lineasAmarillas = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        
        Figuras divisiones = new Figuras(lineasAmarillas);
        Color amarilla = new Color(210, 201, 0, 100);

        //Carril 1                                  x1                            y1                            x2                          y2
        divisiones.bresenham(coordenadas.getCarril1()[0], coordenadas.getCarril1()[1], coordenadas.getCarril1()[2], coordenadas.getCarril1()[3], blanco, imagen);
        divisiones.bresenham(coordenadas.getCarril1()[4], coordenadas.getCarril1()[5], coordenadas.getCarril1()[6], coordenadas.getCarril1()[7], blanco, imagen);
        divisiones.rellenarRectangulo(coordenadas.getCarril1()[0], coordenadas.getCarril1()[1], coordenadas.getCarril1()[4], coordenadas.getCarril1()[7], amarilla);
        
        //Carril 2
        divisiones.bresenham(coordenadas.getCarril2()[0], coordenadas.getCarril2()[1], coordenadas.getCarril2()[2], coordenadas.getCarril2()[3], blanco, imagen);
        divisiones.bresenham(coordenadas.getCarril2()[4], coordenadas.getCarril2()[5], coordenadas.getCarril2()[6], coordenadas.getCarril2()[7], blanco, imagen);
        divisiones.rellenarRectangulo(coordenadas.getCarril2()[0]+1, coordenadas.getCarril2()[1], coordenadas.getCarril2()[4], coordenadas.getCarril2()[7], amarilla);

        //Carril 3
        divisiones.bresenham(coordenadas.getCarril3()[0], coordenadas.getCarril3()[1], coordenadas.getCarril3()[2], coordenadas.getCarril3()[3], blanco, imagen);
        divisiones.bresenham(coordenadas.getCarril3()[4], coordenadas.getCarril3()[5], coordenadas.getCarril3()[6], coordenadas.getCarril3()[7], blanco, imagen);
        divisiones.rellenarRectangulo(coordenadas.getCarril3()[0]+1, coordenadas.getCarril3()[1], coordenadas.getCarril3()[2], coordenadas.getCarril3()[7], amarilla);

        //Carril 4
        divisiones.bresenham(coordenadas.getCarril4()[0], coordenadas.getCarril4()[1], coordenadas.getCarril4()[2], coordenadas.getCarril4()[3], blanco, imagen);
        divisiones.bresenham(coordenadas.getCarril4()[4], coordenadas.getCarril4()[5], coordenadas.getCarril4()[6], coordenadas.getCarril4()[7], blanco, imagen);
        divisiones.rellenarRectangulo(coordenadas.getCarril4()[0], coordenadas.getCarril4()[1], coordenadas.getCarril4()[4], coordenadas.getCarril4()[7], amarilla);

        //Carril 5
        divisiones.bresenham(coordenadas.getCarril5()[0], coordenadas.getCarril5()[1], coordenadas.getCarril5()[2], coordenadas.getCarril5()[3], blanco, imagen);
        divisiones.bresenham(coordenadas.getCarril5()[4], coordenadas.getCarril5()[5], coordenadas.getCarril5()[6], coordenadas.getCarril5()[7], blanco, imagen);
        divisiones.rellenarRectangulo(coordenadas.getCarril5()[0], coordenadas.getCarril5()[1], coordenadas.getCarril5()[4], coordenadas.getCarril5()[7], amarilla);

        //Carril 6
        divisiones.bresenham(coordenadas.getCarril6()[0], coordenadas.getCarril6()[1], coordenadas.getCarril6()[2], coordenadas.getCarril6()[3], blanco, imagen);
        divisiones.bresenham(coordenadas.getCarril6()[4], coordenadas.getCarril6()[5], coordenadas.getCarril6()[6], coordenadas.getCarril6()[7], blanco, imagen);
        divisiones.rellenarRectangulo(coordenadas.getCarril6()[0], coordenadas.getCarril6()[1], coordenadas.getCarril6()[2], coordenadas.getCarril6()[7], amarilla);


        return imagen;
    }

    public BufferedImage separaciones(BufferedImage imagen) {
        CoordenadasSeparaciones coordenadas = new CoordenadasSeparaciones();
        BufferedImage buffer = new BufferedImage(4, 4, BufferedImage.TYPE_INT_RGB);
        Figuras separaciones = new Figuras(buffer);

        separaciones.bresenham(coordenadas.getSeparacion1()[0], coordenadas.getSeparacion1()[1], coordenadas.getSeparacion1()[2], coordenadas.getSeparacion1()[3], blanco, imagen);
        separaciones.bresenham(coordenadas.getSeparacion2()[0], coordenadas.getSeparacion2()[1], coordenadas.getSeparacion2()[2], coordenadas.getSeparacion2()[3], blanco, imagen);
        separaciones.bresenham(coordenadas.getSeparacion3()[0], coordenadas.getSeparacion3()[1], coordenadas.getSeparacion3()[2], coordenadas.getSeparacion3()[3], blanco, imagen);
        separaciones.bresenham(coordenadas.getSeparacion4()[0], coordenadas.getSeparacion4()[1], coordenadas.getSeparacion4()[2], coordenadas.getSeparacion4()[3], blanco, imagen);
        
        separaciones.bresenham(coordenadas.getSeparacion5()[0], coordenadas.getSeparacion5()[1], coordenadas.getSeparacion5()[2], coordenadas.getSeparacion5()[3], blanco, imagen);
        separaciones.bresenham(coordenadas.getSeparacion6()[0], coordenadas.getSeparacion6()[1], coordenadas.getSeparacion6()[2], coordenadas.getSeparacion6()[3], blanco, imagen);
        separaciones.bresenham(coordenadas.getSeparacion7()[0], coordenadas.getSeparacion7()[1], coordenadas.getSeparacion7()[2], coordenadas.getSeparacion7()[3], blanco, imagen);
        separaciones.bresenham(coordenadas.getSeparacion8()[0], coordenadas.getSeparacion8()[1], coordenadas.getSeparacion8()[2], coordenadas.getSeparacion8()[3], blanco, imagen);
        
        separaciones.bresenham(coordenadas.getSeparacion9()[0], coordenadas.getSeparacion9()[1], coordenadas.getSeparacion9()[2], coordenadas.getSeparacion9()[3], blanco, imagen);
        separaciones.bresenham(coordenadas.getSeparacion10()[0], coordenadas.getSeparacion10()[1], coordenadas.getSeparacion10()[2], coordenadas.getSeparacion10()[3], blanco, imagen);
        separaciones.bresenham(coordenadas.getSeparacion11()[0], coordenadas.getSeparacion11()[1], coordenadas.getSeparacion11()[2], coordenadas.getSeparacion11()[3], blanco, imagen);
        separaciones.bresenham(coordenadas.getSeparacion12()[0], coordenadas.getSeparacion12()[1], coordenadas.getSeparacion12()[2], coordenadas.getSeparacion12()[3], blanco, imagen);
        
        separaciones.bresenham(coordenadas.getSeparacion13()[0], coordenadas.getSeparacion13()[1], coordenadas.getSeparacion13()[2], coordenadas.getSeparacion13()[3], blanco, imagen);
        separaciones.bresenham(coordenadas.getSeparacion14()[0], coordenadas.getSeparacion14()[1], coordenadas.getSeparacion14()[2], coordenadas.getSeparacion14()[3], blanco, imagen);
        separaciones.bresenham(coordenadas.getSeparacion15()[0], coordenadas.getSeparacion15()[1], coordenadas.getSeparacion15()[2], coordenadas.getSeparacion15()[3], blanco, imagen);
        separaciones.bresenham(coordenadas.getSeparacion16()[0], coordenadas.getSeparacion16()[1], coordenadas.getSeparacion16()[2], coordenadas.getSeparacion16()[3], blanco, imagen);
        
        separaciones.bresenham(coordenadas.getSeparacion17()[0], coordenadas.getSeparacion17()[1], coordenadas.getSeparacion17()[2], coordenadas.getSeparacion17()[3], blanco, imagen);
        separaciones.bresenham(coordenadas.getSeparacion18()[0], coordenadas.getSeparacion18()[1], coordenadas.getSeparacion18()[2], coordenadas.getSeparacion18()[3], blanco, imagen);
        separaciones.bresenham(coordenadas.getSeparacion19()[0], coordenadas.getSeparacion19()[1], coordenadas.getSeparacion19()[2], coordenadas.getSeparacion19()[3], blanco, imagen);
        separaciones.bresenham(coordenadas.getSeparacion20()[0], coordenadas.getSeparacion20()[1], coordenadas.getSeparacion20()[2], coordenadas.getSeparacion20()[3], blanco, imagen);
        
        separaciones.bresenham(coordenadas.getSeparacion21()[0], coordenadas.getSeparacion21()[1], coordenadas.getSeparacion21()[2], coordenadas.getSeparacion21()[3], blanco, imagen);
        separaciones.bresenham(coordenadas.getSeparacion22()[0], coordenadas.getSeparacion22()[1], coordenadas.getSeparacion22()[2], coordenadas.getSeparacion22()[3], blanco, imagen);
        separaciones.bresenham(coordenadas.getSeparacion23()[0], coordenadas.getSeparacion23()[1], coordenadas.getSeparacion23()[2], coordenadas.getSeparacion23()[3], blanco, imagen);
        separaciones.bresenham(coordenadas.getSeparacion24()[0], coordenadas.getSeparacion24()[1], coordenadas.getSeparacion24()[2], coordenadas.getSeparacion24()[3], blanco, imagen);
        
        
        
        return imagen;
    }

    public Image uniones(Image image) {
        return image;
    }
}
